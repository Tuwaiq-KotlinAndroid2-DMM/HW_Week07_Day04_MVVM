package com.twq.projecttest.view.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.squareup.picasso.Picasso
import com.twq.projecttest.R
import com.twq.projecttest.databinding.ActivityLoginBinding
import com.twq.projecttest.model.User
import com.twq.projecttest.view.home.HomeActivity
import com.twq.projecttest.view.login.LoginViewModel

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var user = intent.getSerializableExtra("user") as User
        var textViewUsername = findViewById<TextView>(R.id.textViewUsername)
        var textViewEmail = findViewById<TextView>(R.id.textViewEmail)
        var profilePhoto = findViewById<ImageView>(R.id.imageViewProfilePhoto)

        textViewUsername.text = user.username
        textViewEmail.text = user.email
        Picasso.get().load(user.photo).placeholder(R.drawable.ic_launcher_background).into(profilePhoto)

    }
}


