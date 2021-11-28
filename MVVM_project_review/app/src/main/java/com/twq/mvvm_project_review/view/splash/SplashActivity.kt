package com.twq.mvvm_project_review.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.twq.mvvm_project_review.R
import com.twq.mvvm_project_review.databinding.ActivitySplashBinding
import com.twq.mvvm_project_review.view.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)


        Handler().postDelayed({

            startActivity(Intent(this,LoginActivity::class.java))
            this.finish()
        },3000)



        setContentView(binding.root)
    }
}