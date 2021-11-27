package com.twq.projecttest.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.twq.projecttest.R
import com.twq.projecttest.databinding.ActivityLoginBinding
import com.twq.projecttest.view.MainActivity
import com.twq.projecttest.view.home.HomeActivity
import com.twq.projecttest.view.profile.ProfileActivity
import com.twq.projecttest.view.registration.RegisterationActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        val vm:LoginViewModel by viewModels()
        binding.buttonLogin.setOnClickListener {
            vm.login(binding.editTextNameLogin.text.toString(),binding.editTextPasswordLogin.text.toString())
                .observe(this,{
                    if(it){
                        startActivity(Intent(this, HomeActivity::class.java))
                    }else{
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                })
        }
        binding.buttonReg.setOnClickListener {
            startActivity(Intent(this, RegisterationActivity::class.java))
        }
        setContentView(binding.root)
    }
}