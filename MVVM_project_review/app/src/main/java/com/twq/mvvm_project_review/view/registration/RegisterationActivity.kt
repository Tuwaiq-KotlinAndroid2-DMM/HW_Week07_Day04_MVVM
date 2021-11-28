package com.twq.mvvm_project_review.view.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.viewModels
import com.twq.mvvm_project_review.R
import com.twq.mvvm_project_review.databinding.ActivityRegisterationBinding
import com.twq.mvvm_project_review.view.home.HomeActivity

class RegisterationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterationBinding.inflate(layoutInflater)
        val vm: RegisterationViewModel by viewModels()



        binding.buttonRegister.setOnClickListener {
            val email = binding.textinputEmailRegister.text.toString()
            val password = binding.textinputPasswordRegister.text.toString()
            val username = binding.textinputUsernameRegister.text.toString()
            if (!(Patterns.EMAIL_ADDRESS.matcher(email).matches())) {

                binding.textinputEmailRegister.error = "incorrect Email"
                binding.textinputEmailRegister.requestFocus()
                return@setOnClickListener

            }
            if (password.length <= 7) {
                binding.textinputPasswordRegister.error =
                    "password must be longer than 7 characters"
                binding.textinputPasswordRegister.requestFocus()
                return@setOnClickListener
            }
            if (username.isEmpty()) {
                binding.textinputUsernameRegister.error = "username is required"
                binding.textinputUsernameRegister.requestFocus()
                return@setOnClickListener
            }
            vm.addUser(null, username, email, password, null).observe(this,
                {
                    var i = Intent(this, HomeActivity::class.java)
                        .putExtra("user", it)
                    startActivity(i)
                })


        }




        setContentView(binding.root)
    }
}