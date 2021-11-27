package com.example.w7d4_mvvm.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.w7d4_mvvm.databinding.ActivityLoginBinding
import com.example.w7d4_mvvm.view.Home.HomeActivity
import com.example.w7d4_mvvm.view.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)

        val vm: LoginViewModel by viewModels()

        binding.buttonLogin.setOnClickListener {
            vm.login(binding.textInputUsername.text.toString(), binding.tInputPassword.text.toString())
                .observe(this, {
                    if (it){
                        startActivity(Intent(this, HomeActivity::class.java))
                    }
                    else{
                        Toast.makeText(this, "Wrong username or password!", Toast.LENGTH_SHORT).show()
                    }
                })
        }

        binding.textViewRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }


        setContentView(binding.root)
    }
}