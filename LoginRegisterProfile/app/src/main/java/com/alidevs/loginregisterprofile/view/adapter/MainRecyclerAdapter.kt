package com.alidevs.loginregisterprofile.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alidevs.loginregisterprofile.R
import com.alidevs.loginregisterprofile.databinding.UserRowBinding
import com.alidevs.loginregisterprofile.model.UserModel
import com.bumptech.glide.Glide

class MainRecyclerAdapter constructor(private var data: List<UserModel> = listOf()) : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {

    private lateinit var binding: UserRowBinding

	init { setHasStableIds(true) }

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val inflater = LayoutInflater.from(parent.context)
		binding = UserRowBinding.inflate(inflater, parent, false)

		return ViewHolder(binding.root)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bind(data[position])
	}

	override fun getItemCount(): Int {
		return data.size
	}

	fun setData(data: List<UserModel>) {
		this.data = data
		notifyDataSetChanged()
	}

	override fun getItemId(position: Int) = position.toLong()

	override fun getItemViewType(position: Int) = position

	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		fun bind(user: UserModel) = with(binding) {
			rowUserIdTextView.text = user.id
			rowUserUsernameTextView.text = user.username
			rowUserEmailTextView.text = user.email
			Glide
				.with(itemView.context)
				.load(user.photo)
				.placeholder(R.drawable.ic_launcher_background)
				.centerCrop()
				.into(rowUserPhotoImageView)

			itemView.setOnClickListener {
				onClick(user)
			}
		}

		private fun onClick(item: UserModel) {}
	}

}