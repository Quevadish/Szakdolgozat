package com.example.android_project

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat


@Suppress("DEPRECATION")
class Kvizkerdesek : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mAnswered = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kvizkerdesek)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        val tv_option_one: TextView = findViewById(R.id.tv_option_one)
        val tv_option_two: TextView = findViewById(R.id.tv_option_two)
        val tv_option_three: TextView = findViewById(R.id.tv_option_three)
        val tv_option_four: TextView = findViewById(R.id.tv_option_four)
        val btn_submit: Button = findViewById(R.id.btn_submit)


        mQuestionList = Constants.getQuestion()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }




    override fun onClick(v: View?) {
        val tv_option_one: TextView = findViewById(R.id.tv_option_one)
        val tv_option_two: TextView = findViewById(R.id.tv_option_two)
        val tv_option_three: TextView = findViewById(R.id.tv_option_three)
        val tv_option_four: TextView = findViewById(R.id.tv_option_four)
        val btn_submit: Button = findViewById(R.id.btn_submit)

        when (v?.id) {
            R.id.tv_option_one -> {
                if (!mAnswered) { // csak akkor válaszolhat, ha még nem válaszolt
                    selectedOptionView(tv_option_one, 1)
                    mSelectedOptionPosition = 1
                }
            }
            R.id.tv_option_two -> {
                if (!mAnswered) {
                    selectedOptionView(tv_option_two, 2)
                    mSelectedOptionPosition = 2
                }
            }
            R.id.tv_option_three -> {
                if (!mAnswered) {
                    selectedOptionView(tv_option_three, 3)
                    mSelectedOptionPosition = 3
                }
            }
            R.id.tv_option_four -> {
                if (!mAnswered) {
                    selectedOptionView(tv_option_four, 4)
                    mSelectedOptionPosition = 4
                }
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    Toast.makeText(this, "Válassz egy választ!", Toast.LENGTH_SHORT).show()
                    return
                }
                mAnswered = true // válaszadás után megváltoztatjuk az állapotot

                val question = mQuestionList?.get(mCurrentPosition - 1)
                if (question!!.correct != mSelectedOptionPosition) {
                    answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                } else {
                    mCorrectAnswers++
                }
                answerView(question!!.correct, R.drawable.correct_option_border_bg)

                if (mCurrentPosition == mQuestionList!!.size) {
                    btn_submit.text = "CÉL"
                } else {
                    btn_submit.text = "KÖVETKEZŐ KÉRDÉS"
                }
                mSelectedOptionPosition = 0

                Handler().postDelayed({
                    mCurrentPosition++
                    if (mCurrentPosition <= mQuestionList!!.size) {
                        setQuestion()
                    } else {
                        val intent = Intent(this, Result::class.java)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                        startActivity(intent)
                        finish()
                    }
                    mAnswered = false // visszaállítjuk az állapotot a következő kérdés előtt
                }, 1000)
            }
        }
    }


    private fun setQuestion() {

        val question = mQuestionList!!.get(mCurrentPosition - 1)

        val progressBar: ProgressBar = findViewById(R.id.progressbar)
        val tv_progress: TextView = findViewById(R.id.tv_progress)
        val tv_question: TextView = findViewById(R.id.tv_question)
        val iv_image: ImageView = findViewById(R.id.iv_image)
        val tv_option_one: TextView = findViewById(R.id.tv_option_one)
        val tv_option_two: TextView = findViewById(R.id.tv_option_two)
        val tv_option_three: TextView = findViewById(R.id.tv_option_three)
        val tv_option_four: TextView = findViewById(R.id.tv_option_four)
        val btn_submit: Button = findViewById(R.id.btn_submit)

        defeaultOptionsView()

        if (mCurrentPosition == mQuestionList!!.size) {
            btn_submit.text = "CÉL"
        } else {
            btn_submit.text = "KÉSZ"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()

        tv_question.text = question.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defeaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg
        )
    }

    private fun defeaultOptionsView() {


        val tv_option_one: TextView = findViewById(R.id.tv_option_one)
        val tv_option_two: TextView = findViewById(R.id.tv_option_two)
        val tv_option_three: TextView = findViewById(R.id.tv_option_three)
        val tv_option_four: TextView = findViewById(R.id.tv_option_four)


        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.defeault_option_border_bg
            )
        }

    }

    private fun answerView(answer: Int, drawableView: Int) {


        val tv_option_one: TextView = findViewById(R.id.tv_option_one)
        val tv_option_two: TextView = findViewById(R.id.tv_option_two)
        val tv_option_three: TextView = findViewById(R.id.tv_option_three)
        val tv_option_four: TextView = findViewById(R.id.tv_option_four)


        when (answer) {


            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this@Kvizkerdesek, drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this@Kvizkerdesek, drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this@Kvizkerdesek, drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                    this@Kvizkerdesek, drawableView
                )
            }
        }
    }
}


