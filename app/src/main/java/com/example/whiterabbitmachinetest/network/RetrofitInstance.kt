package com.example.whiterabbitmachinetest.network

import com.example.whiterabbitmachinetest.utlis.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val API: Api by lazy {
        retrofit.create(Api::class.java)
    }

}