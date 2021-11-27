package com.twq.w7_day4_mvvm.view.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.model.User

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var users=intent.getSerializableExtra("User") as User
        var textViewUserName=findViewById<TextView>(R.id.textViewUserNameInProfile)
        var textViewEmailProfil=findViewById<TextView>(R.id.textViewUserEmailInProfile)
        var ProfileImg=findViewById<ImageView>(R.id.imageViewProfileImg)


        textViewUserName.text=users.username
        textViewEmailProfil.text=users.email
        Picasso.get().load(users.photo).into(ProfileImg)
    }
}