package com.twq.w7_day4_mvvm.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.model.User

class profileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var username = findViewById<TextView>(R.id.textViewUsername)
        var email = findViewById<TextView>(R.id.textViewpEmail)
        var photo = findViewById<ImageView>(R.id.imageViewPhoto)
        var intent = intent.getSerializableExtra("User") as User
        username.text = intent.username
        email.text = intent.email
        Picasso.get().load(intent.photo).into(photo)
    }
}