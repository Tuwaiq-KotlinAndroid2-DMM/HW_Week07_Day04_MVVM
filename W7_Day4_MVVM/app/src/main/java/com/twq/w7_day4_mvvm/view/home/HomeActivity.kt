package com.twq.w7_day4_mvvm.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.twq.w7_day4_mvvm.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityHomeBinding.inflate(layoutInflater)

        val vm: HomeViewModel by viewModels()

        binding.mRV.layoutManager = LinearLayoutManager(this)
        vm.getUsers().observe(this,{
            binding.mRV.adapter=UserAdapter(it)
        })
        setContentView(binding.root)
    }
}