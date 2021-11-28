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
import com.twq.w7_day4_mvvm.profile.profileActivity

class UserAdapter(var data:List<User>): RecyclerView.Adapter<UserHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user, parent, false)

        return UserHolder(v)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.textViewName.text = data[position].username
        holder.textViewEmail.text = data[position].email
        Picasso.get().load(data[position].photo).into(holder.Avatar)
        var context = holder.textViewName.context

        holder.itemView.setOnClickListener {
            var intent= Intent(context, profileActivity::class.java)
                .putExtra("User",data[position])
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

}

class UserHolder(v: View): RecyclerView.ViewHolder(v){

    var textViewName=v.findViewById<TextView>(R.id.textViewName)
    var textViewEmail=v.findViewById<TextView>(R.id.textViewEmail)
    var Avatar=v.findViewById<ImageView>(R.id.imageViewAvatar)


}
