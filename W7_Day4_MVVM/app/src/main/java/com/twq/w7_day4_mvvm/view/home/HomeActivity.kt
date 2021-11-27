package com.twq.w7_day4_mvvm.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twq.w7_day4_mvvm.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val viewModel:HomeViewModel by viewModels()
        var uRecyclerView=findViewById<RecyclerView>(R.id.uRecyclerView)
        uRecyclerView.layoutManager= LinearLayoutManager(this)
        viewModel.getAllUsers().observe(this,{list ->
            uRecyclerView.adapter=UserAdapter(list)
        })

    }
}