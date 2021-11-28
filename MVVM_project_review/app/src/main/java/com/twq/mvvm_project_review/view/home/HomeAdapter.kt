package com.twq.mvvm_project_review.view.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.twq.mvvm_project_review.databinding.HomeListItemRowBinding
import com.twq.mvvm_project_review.model.User
import com.twq.mvvm_project_review.view.details.DetailsActivity

class HomeAdapter(var data: List<User>): RecyclerView.Adapter<HomeHolder>() {
    lateinit var binding: HomeListItemRowBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
         binding = HomeListItemRowBinding.inflate(LayoutInflater.from(parent.context))

        val v = binding.root
        return HomeHolder(v)

    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        val currentUser = data[position]
        binding.apply {
            textViewUsernameRow.text = currentUser.username
            textViewEmailRow.text = currentUser.email
            Picasso.get().load(currentUser.photo).into(imageView2)
        }

        holder.itemView.setOnClickListener {
            val i = Intent(it.context, DetailsActivity::class.java)
                .putExtra("user",currentUser)
            it.context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
       return data.size
    }

}
class HomeHolder (v: View): RecyclerView.ViewHolder(v){

}