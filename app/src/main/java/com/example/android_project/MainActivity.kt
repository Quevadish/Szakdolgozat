package com.example.android_project


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button: Button = findViewById(R.id.madarhangok)
        button.setOnClickListener {
            val intent = Intent(this, Madarhangok::class.java)
            startActivity(intent)
        }

        val button2: Button = findViewById(R.id.erdekessegek)
        button2.setOnClickListener {
            val intent = Intent(this, Erdekessegek::class.java)
            startActivity(intent)
        }

        val button3: Button = findViewById(R.id.kvizkerdes)
        button3.setOnClickListener {
            val intent = Intent(this, Kviz::class.java)
            startActivity(intent)
        }

    }
}