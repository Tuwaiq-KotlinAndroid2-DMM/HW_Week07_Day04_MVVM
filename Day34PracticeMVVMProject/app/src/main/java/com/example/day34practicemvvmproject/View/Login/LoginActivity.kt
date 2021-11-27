package com.example.day34practicemvvmproject.View.Login

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.day34practicemvvmproject.R
import com.example.day34practicemvvmproject.View.MainView.HomeActivity
import com.example.day34practicemvvmproject.View.Register.RegisterActivity
import com.example.day34practicemvvmproject.databinding.ActivityLoginBinding



class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        val viewModel: LoginViewModel by viewModels()

        binding.buttonLogin.setOnClickListener {

            var sharedPref = this.getSharedPreferences("mvvm", Context.MODE_PRIVATE)
            viewModel.login(sharedPref,
                binding.editTextEmail.text.toString(),
                binding.editTextPassword.text.toString()
            ).observe(this){
                Log.d(TAG,"LoginActivity - onCreate - login: $it")
                if (it == true){
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this,
                        getString(R.string.login_failed_empty),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        binding.buttonSignUp.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }

        setContentView(binding.root)

    }
}