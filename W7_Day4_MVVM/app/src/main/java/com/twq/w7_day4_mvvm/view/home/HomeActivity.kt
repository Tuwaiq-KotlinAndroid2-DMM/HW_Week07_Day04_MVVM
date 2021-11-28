package com.twq.w7_day4_mvvm.view.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.view.Profile.ProfileActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        var homeRecyclerView = findViewById<RecyclerView>(R.id.recyclerViewHome)
        homeRecyclerView.layoutManager = LinearLayoutManager(this)
        var listOfUsers = mutableListOf<User>()
        homeRecyclerView.adapter=HomeAdapter(listOfUsers)

        val viewmodel:HomeViewModel by viewModels()
        viewmodel.getUsers().observe(this,{list ->
            homeRecyclerView.adapter=HomeAdapter(list)
        })
        //var profileBottun=findViewById<Button>(R.id.buttonProfile)

//        profileBottun.setOnClickListener {
//            val intent= Intent(this,ProfileActivity::class.java)
//            intent.putExtra("user", )
//            startActivity(intent)
//        }

    }
}