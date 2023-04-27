package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

@Suppress("DEPRECATION")
class Kviz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kviz)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

       val startbutton: Button = findViewById(R.id.btn_start)
       startbutton.setOnClickListener {
            val intent = Intent(this, Kvizkerdesek::class.java)
           startActivity(intent)
        }

    }
}