package com.example.usingmvvm.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.usingmvvm.databinding.ActivityLoginBinding
import com.example.usingmvvm.view.Profile.ProfileActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityLoginBinding.inflate(layoutInflater)
        val vm: LoginViewModel by viewModels()
        binding.buttonLogon.setOnClickListener {

            vm.login(binding.TextInputUsername.text.toString(),binding.TPassword.text.toString()).observe(this,{
                if(it){
                    var username = binding.TextInputUsername.text.toString()
                    var intent = Intent(this,ProfileActivity::class.java)
                    intent.putExtra("username",username)
                    startActivity(intent)
                   // startActivity(Intent(this, ProfileActivity::class.java))
                }else{
                    Toast.makeText(this,"Wrong data",Toast.LENGTH_SHORT).show()
                    println("Wrong data")
                }
            })
        }

        setContentView(binding.root)
    }
}