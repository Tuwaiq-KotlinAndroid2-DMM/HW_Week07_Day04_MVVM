package com.alidevs.loginregisterprofile.view.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alidevs.loginregisterprofile.R
import com.alidevs.loginregisterprofile.databinding.ActivityHomeBinding
import com.alidevs.loginregisterprofile.model.UserModel
import com.alidevs.loginregisterprofile.repository.UserRepository
import com.alidevs.loginregisterprofile.view.adapter.MainRecyclerAdapter
import com.alidevs.loginregisterprofile.viewmodel.HomeViewModel
import com.alidevs.loginregisterprofile.viewmodel.ViewModelFactory.Companion.viewModelFactory

class HomeActivity : AppCompatActivity() {

	private lateinit var binding: ActivityHomeBinding
	private lateinit var viewModel: HomeViewModel
	private lateinit var adapter: MainRecyclerAdapter
	private lateinit var user: UserModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityHomeBinding.inflate(layoutInflater)
		setContentView(binding.root)

		user = intent.getSerializableExtra("user") as UserModel

		val userRepository = UserRepository()
		viewModel = ViewModelProvider(this, viewModelFactory { HomeViewModel(userRepository) }).get(
			HomeViewModel::class.java
		)

		adapter = MainRecyclerAdapter()
		binding.recyclerView.adapter = adapter

		viewModel.usersLiveData.observe(this) { usersList ->
			if (usersList.isNotEmpty()) {
				adapter.setData(usersList)
				Log.i("HomeActivity", "usersList: $usersList")
			} else {
				Toast.makeText(this, "Users' list is empty!", Toast.LENGTH_SHORT).show()
			}
		}

		viewModel.getAllUsers()

		menuSetup()
	}

	override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.home_menu, menu)
		return super.onPrepareOptionsMenu(menu)
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		when(item.itemId) {
			R.id.toolbarProfileItem -> segueToProfile()
			R.id.toolbarLogoutItem -> logout()
		}
		return super.onOptionsItemSelected(item)
	}

	private fun logout() {
		val sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)
		val editor = sharedPreferences.edit()
		editor.clear()
		editor.apply()
		finish()
	}

	private fun segueToProfile() {
		val intent = Intent(this, ProfileActivity::class.java)
		intent.putExtra("user", user)
		startActivity(intent)
	}

	private fun menuSetup() {
		binding.toolbar.title = "Home"
		binding.toolbar.setTitleTextColor(Color.WHITE)
		setSupportActionBar(binding.toolbar)
	}

}