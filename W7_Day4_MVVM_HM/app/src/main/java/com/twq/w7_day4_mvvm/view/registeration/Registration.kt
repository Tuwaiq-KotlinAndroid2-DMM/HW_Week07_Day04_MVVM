package com.twq.w7_day4_mvvm.view.registeration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.databinding.ActivityLoginBinding
import com.twq.w7_day4_mvvm.view.login.LoginActivity

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val binding = ActivityLoginBinding.inflate(layoutInflater)


        var emailEditText = findViewById<TextView>(R.id.editTextEmail)
        var passwordEditText = findViewById<TextView>(R.id.editTextPasswordRegi)
        var BtnReg = findViewById<TextView>(R.id.buttonLogin)
        var TextviewHaveNewAccount=findViewById<TextView>(R.id.textViewLogin)
        TextviewHaveNewAccount.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }



        // Checking if the input in form is valid
        fun validateInput(): Boolean {
            if (emailEditText.text.toString().equals("")) {
                passwordEditText.setError("Please Enter Password ")
                return false
            }
            return true
        }
        setContentView(binding.root)
    }
}
