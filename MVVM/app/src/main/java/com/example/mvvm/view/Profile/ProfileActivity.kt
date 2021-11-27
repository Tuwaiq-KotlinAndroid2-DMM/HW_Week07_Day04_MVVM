package com.example.mvvm.view.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm.R
import com.example.mvvm.databinding.ActivityProfileBinding
import com.example.mvvm.model.User
import com.squareup.picasso.Picasso

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding=ActivityProfileBinding.inflate(layoutInflater)


        var user= intent.getSerializableExtra("User") as User


        binding.textViewProEmail.text=user.email
        binding.textViewProUser.text=user.username
        Picasso.get().load(user.photo).into(binding.imageView2)




        setContentView(binding.root)
    }
}