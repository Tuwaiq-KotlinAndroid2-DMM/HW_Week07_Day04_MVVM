package com.example.usingmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.usingmvvm.R
import com.example.usingmvvm.databinding.ActivityHomeBinding
import com.example.usingmvvm.view.Profile.ProfileViewModel
import com.example.usingmvvm.view.login.ProfileAdapter

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_home)

        val binding = ActivityHomeBinding.inflate(layoutInflater)
        val vm : HomeViewModel by viewModels()
        val pRecyclerView=findViewById<RecyclerView>(R.id.UserReyclerView)
        pRecyclerView.layoutManager= LinearLayoutManager(this)

        vm.getUserData().observe(this, {
            pRecyclerView.adapter = ProfileAdapter(it)
        })
        setContentView(binding.root)

    }
}