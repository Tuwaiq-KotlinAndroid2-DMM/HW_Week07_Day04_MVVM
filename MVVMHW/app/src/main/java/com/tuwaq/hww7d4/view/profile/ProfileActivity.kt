package com.tuwaq.hww7d4.view.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.tuwaq.hww7d4.R
import com.tuwaq.hww7d4.model.User

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var photo =findViewById<ImageView>(R.id.imageViewPhot)
        var username =findViewById<TextView>(R.id.textViewuser)
        var email =findViewById<TextView>(R.id.textViewemai)
        var id =findViewById<TextView>(R.id.textViewid)




        var t = intent.getSerializableExtra("User") as User

        username.text= t.username
        email.text =t.email
        id.text=t.id

        Picasso.get().load(t.photo).into(photo)


    }
}