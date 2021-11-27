package com.example.mvvm.view.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.R
import com.example.mvvm.databinding.ActivityHomeBinding
import com.example.mvvm.view.login.LoginViewModel

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding=ActivityHomeBinding.inflate(layoutInflater)
        binding.mRecyclerView.layoutManager=LinearLayoutManager(this)



        val vm: HomeViewModel by viewModels()
        vm.getUsers().observeForever {
            binding.mRecyclerView.adapter=Home_Adapter(it)
        }



        setContentView(binding.root)
    }
}