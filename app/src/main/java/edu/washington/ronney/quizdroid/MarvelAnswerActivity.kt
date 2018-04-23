package edu.washington.ronney.quizdroid

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_marvel_answer.*

class MarvelAnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marvel_answer)

        val answerText = findViewById<View>(R.id.manswerGiven) as TextView
        val correctText = findViewById<View>(R.id.mcorrectText) as TextView
        val runningTotal = findViewById<View>(R.id.mrunningTotal) as TextView
        val button = findViewById<View>(R.id.mbutton6) as Button


        val answer = intent.extras.getString("answer")
        val correctAnswer = intent.extras.getString("correctAnswer")
        val questionCount = intent.extras.getInt("questionCount")

        //changing textview
        answerText.text = "The answer you gave is: " + answer
        correctText.text = "The correct answer is: " + correctAnswer

        var correct = intent.extras.getInt("correct")
        if (answer.equals(correctAnswer)) {
            correct ++
        }

        runningTotal.text = "You have " + correct +" out of " + questionCount+" correct"

        //changing button
        if (questionCount == 2) { //last question
            button.setText("FINISH")
        } else {
            button.setText("NEXT")
        }


        button.setOnClickListener {
            // Handler code here.

            if (questionCount == 2) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, MarvelQuiz2Activity::class.java)
                intent.putExtra("correct", correct)
                startActivity(intent)
            }
        }
    }

}
