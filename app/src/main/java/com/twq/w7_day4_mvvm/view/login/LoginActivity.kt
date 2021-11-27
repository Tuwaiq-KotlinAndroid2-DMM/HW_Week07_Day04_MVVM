package com.twq.w7_day4_mvvm.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityLoginBinding.inflate(layoutInflater)

        val vm:LoginViewModel by viewModels()

        binding.button.setOnClickListener {
             vm.login(binding.tinputusername.text.toString(),binding.tnputpassword.textAlignment.toString())
                 .observe(this,{
                     if (it)
                         startActivity(Intent(this,))
                 })
        }

        setContentView(binding.root)
    }
}