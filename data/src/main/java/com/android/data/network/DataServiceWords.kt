package com.android.data.network

import com.android.data.entity.model.remote.Word
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Remote API contract for getting word list.
 * It can be implemented by a class that represents fake remote API calls.
 */
interface DataServiceWords {

    @GET("words.json")
    fun words(): Single<List<Word>>

}