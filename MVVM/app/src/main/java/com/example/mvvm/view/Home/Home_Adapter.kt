package com.example.mvvm.view.Home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.model.User
import com.example.mvvm.view.Profile.ProfileActivity
import com.squareup.picasso.Picasso

class Home_Adapter(var data:List<User>): RecyclerView.Adapter<UserHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        var v= LayoutInflater.from(parent.context).inflate(R.layout.user_list_row,parent,false)

        return UserHolder(v)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.textViewUserName.text= data[position].username
        holder.textViewEmail.text=data[position].email
        Picasso.get().load(data[position].photo).into(holder.avatar)

        holder.itemView.setOnClickListener {

                var intent= Intent(holder.itemView.context,ProfileActivity::class.java)
                intent.putExtra("User",data[position])

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


}

class UserHolder(v: View): RecyclerView.ViewHolder(v){

    var textViewUserName=v.findViewById<TextView>(R.id.textViewUserName)
    var textViewEmail=v.findViewById<TextView>(R.id.textViewEmail)
    var avatar=v.findViewById<ImageView>(R.id.imageViewAvatar)

}