package com.amvlabs.csquiz

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class APIClient {
    val baseURL = "https://reqres.in/"
    var retrofit: Retrofit? = null

     fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }

}