package com.twq.w7_day4_mvvm.view.UserAdapter

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
import com.twq.w7_day4_mvvm.view.Profile.Profile

class UserAdapter(var data:List<User>):RecyclerView.Adapter<userHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userHolder {
        var v=LayoutInflater.from(parent.context).inflate(R.layout.user_row,parent,false)
        return userHolder(v)
    }

    override fun onBindViewHolder(holder: userHolder, position: Int) {
      holder.textViewName.text=data[position].username
        holder.textViewEmail.text=data[position].email
        Picasso.get().load(data[position].photo).into(holder.imageViewAvatar)

        holder.itemView.setOnClickListener {
            println(data[position].username)
            val intent= Intent(holder.itemView.context,Profile::class.java)
            intent.putExtra("User", data[position])
            holder.itemView.context.startActivity(intent)

        }
    }


    override fun getItemCount(): Int {
        return data.size
    }
}



class userHolder(view: View):RecyclerView.ViewHolder(view){

    var textViewName=view.findViewById<TextView>(R.id.textViewUserName)
    var textViewEmail=view.findViewById<TextView>(R.id.textViewEmail)
    var imageViewAvatar=view.findViewById<ImageView>(R.id.imageViewAvatar)
}