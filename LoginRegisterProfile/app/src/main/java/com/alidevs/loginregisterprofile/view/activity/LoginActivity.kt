package com.alidevs.loginregisterprofile.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alidevs.loginregisterprofile.databinding.ActivityLoginBinding
import com.alidevs.loginregisterprofile.model.UserModel
import com.alidevs.loginregisterprofile.repository.UserRepository
import com.alidevs.loginregisterprofile.viewmodel.LoginViewModel
import com.alidevs.loginregisterprofile.viewmodel.ViewModelFactory.Companion.viewModelFactory
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

	private lateinit var binding: ActivityLoginBinding
	private lateinit var loginViewModel: LoginViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityLoginBinding.inflate(layoutInflater)
		setContentView(binding.root)

		checkUserLoggedIn()
		val userRepository = UserRepository()

		loginViewModel =
			ViewModelProvider(this, viewModelFactory { LoginViewModel(userRepository) }).get(
				LoginViewModel::class.java
			)

		binding.loginButton.setOnClickListener { onLoginButtonPressed() }
		binding.dontHaveAccountTextView.setOnClickListener { onDontHaveAccountTextViewPressed() }

		loginViewModel.userLiveData.observe(this) { user ->
			if (user != null) {
				Toast.makeText(this, "User ${user.email} found", Toast.LENGTH_SHORT).show()
				saveUserObject(user)
				val intent = Intent(this, HomeActivity::class.java)
				intent.putExtra("user", user)
				startActivity(intent)
			} else {
				Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT).show()
			}
		}
	}

	private fun onDontHaveAccountTextViewPressed() {
		val intent = Intent(this, RegisterActivity::class.java)
		startActivity(intent)
	}

	private fun onLoginButtonPressed() {
		val email = binding.emailEditText.text.toString()
		val password = binding.passwordEditText.text.toString()

		CoroutineScope(Dispatchers.IO).launch {
			loginViewModel.userLogin(email, password)
		}
	}

	private fun saveUserObject(user: UserModel) {
		val sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE)
		val editor = sharedPreferences.edit()
		val gson = Gson()

		val json = gson.toJson(user)
		editor.putString("user", json)

		editor.apply()
	}

	private fun checkUserLoggedIn() {
		val sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE)
		val gson = Gson()
		val json = sharedPreferences.getString("user", "")
		val user = gson.fromJson(json, UserModel::class.java)

		if (user != null) {
			val intent = Intent(this, HomeActivity::class.java)
			intent.putExtra("user", user)
			startActivity(intent)
		}
	}
}
