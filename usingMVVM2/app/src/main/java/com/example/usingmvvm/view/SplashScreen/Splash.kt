package com.example.usingmvvm.view.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.usingmvvm.R
import com.example.usingmvvm.databinding.ActivityMainBinding
import com.example.usingmvvm.databinding.ActivitySplashBinding
import com.example.usingmvvm.view.login.LoginActivity

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivitySplashBinding.inflate(layoutInflater)

        Handler().postDelayed({
            startActivity(Intent(this,LoginActivity::class.java))
        },3000)


        setContentView(binding.root)
    }
}