package com.example.day34practicemvvmproject.View.Splash

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.day34practicemvvmproject.R
import com.example.day34practicemvvmproject.Util.Helper
import com.example.day34practicemvvmproject.View.Login.LoginActivity
import com.example.day34practicemvvmproject.View.MainView.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var sharedPref = this.getSharedPreferences("mvvm", Context.MODE_PRIVATE)

        Handler(Looper.getMainLooper()).postDelayed({
            if (Helper().isLoggedIn(sharedPref) == true) {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }, 3000)
    }
}