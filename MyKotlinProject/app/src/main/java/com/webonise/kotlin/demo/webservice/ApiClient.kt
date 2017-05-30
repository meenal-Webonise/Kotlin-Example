package com.webonise.kotlin.demo.webservice

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory.create
import java.util.concurrent.TimeUnit

/**
 * Class ApiClient created on 5/22/17.
 */
public class ApiClient {
    private val TIMEOUT = 120

    private var retrofit: retrofit2.Retrofit? = null

     fun getClient(): retrofit2.Retrofit {
        if (retrofit == null) {
            val okHttpClient = okhttp3.OkHttpClient().newBuilder()
                    .connectTimeout(TIMEOUT.toLong(), java.util.concurrent.TimeUnit.SECONDS)
                    .readTimeout(TIMEOUT.toLong(), java.util.concurrent.TimeUnit.SECONDS)
                    .writeTimeout(TIMEOUT.toLong(), java.util.concurrent.TimeUnit.SECONDS)
                    .build()
            retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl("http://openlibrary.org")
                    .addConverterFactory(create())
                    .client(okHttpClient)
                    .build()
        }
        return retrofit!!
    }
}