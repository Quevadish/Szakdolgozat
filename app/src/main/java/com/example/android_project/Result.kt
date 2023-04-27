package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tv_score:TextView=findViewById(R.id.tc_score)
        val btn_finish:Button=findViewById(R.id.btn_finish)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tv_score.text = "A pontszámod $correctAnswers / $totalQuestions"

        btn_finish.setOnClickListener{
            startActivity(Intent(this, Kviz::class.java))
            finish()
        }

    }
}