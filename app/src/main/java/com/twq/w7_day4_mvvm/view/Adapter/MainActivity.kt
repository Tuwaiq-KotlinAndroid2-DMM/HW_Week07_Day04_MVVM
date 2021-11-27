package com.twq.w7_day4_mvvm.view.Adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.model.User

class MainActivity : AppCompatActivity() {
    var recyclerView:RecyclerView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()
        prepereRecyclerView()
    }

    private fun connectViews(){
        recyclerView= findViewById(R.id.recycler)
    }

    private fun prepereRecyclerView(){
        val array;ArrayList<User>() =ArrayList()
        array.add(User("beba@gmail.com","232","Asd",R.drawable.img,"beba"))
        array.add(User("khaled@gmail.com","232","Asd",R.drawable.img,"khaled"))
        array.add(User("mohamed@gmail.com","232","Asd",R.drawable.img,"mohamed"))
        array.add(User("sager@gmail.com","232","Asd",R.drawable.img,"sager"))
        array.add(User("gadoo@gmail.com","232","Asd",R.drawable.img,"gadoo"))


        val customAdapter:CustomAdapter= CustomAdapter(array)
        recyclerView?.adapter=customAdapter
    }
}