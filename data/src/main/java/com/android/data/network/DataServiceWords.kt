package com.android.data.network

import com.android.data.entity.model.remote.Word
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

/**
 * Remote API contract for getting word list.
 * It can be implemented by a class that represents fake remote API calls.
 */
interface DataServiceWords {

    @GET("/7ac6cdb4bf5e032f4c737aaafe659b33/raw/baa9fe0d586082d85db71f346e2b039c580c5804/words.json")
    fun words(): Single<List<Word>>

}