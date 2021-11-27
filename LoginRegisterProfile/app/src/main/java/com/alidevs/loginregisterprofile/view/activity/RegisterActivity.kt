package com.alidevs.loginregisterprofile.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alidevs.loginregisterprofile.databinding.ActivityRegisterBinding
import com.alidevs.loginregisterprofile.model.UserModel
import com.alidevs.loginregisterprofile.repository.UserRepository
import com.alidevs.loginregisterprofile.viewmodel.RegisterViewModel
import com.alidevs.loginregisterprofile.viewmodel.ViewModelFactory.Companion.viewModelFactory
import com.google.gson.Gson

class RegisterActivity : AppCompatActivity() {

	private lateinit var binding: ActivityRegisterBinding
	private lateinit var viewModel: RegisterViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityRegisterBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val userRepository = UserRepository()

		viewModel =
			ViewModelProvider(this, viewModelFactory { RegisterViewModel(userRepository) }).get(
				RegisterViewModel::class.java
			)

		binding.alreadyRegisteredTextView.setOnClickListener { alreadyRegisteredButtonPressed() }
		binding.registerButton.setOnClickListener { registerButtonPressed() }

		viewModel.userLiveData.observe(this) { user ->
			if (user != null) {
				val intent = Intent(this, HomeActivity::class.java)
				saveUserObject(user)
				intent.putExtra("user", user)
				startActivity(intent)
				finish()
			}
		}
	}

	private val alreadyRegisteredButtonPressed: () -> Unit = {
		val intent = Intent(this, LoginActivity::class.java)
		startActivity(intent)
		finish()
	}

	private val registerButtonPressed: () -> Unit = {
		val username = binding.usernameEditText.text.toString()
		val password = binding.passwordEditText.text.toString()
		val email = binding.emailEditText.text.toString()
		val photo = binding.photoURLEditText.text.toString()
		val user = UserModel(email, "", password, photo, username)

		viewModel.userRegister(user)
	}

	private fun saveUserObject(user: UserModel) {
		val sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE)
		val editor = sharedPreferences.edit()
		val gson = Gson()

		val json = gson.toJson(user)
		editor.putString("user", json)

		editor.apply()
	}
}