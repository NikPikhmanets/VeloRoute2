package com.pikhmanets.veloroute2.les.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {
    @GET(".")
    fun getModel(): Call<String>
}