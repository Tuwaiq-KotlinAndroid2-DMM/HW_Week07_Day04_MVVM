package com.twq.w7_day4_mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.model.User

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        var name = findViewById<TextView>(R.id.name)
        var email = findViewById<TextView>(R.id.email)
        var photo = findViewById<ImageView>(R.id.photo)
        var intent = intent.getSerializableExtra("User") as User
        name.text = intent.username
        email.text = intent.email
        Picasso.get().load(intent.photo).into(photo)
    }
}