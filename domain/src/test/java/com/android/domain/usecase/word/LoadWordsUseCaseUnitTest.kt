package com.android.domain.usecase.word

import com.android.domain.common.TestUtil
import com.android.domain.common.mock
import com.android.domain.common.transformer.TestSTransformer
import com.android.domain.repository.WordRepository
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

/**
 * Created by hassanalizadeh on 25,June,2020
 */
@RunWith(JUnit4::class)
class LoadWordsUseCaseUnitTest {

    private val repository: WordRepository = mock()
    private val useCase: LoadWordsUseCase = LoadWordsUseCase(repository, TestSTransformer())


    @Test
    fun `load 10 words from DB`() {
        //GIVEN
        val count = 10
        `when`(repository.loadWordsByRange(count)).thenReturn(Single.just(TestUtil.getWords()))

        //WHEN
        useCase.invoke(count)
            .test()
            .assertValue(TestUtil.getWords())
            .assertComplete()

        // THEM
        verify(repository).loadWordsByRange(count)
    }

}