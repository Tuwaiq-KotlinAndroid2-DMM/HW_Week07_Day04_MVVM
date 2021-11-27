package com.example.day34practicemvvmproject.View.MainView

import android.content.ContentValues.TAG
import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.day34practicemvvmproject.Model.User
import com.example.day34practicemvvmproject.databinding.ListItemUsersBinding
import com.squareup.picasso.Picasso

class HomeAdapter(var context: Context, var data: List<User>) : RecyclerView.Adapter<HomeHolder>() {

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val binding =
            ListItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        Log.d(TAG,"HomeAdapter: - onBindViewHolder: - : ${data[position].photo}")
        Picasso.get().load(Uri.parse(data[position].photo)).into(holder.binding.imageViewUserProfile)
        holder.binding.textViewUserEmail.text = data[position].email
        holder.binding.textViewUserUsername.text = data[position].username
    }
}

class HomeHolder(val binding: ListItemUsersBinding) : RecyclerView.ViewHolder(binding.root)