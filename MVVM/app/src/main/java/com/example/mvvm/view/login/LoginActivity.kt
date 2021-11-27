package com.example.mvvm.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.mvvm.R
import com.example.mvvm.databinding.ActivityLoginBinding
import com.example.mvvm.view.Home.HomeActivity
import com.example.mvvm.view.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityLoginBinding.inflate(layoutInflater)



        binding.buttonLogin.setOnClickListener {


            val vm:LoginViewModel by viewModels()
            vm.login(binding.textEditUsername.text.toString(),binding.textEditPass.text.toString())

                .observe(this,{
                    if(it){
                        startActivity(Intent(this,HomeActivity::class.java))
                    }else{
                         Toast.makeText(this, "wrong username & password!", Toast.LENGTH_SHORT).show()
                    }
                })

        }

        binding.textViewSignUp.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))

        }


        setContentView(binding.root)
    }
}