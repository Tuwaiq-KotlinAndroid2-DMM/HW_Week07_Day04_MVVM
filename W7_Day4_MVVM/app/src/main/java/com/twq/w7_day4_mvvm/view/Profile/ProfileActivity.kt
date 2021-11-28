package com.twq.w7_day4_mvvm.view.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.databinding.ActivityProfileBinding
import com.twq.w7_day4_mvvm.model.User

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)
        //val binding = ActivityProfileBinding.inflate(layoutInflater)



        var nameProfile=findViewById<TextView>(R.id.TextInputNameProfile)
        var emailProfile=findViewById<TextView>(R.id.TextInputEmailProfile)
        var imgProfile=findViewById<ImageView>(R.id.imageViewProfile)
        var user = intent.getSerializableExtra("user") as User

        nameProfile.text = user.username
        emailProfile.text = user.email
        Picasso.get().load(user.photo).into(imgProfile)

        //setContentView(binding.root)
    }

}