package com.example.mvvm.view.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.mvvm.R
import com.example.mvvm.databinding.ActivityRegisterBinding
import com.example.mvvm.view.Home.HomeActivity
import com.example.mvvm.view.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        var binding=ActivityRegisterBinding.inflate(layoutInflater)





        binding.buttonRegister.setOnClickListener {
            val vm: RegisterViewModel by viewModels()
            vm.register( binding.EditTextRegEmail.text.toString(),binding.EditTextRegUsername.text.toString(),binding.editTextRegPass.text.toString(),"https://cdn.fakercloud.com/avatars/terrorpixel_128.jpg")
                .observe(this,{
                    if(it){
                        startActivity(Intent(this, LoginActivity::class.java))
                    }else{
                        Toast.makeText(this, "Register failed!", Toast.LENGTH_SHORT).show()
                    }
                })


        }
        setContentView(binding.root)
    }
}