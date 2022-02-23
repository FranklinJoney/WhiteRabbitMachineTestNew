package com.example.whiterabbitmachinetest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.whiterabbitmachinetest.R
import com.example.whiterabbitmachinetest.model.EmployeeModel
import com.example.whiterabbitmachinetest.model.EmployeeModelItem
import com.example.whiterabbitmachinetest.repository.Repository
import com.example.whiterabbitmachinetest.utlis.Constants.Companion.EMP_DETAILS
import com.example.whiterabbitmachinetest.viewmodel.MainViewModel
import com.example.whiterabbitmachinetest.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_screen.*
import kotlinx.android.synthetic.main.row_layout.*
import kotlinx.android.synthetic.main.row_layout.view.*
import retrofit2.Response

class DetailScreen : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val position = null
    private lateinit var employeeModel: EmployeeModelItem
    var myResponse: MutableLiveData<Response<EmployeeModel>> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)
        employeeModel = intent.getSerializableExtra(EMP_DETAILS) as EmployeeModelItem
        loadDetailData(position)
    }

    private fun loadDetailData(position: Any?) {


        Glide.with(this).load(employeeModel.profile_image).
        placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(employee_img_profile)
        emp_name_txt?.text = employeeModel?.username
        userName_txt?.text = employeeModel?.name
        phone_txt?.text = employeeModel?.phone
        email_address_txt?.text = employeeModel?.email
        phone_txt?.text = employeeModel?.phone

        /*val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        employeeModel = viewModel.getEmployeeModel()!!
        emp_name_txt?.text = employeeModel[position as Int].username.toString()*/

    }
}
