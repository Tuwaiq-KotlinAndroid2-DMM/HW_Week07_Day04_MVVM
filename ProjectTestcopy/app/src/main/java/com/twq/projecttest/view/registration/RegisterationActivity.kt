package com.twq.projecttest.view.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.twq.projecttest.R
import com.twq.projecttest.model.User
import com.twq.projecttest.view.MainActivity
import com.twq.projecttest.view.home.HomeActivity
import com.twq.projecttest.view.login.LoginViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeration)

        val vm: RegistrationViewModel by viewModels()
        var username = findViewById<EditText>(R.id.editTextNameReg)
        var password = findViewById<EditText>(R.id.editTextPasswordReg)
        var registerButton = findViewById<Button>(R.id.buttonRegister)

        registerButton.setOnClickListener {
        vm.register(username.text.toString(),password.text.toString()).observe(this,{
            if(it){
                startActivity(Intent(this, HomeActivity::class.java))
            }
        })
    }

    }
}