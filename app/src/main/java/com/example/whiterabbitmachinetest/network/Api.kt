package com.example.whiterabbitmachinetest.network


import com.example.whiterabbitmachinetest.model.EmployeeModel
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @GET("v2/5d565297300000680030a986")
    suspend fun getEmployeeData(): Response<EmployeeModel>

}