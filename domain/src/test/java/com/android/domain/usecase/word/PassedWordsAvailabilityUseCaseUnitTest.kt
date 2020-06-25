package com.android.domain.usecase.word

import com.android.domain.common.mock
import com.android.domain.common.transformer.TestCTransformer
import com.android.domain.repository.WordRepository
import com.android.domain.usecase.invoke
import io.reactivex.Completable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

/**
 * Created by hassanalizadeh on 25,June,2020
 */
@RunWith(JUnit4::class)
class PassedWordsAvailabilityUseCaseUnitTest {

    private val repository: WordRepository = mock()
    private val useCase: PassedWordsAvailabilityUseCase =
        PassedWordsAvailabilityUseCase(repository, TestCTransformer())


    @Test
    fun `check there is any passed for knowing user started the learning or not`() {
        //GIVEN
        `when`(repository.passedWordsAvailability()).thenReturn(Completable.complete())

        //WHEN
        useCase.invoke()
            .test()
            .assertComplete()

        // THEM
        verify(repository).passedWordsAvailability()
    }

}