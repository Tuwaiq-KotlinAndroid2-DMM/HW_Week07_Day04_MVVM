package com.twq.w7_day4_mvvm.view.Adapter

import android.util.Log.i
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.model.User

class CustomAdapter(var array: ArrayList<User>):RecyclerView.Adapter<CustomAdapter.DataHolder>() {
    //هذه الداله تقوم بتجهيز custom layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
         val dataHolder:DataHolder= DataHolder(LayoutInflater.from(parent.context)
             .inflate(R.layout.row,parent,false))
        return dataHolder
    }

    // تقوم بتغيير قيمه كل خليه
    override fun onBindViewHolder(holder:DataHolder, position: Int) {
        val user:User= array.get(position)

        holder.userImageView.setImageResource(user.photo)
        holder.userNameTextView.setText(user.username)
        holder.userCompanyTextView.setText(user.id)
    }

    //تحدد عدد مرات تكرار الخليه
    override fun getItemCount(): Int {
        return array.size

    }

    class DataHolder(view: View):RecyclerView.ViewHolder(view){
        val userImageView:ImageView= view.findViewById(R.id.imageuser)
        val userNameTextView:TextView=view.findViewById(R.id.txtuser)
        val userCompanyTextView:TextView=view.findViewById(R.id.txtcompany)
    }
}