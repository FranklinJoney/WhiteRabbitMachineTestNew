package com.example.whiterabbitmachinetest.repository

import com.example.whiterabbitmachinetest.network.RetrofitInstance
import com.example.whiterabbitmachinetest.model.EmployeeModel
import retrofit2.Response

class Repository {

    suspend fun getEmployee(): Response<EmployeeModel> {
        return RetrofitInstance.API.getEmployeeData()
    }

}