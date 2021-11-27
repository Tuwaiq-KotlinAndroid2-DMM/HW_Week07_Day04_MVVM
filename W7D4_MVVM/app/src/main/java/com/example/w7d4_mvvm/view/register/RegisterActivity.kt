package com.example.w7d4_mvvm.view.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.w7d4_mvvm.databinding.ActivityRegisterBinding
import com.example.w7d4_mvvm.view.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)

        val vm: RegisterViewModel by viewModels()

        binding.buttonRegister.setOnClickListener {
            vm.register(binding.tInputRegisterEmail.text.toString(),
            binding.tInputRegisterPassword.text.toString(),
            binding.tInputRegisterUsername.text.toString()).observe(this, {
                if (it)
                    startActivity(Intent(this, LoginActivity::class.java))
                else
                    Toast.makeText(this, "Failed to register", Toast.LENGTH_SHORT).show()
            })
        }

        setContentView(binding.root)
    }
}