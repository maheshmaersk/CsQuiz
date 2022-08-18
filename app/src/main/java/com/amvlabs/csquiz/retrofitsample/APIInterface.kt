package com.amvlabs.csquiz.retrofitsample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface APIInterface {

    @GET("/api/users?page=1")
    fun getUsersList(): Call<User>

    @GET
    fun getUsersDetails(@Url url: String): Call<UserDetails>
}