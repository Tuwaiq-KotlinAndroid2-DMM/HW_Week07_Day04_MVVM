package com.example.usingmvvm.view.login


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.usingmvvm.R
import com.example.usingmvvm.model.User
import com.squareup.picasso.Picasso


class ProfileAdapter(var data:List<User>): RecyclerView.Adapter<UserHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        var v=LayoutInflater.from(parent.context).inflate(R.layout.activity_profile,parent,false)
        return UserHolder(v)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.textViewemail.text= data[position].email
        holder.textViewUsername.text=data[position].username
        Picasso.get().load(data[position].photo).into(holder.imageUser)

    }

    override fun getItemCount(): Int {
        return data.size
    }

}

class UserHolder(v:View):RecyclerView.ViewHolder(v) {


    var textViewUsername = v.findViewById<TextView>(R.id.textViewUsername)
    var textViewemail = v.findViewById<TextView>(R.id.textViewEmail)
    var imageUser = v.findViewById<ImageView>(R.id.imageView)
}