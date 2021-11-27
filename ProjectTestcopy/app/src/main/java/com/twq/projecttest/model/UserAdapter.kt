package com.twq.projecttest.model

import android.content.Context
import android.content.Intent
import android.icu.number.NumberFormatter.with
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.twq.projecttest.R
import com.twq.projecttest.view.profile.ProfileActivity


class UserAdapter (var data: List<User>): RecyclerView.Adapter<UserHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_users,parent,false)
        return UserHolder(v)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.textViewName.text = data[position].username
        holder.textViewEmail.text = data[position].email
        Picasso.get().load(data[position].photo).placeholder(R.drawable.ic_launcher_background).into(holder.photo)

        holder.itemView.setOnClickListener {
            var intent = Intent(holder.itemView.context, ProfileActivity::class.java)
            intent.putExtra("user",data[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
class UserHolder(v: View): RecyclerView.ViewHolder(v){
    var textViewName = v.findViewById<TextView>(R.id.textViewListUsername)
    var textViewEmail = v.findViewById<TextView>(R.id.textViewListEmail)
    var photo = v.findViewById<ImageView>(R.id.imageViewListPhoto)


}