package com.twq.w7_day4_mvvm.view.registeration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.twq.w7_day4_mvvm.databinding.ActivityRegisterationBinding
import com.twq.w7_day4_mvvm.view.login.LoginActivity

class RegisterationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterationBinding.inflate(layoutInflater)

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