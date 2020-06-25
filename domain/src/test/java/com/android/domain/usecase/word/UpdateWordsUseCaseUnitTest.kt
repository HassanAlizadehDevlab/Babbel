package com.android.domain.usecase.word

import com.android.domain.common.TestUtil
import com.android.domain.common.mock
import com.android.domain.common.transformer.TestCTransformer
import com.android.domain.repository.WordRepository
import io.reactivex.Completable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*

/**
 * Created by hassanalizadeh on 25,June,2020
 */
@RunWith(JUnit4::class)
class UpdateWordsUseCaseUnitTest {

    private val repository: WordRepository = mock()
    private val useCase: UpdateWordsUseCase = UpdateWordsUseCase(repository, TestCTransformer())


    @Test
    fun `update words with user responses`() {
        //GIVEN
        `when`(repository.updateWords(anyList())).thenReturn(Completable.complete())

        //WHEN
        useCase.invoke(TestUtil.getWords())
            .test()
            .assertComplete()

        // THEM
        verify(repository).updateWords(TestUtil.getWords())
    }

}