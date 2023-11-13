package com.example.dinnerdecider.quizapp

import android.app.AlertDialog
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.dinnerdecider.R
import java.util.Date


class QuizActivity: ComponentActivity() {

    private val questions = Quiz.getQuestions()

    private var question1Txt: TextView? = null
    private var radioGroup: RadioGroup? = null
    private var radio1Btn: RadioButton? = null
    private var radio2Btn: RadioButton? = null
    private var radio3Btn: RadioButton? = null
    private var radio4Btn: RadioButton? = null
    private var question2Txt: TextView? = null
    private var checkBox1: CheckBox? = null
    private var checkBox2: CheckBox? = null
    private var checkBox3: CheckBox? = null
    private var checkBox4: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        viewBinding()
        createQuiz()
    }

    private fun viewBinding() {
        question1Txt = findViewById(R.id.question1)
        radioGroup = findViewById(R.id.radio)
        radio1Btn = findViewById(R.id.radio1)
        radio2Btn = findViewById(R.id.radio2)
        radio3Btn = findViewById(R.id.radio3)
        radio4Btn = findViewById(R.id.radio4)
        question2Txt = findViewById(R.id.question2)
        checkBox1 = findViewById(R.id.checkbox1)
        checkBox2 = findViewById(R.id.checkbox2)
        checkBox3 = findViewById(R.id.checkbox3)
        checkBox4 = findViewById(R.id.checkbox4)

        val resetBtn = findViewById<Button>(R.id.reset)
        resetBtn.setOnClickListener {
            reset()
        }

        val submitButton = findViewById<Button>(R.id.submit)
        submitButton.setOnClickListener {
            submit()
        }
    }

    private fun createQuiz() {
        question1Txt?.text = questions[0].question
        radio1Btn?.text = questions[0].answers[0]
        radio2Btn?.text = questions[0].answers[1]
        radio3Btn?.text = questions[0].answers[2]
        radio4Btn?.text = questions[0].answers[3]

        question2Txt?.text = questions[1].question
        checkBox1?.text = questions[1].answers[0]
        checkBox2?.text = questions[1].answers[1]
        checkBox3?.text = questions[1].answers[2]
        checkBox4?.text = questions[1].answers[3]
    }

    private fun reset(){
        radio1Btn?.isChecked = false
        radio2Btn?.isChecked = false
        radio3Btn?.isChecked = false
        radio4Btn?.isChecked = false

        checkBox1?.isChecked = false
        checkBox2?.isChecked = false
        checkBox3?.isChecked = false
        checkBox4?.isChecked = false
    }

    private fun calculateScore(): Int{
        val selectedRadioId = radioGroup?.checkedRadioButtonId
        var answer:String = ""
        if(selectedRadioId != -1 && selectedRadioId != null){
            val radioSelectedAnswer = findViewById<RadioButton>(selectedRadioId)
            answer = radioSelectedAnswer.text.toString()
        }
        val selectedRadioAnswer: List<String> = arrayListOf(answer)
        val selectedCheckBoxAnswer = ArrayList<String>()

        if( checkBox1 != null && checkBox1!!.isChecked)
            selectedCheckBoxAnswer.add(checkBox1?.text.toString())
        if( checkBox2 != null && checkBox2!!.isChecked)
            selectedCheckBoxAnswer.add(checkBox2?.text.toString())
        if( checkBox3 != null && checkBox3!!.isChecked)
            selectedCheckBoxAnswer.add(checkBox3?.text.toString())
        if( checkBox4 != null && checkBox4!!.isChecked)
            selectedCheckBoxAnswer.add(checkBox4?.text.toString())

        var score = 0
        if(questions[0].isCorrect(selectedRadioAnswer))
            score += 50
        if(questions[1].isCorrect(selectedCheckBoxAnswer))
            score += 50

        return score
    }

    private fun submit(){
        val builder1 = AlertDialog.Builder(this)

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        val score = calculateScore()

        var message = ""

        message = if(score >= 50){
            "Congratulations!! you have score: $score.\n" +
                    "Date and time: $currentDate"
        }else{
            "You have score: $score.\n" +
                    "Date and time: $currentDate \n" +
                    "Try again!!"
        }

        builder1.setMessage(message)
        builder1.setCancelable(true)

        builder1.setPositiveButton(
            "Close"
        ) { dialog, _ -> dialog.cancel() }


        val alert11 = builder1.create()
        alert11.show()

    }

}