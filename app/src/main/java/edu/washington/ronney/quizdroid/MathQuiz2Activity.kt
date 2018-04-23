package edu.washington.ronney.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup

class MathQuiz2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_quiz2)

        val answerGroup = findViewById<View>(R.id.radioGroup2) as RadioGroup
        val submit = findViewById<View>(R.id.button7)

        var answer : String = "";
        val correctAnswer = "2x"
        val questionCount = 2
        val correct = intent.extras.getInt("correct")

        submit.setEnabled(false)

        answerGroup.setOnCheckedChangeListener { group, checkedId ->
            submit.setEnabled(true)
            val test = checkedId

            val selected = findViewById<View>(checkedId) as RadioButton
            answer = selected.getText().toString()
        }

        submit.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, MathAnswerActivity::class.java)
            intent.putExtra("answer", answer)
            intent.putExtra("correctAnswer", correctAnswer)
            intent.putExtra("questionCount", questionCount)
            intent.putExtra("correct", correct)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {

        val intent = Intent(this, MathQuizActivity::class.java)
        startActivity(intent)
    }
}
