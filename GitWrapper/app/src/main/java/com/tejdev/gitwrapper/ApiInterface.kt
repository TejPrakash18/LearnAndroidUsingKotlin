package com.tejdev.gitwrapper

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
//    @GET("\"/users/{username}\"")
//    fun getData(@Path("username") username: String): Call<DataModel>
@GET("/gimme")
fun getData(): Call<DataModel>

}