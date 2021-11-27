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
import com.twq.w7_day4_mvvm.view.profile

class UserHolder(v: View) : RecyclerView.ViewHolder(v) {
    var imagephoto = v.findViewById<ImageView>(R.id.imagephoto)
    var username = v.findViewById<TextView>(R.id.username)
    var Email = v.findViewById<TextView>(R.id.Email)

}

class UserAdapter(var data: List<User>) : RecyclerView.Adapter<UserHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return UserHolder(v)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        Picasso.get().load(data[position].photo).into(holder.imagephoto)
        holder.username.text = data[position].username
        holder.Email.text = data[position].email
        var context = holder.username.context





        holder.itemView.setOnClickListener {
            var intent= Intent(context,profile::class.java)
                .putExtra("User",data[position])
            context.startActivity(intent)
        }

    }


    override fun getItemCount(): Int {
        return data.size
    }


}
