package com.pikhmanets.veloroute2.retrofit


object Common {
    private val BASE_URL = "https://chargen-api.herokuapp.com/"

    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}