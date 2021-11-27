package com.twq.w7_day4_mvvm.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.view.UserAdapter.UserAdapter

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        var mRecyclerView = findViewById<RecyclerView>(R.id.mRecyclerView)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        var usersList = mutableListOf<User>()
        mRecyclerView.adapter=UserAdapter(usersList)

        val viewmodel:HomeViewModel by viewModels()
        viewmodel.getUsers().observe(this,{list ->
            mRecyclerView.adapter=UserAdapter(list)
        })


// val viewModel:ProductViewModel by viewModels()
        //  viewModel.getProducts().observe(this,{list->
        //            pRecyclerView.adapter=ProductAdapter(list)
        //        })

   }
}