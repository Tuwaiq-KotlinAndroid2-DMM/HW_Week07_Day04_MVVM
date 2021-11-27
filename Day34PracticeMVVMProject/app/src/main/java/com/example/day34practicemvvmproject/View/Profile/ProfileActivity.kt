package com.example.day34practicemvvmproject.View.Profile

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.day34practicemvvmproject.Model.User
import com.example.day34practicemvvmproject.Util.Helper
import com.example.day34practicemvvmproject.View.Login.LoginActivity
import com.example.day34practicemvvmproject.databinding.ActivityProfileBinding
import com.squareup.picasso.Picasso

class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)

        var sharedPref = this.getSharedPreferences("mvvm", Context.MODE_PRIVATE)
        val user = Helper().getLoginSession(sharedPref)

        Picasso.get().load(Uri.parse(user.photo)).into(binding.imageViewProfile)

        binding.textViewProfileUsername.text = user.username
        binding.textViewProfileEmail.text = user.email

        setContentView(binding.root)
    }
}