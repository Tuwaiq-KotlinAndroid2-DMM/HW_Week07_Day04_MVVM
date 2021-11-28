package com.twq.mvvm_project_review.view.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.twq.mvvm_project_review.R
import com.twq.mvvm_project_review.databinding.ActivityDetailsBinding
import com.twq.mvvm_project_review.model.User

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailsBinding.inflate(layoutInflater)

        supportActionBar!!.hide()
        val user = intent.getSerializableExtra("user") as User

        Picasso.get().load(user.photo).into(binding.imageViewUserDetails)
        binding.textViewUsername.text = user.username
        binding.textViewEmail.text = user.email






        setContentView(binding.root)
    }
}