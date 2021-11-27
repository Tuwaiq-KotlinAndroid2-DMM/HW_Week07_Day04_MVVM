package com.example.w7d4_mvvm.view.Home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.w7d4_mvvm.R
import com.example.w7d4_mvvm.model.User
import com.example.w7d4_mvvm.view.profile.ProfileActivity
import com.squareup.picasso.Picasso

class UserAdapter(var data: List<User>): RecyclerView.Adapter<UserHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_row_user, parent, false)
        return UserHolder(v)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.username.text = data[position].username
        holder.email.text = data[position].email
        Picasso.get().load(data[position].photo).into(holder.avatar)

        holder.itemView.setOnClickListener {
            var intent = Intent(holder.itemView.context, ProfileActivity::class.java)
            intent.putExtra("user", data[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class UserHolder(var v: View): RecyclerView.ViewHolder(v) {
    var username = v.findViewById<TextView>(R.id.row_username)
    var email = v.findViewById<TextView>(R.id.row_email)
    var avatar = v.findViewById<ImageView>(R.id.row_image)
}
