package com.example.whiterabbitmachinetest.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whiterabbitmachinetest.R
import com.example.whiterabbitmachinetest.model.EmployeeModel
import kotlinx.android.synthetic.main.row_layout.view.*
import java.util.*

class MyAdapter(private val onClickListener: OnClickListener) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(),Filterable{

    private var myList = EmployeeModel()
    private var searchList = EmployeeModel()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        myList[position].name?.let {
            (it.also { holder.itemView.userName_txt?.text = it })
        }
        myList[position].company?.let {
            (it.also { holder.itemView.company_title_txt?.text = it.name })
        }
        Glide.with(holder.itemView.context).load(myList[position].profile_image).
        placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(holder.itemView.imageView)
        holder.itemView.setOnClickListener {
            onClickListener.OnClick(myList[position])
        }
    }

    override fun getFilter(): Filter {

        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {

                val filteredList = EmployeeModel()

                if (constraint?.isBlank()?.or(constraint.isEmpty()) == true){
                    filteredList.addAll(searchList)
                }else{
                    val filterPattern = constraint.toString().toLowerCase(Locale.ROOT).trim()

                    searchList.forEach {
                        if (it.name.toLowerCase(Locale.ROOT).contains(filterPattern)){
                            filteredList.add(it)
                        }
                    }
                }
                val result = FilterResults()
                result.values = filteredList
                return result

            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                myList.clear()
                myList.addAll(results!!.values as EmployeeModel)
                notifyDataSetChanged()
            }
        }
    }

    fun setData(newList: EmployeeModel){
        myList = newList
        notifyDataSetChanged()
    }
}