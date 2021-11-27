package com.twq.projecttest.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.twq.projecttest.R
import com.twq.projecttest.databinding.ActivitySplashBinding
import com.twq.projecttest.view.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
        },(3000))
        setContentView(binding.root)
    }
}