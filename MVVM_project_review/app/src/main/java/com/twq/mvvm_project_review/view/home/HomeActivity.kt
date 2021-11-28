package com.twq.mvvm_project_review.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.twq.mvvm_project_review.R
import com.twq.mvvm_project_review.databinding.ActivityHomeBinding
import com.twq.mvvm_project_review.view.registration.RegisterationViewModel

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        val vm: HomeViewModel by viewModels()

        binding.homeRecyclerView.layoutManager = LinearLayoutManager(this)

        vm.getAllUsers().observe(this,{
            binding.homeRecyclerView.adapter = HomeAdapter(it)
        })






        setContentView(binding.root)
    }
}