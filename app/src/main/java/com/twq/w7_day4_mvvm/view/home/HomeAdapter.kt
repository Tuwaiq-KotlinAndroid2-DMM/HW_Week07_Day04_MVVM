package com.twq.w7_day4_mvvm.view.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.view.Profile.ProfileActivity


class HomeAdapter(var data:List<User>): RecyclerView.Adapter<Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var v= LayoutInflater.from(parent.context).inflate(R.layout.list,parent,false)
        return Holder(v)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.name.text = data[position].username
        holder.email.text = data[position].email
        Picasso.get().load(data[position].photo).into(holder.image)

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

private fun Intent.putExtra(s: String, user: User) {
    TODO("Not yet implemented")
}


class Holder(v: View):RecyclerView.ViewHolder(v){

    var name =v.findViewById<TextView>(R.id.textViewNameL)
    var email =v.findViewById<TextView>(R.id.textViewEmailL)
    var image =v.findViewById<ImageView>(R.id.imageViewL)



}