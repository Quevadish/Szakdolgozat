package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.android_project.KvizPackage.Kvizkerdesek

class Kviz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kviz)

        val startbutton: Button = findViewById(R.id.start)
        startbutton.setOnClickListener {
            val intent = Intent(this, Kvizkerdesek::class.java)
            startActivity(intent)
            finish()
        }

    }
}