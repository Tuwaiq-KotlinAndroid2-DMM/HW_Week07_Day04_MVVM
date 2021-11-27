package com.example.hw_w7_d4.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_w7_d4.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val viewModel:HomeViewModel by viewModels()

//      var mTollBar = findViewById<Toolbar>(R.id.toolbar)
//        mTollBar.title="Users"
//        setSupportActionBar(mTollBar)



        var mRecyclerView=findViewById<RecyclerView>(R.id.RecyclerView)
        mRecyclerView.layoutManager=LinearLayoutManager(this)

        viewModel.getUser().observe(this,{list ->
            mRecyclerView.adapter=HomeAdapter(list)
        })

    }
}