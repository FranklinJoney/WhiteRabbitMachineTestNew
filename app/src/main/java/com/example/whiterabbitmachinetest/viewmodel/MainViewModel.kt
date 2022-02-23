package com.example.whiterabbitmachinetest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whiterabbitmachinetest.model.EmployeeModel
import com.example.whiterabbitmachinetest.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.text.FieldPosition

class MainViewModel(private val repository: Repository): ViewModel() {

    var myResponse: MutableLiveData<Response<EmployeeModel>> = MutableLiveData()

    fun getData(){
        viewModelScope.launch {
            val response = repository.getEmployee()
            myResponse.value = response
        }
    }

    fun getEmployeeModel()
    : EmployeeModel? {
        return myResponse.value?.body().let { it }
    }
}