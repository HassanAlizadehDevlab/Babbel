package com.android.domain.usecase.word

import android.accounts.NetworkErrorException
import com.android.domain.common.mock
import com.android.domain.common.transformer.TestCTransformer
import com.android.domain.repository.WordRepository
import com.android.domain.usecase.invoke
import io.reactivex.Completable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*

/**
 * Created by hassanalizadeh on 25,June,2020
 */
@RunWith(JUnit4::class)
class GetWordsUseCaseUnitTest {

    private val repository: WordRepository = mock()
    private val useCase: GetWordsUseCase = GetWordsUseCase(repository, TestCTransformer())


    @Test
    fun `get words`() {
        //GIVEN
        `when`(repository.getWords()).thenReturn(Completable.complete())

        //WHEN
        useCase.invoke()
            .test()
            .assertComplete()

        //THEN
        verify(repository).getWords()
        verify(repository, never()).checkWordsAvailability()
    }

    @Test
    fun `on remote API call failed but there are some words in DB`() {
        //GIVEN
        `when`(repository.getWords()).thenReturn(Completable.error(NetworkErrorException()))
        `when`(repository.checkWordsAvailability()).thenReturn(Completable.complete())

        //WHEN
        useCase.invoke()
            .test()
            .assertComplete()

        //THEN
        verify(repository).getWords()
        verify(repository).checkWordsAvailability()
    }

    @Test
    fun `on remote API call failed and Db is empty`() {
        //GIVEN
        `when`(repository.getWords()).thenReturn(Completable.error(NetworkErrorException()))
        `when`(repository.checkWordsAvailability()).thenReturn(
            Completable.error(
                IllegalStateException()
            )
        )

        //WHEN
        useCase.invoke()
            .test()
            .assertNotComplete()

        //THEN
        verify(repository).getWords()
        verify(repository).checkWordsAvailability()
    }

}