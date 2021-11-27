package com.twq.w7_day4_mvvm.view.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.databinding.ActivityProfileBinding
import com.twq.w7_day4_mvvm.model.User

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProfileBinding.inflate(layoutInflater)

        binding.cardViewProfile.setBackgroundResource(R.drawable.bottom_corners_bg)

        var user = intent.getSerializableExtra("user") as User

        binding.profileUsernameTV.text = user.username
        binding.profileEmailTV.text = user.email
        Picasso.get().load(user.photo).into(binding.profileImage)

        setContentView(binding.root)
    }
}