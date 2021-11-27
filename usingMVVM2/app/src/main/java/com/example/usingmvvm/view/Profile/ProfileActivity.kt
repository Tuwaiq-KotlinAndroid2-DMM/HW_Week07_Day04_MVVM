package com.example.usingmvvm.view.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.usingmvvm.R
import com.example.usingmvvm.model.User
import com.squareup.picasso.Picasso

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var username = findViewById<TextView>(R.id.textViewUsername)
        var email = findViewById<TextView>(R.id.textViewEmail)
        var avatar = findViewById<ImageView>(R.id.imageView)

        var intent = intent.getSerializableExtra("User") as User
        username.text = intent.username
        email.text = intent.email

        Picasso.get().load(intent.photo).into(avatar)


    }
}


