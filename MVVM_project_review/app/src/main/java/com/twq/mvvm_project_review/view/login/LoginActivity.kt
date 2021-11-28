package com.twq.mvvm_project_review.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.twq.mvvm_project_review.R
import com.twq.mvvm_project_review.databinding.ActivityLoginBinding
import com.twq.mvvm_project_review.view.home.HomeActivity
import com.twq.mvvm_project_review.view.registration.RegisterationActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)

        val vm : LoginViewModel by viewModels()

        binding.textViewRegister.setOnClickListener {
            startActivity(Intent(this,RegisterationActivity::class.java))
        }

        binding.buttonLogin.setOnClickListener {
           vm.login(binding.textinputUsername.text.toString(), binding.inputtextPassword.text.toString())
               .observe(this, {
                   if (it){
                       startActivity(Intent(this,HomeActivity::class.java))
                   }else {
                       Toast.makeText(this, "incorrect email or password", Toast.LENGTH_SHORT).show()
                   }
               }
               )
        }


        setContentView(binding.root)
    }
}