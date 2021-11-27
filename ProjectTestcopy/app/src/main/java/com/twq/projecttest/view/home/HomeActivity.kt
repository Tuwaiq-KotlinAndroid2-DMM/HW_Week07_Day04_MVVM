package com.twq.projecttest.view.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twq.projecttest.R
import com.twq.projecttest.model.UserAdapter


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var mRecyclerView = findViewById<RecyclerView>(R.id.uRecyclerView)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        val vm: HomeViewModel by viewModels()
        vm.getUserData().observe(this, {
            mRecyclerView.adapter = UserAdapter(it)
        })

    }

}




