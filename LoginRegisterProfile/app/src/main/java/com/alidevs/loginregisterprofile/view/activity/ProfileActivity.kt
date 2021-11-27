package com.alidevs.loginregisterprofile.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.alidevs.loginregisterprofile.R
import com.alidevs.loginregisterprofile.api.RetrofitService
import com.alidevs.loginregisterprofile.databinding.ActivityProfileBinding
import com.alidevs.loginregisterprofile.model.UserModel
import com.alidevs.loginregisterprofile.repository.UserRepository
import com.alidevs.loginregisterprofile.viewmodel.LoginViewModel
import com.bumptech.glide.Glide

class ProfileActivity : AppCompatActivity() {

	private lateinit var binding: ActivityProfileBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityProfileBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val user = intent.getSerializableExtra("user") as UserModel

		with(binding) {
			userIdTextView.text = user.id
			userUserameTextView.text = user.username
			userEmailTextView.text = user.email
			Glide
				.with(this@ProfileActivity)
				.load(user.photo)
				.placeholder(R.drawable.ic_launcher_background)
				.centerCrop()
				.into(userPhotoImageView)

		}
	}
}