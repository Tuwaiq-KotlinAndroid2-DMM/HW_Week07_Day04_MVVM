package com.tuwaq.hww7d4.view.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tuwaq.hww7d4.R
import com.tuwaq.hww7d4.model.User
import com.tuwaq.hww7d4.view.profile.ProfileActivity

class HomeAdapter (var data:List<User>):RecyclerView.Adapter<HomeHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        var v= LayoutInflater.from(parent.context).inflate(R.layout.user_custom_row,parent,false)
        return HomeHolder(v)

    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {

        var context = holder.cons.context
        holder.name.text=data[position].username
        holder.email.text=data[position].email
        Picasso.get().load(data[position].photo).into(holder.avatar)

        holder.cons.setOnClickListener {
            var i =Intent(context, ProfileActivity::class.java)
            i.putExtra("User",data[position])
            context.startActivity(i)

        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

class HomeHolder(v:View):RecyclerView.ViewHolder(v){

    var avatar =v.findViewById<ImageView>(R.id.imageViewAvatar)
    var name =v.findViewById<TextView>(R.id.textViewName)
    var email =v.findViewById<TextView>(R.id.TextViewEmail)
    var cons =v.findViewById<ConstraintLayout>(R.id.ConstraintLayout)



}