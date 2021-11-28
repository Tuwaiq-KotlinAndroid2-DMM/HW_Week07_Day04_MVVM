package com.twq.w7_day4_mvvm.view.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.model.User

class HomeAdapter (var data:List<User>): RecyclerView.Adapter<userHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userHolder {
        var v= LayoutInflater.from(parent.context).inflate(R.layout.list_row,parent,false)
        return userHolder(v)
    }

    override fun onBindViewHolder(holder: userHolder, position: Int) {
        holder.NameRow.text=data[position].username
        holder.EmailRow.text=data[position].email
        Picasso.get().load(data[position].photo).into(holder.imageViewRow)


    }


    override fun getItemCount(): Int {
        return data.size
    }
}



class userHolder(view: View):RecyclerView.ViewHolder(view){

    var NameRow=view.findViewById<TextView>(R.id.TextInputNameRow)
    var EmailRow=view.findViewById<TextView>(R.id.TextInputEmailRow)
    var imageViewRow=view.findViewById<ImageView>(R.id.imageViewRow)
}