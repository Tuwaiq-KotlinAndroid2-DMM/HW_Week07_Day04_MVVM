package com.twq.w7_day4_mvvm.view.registeration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.databinding.ActivityRegisterationBinding
import com.twq.w7_day4_mvvm.view.home.HomeActivity
import com.twq.w7_day4_mvvm.view.login.LoginActivity

class RegisterationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding1=ActivityRegisterationBinding.inflate(layoutInflater)

        val vmReg:RegisterationViewModel by viewModels()

        binding1.buttonSingin.setOnClickListener {

            vmReg.registertions(binding1.TextInputName.text.toString(),
                binding1.TextInputEmail.text.toString(),
                binding1.TextInputPassword.text.toString()).observe(this, {
                if (it)
                    startActivity(Intent(this, HomeActivity::class.java))
                else
                    Toast.makeText(this, "Failed to register", Toast.LENGTH_SHORT).show()
            })



        }
        setContentView(binding1.root)
    }
}