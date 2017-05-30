package com.webonise.kotlin.demo.webservice

/**
 * Class APIInterface created on 5/22/17.
 */
import com.webonise.kotlin.demo.models.BooksMainModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {


    @GET("/search.json")
    fun getBooksList(@Query("q") queryString: String)
            : Call<BooksMainModel>
}