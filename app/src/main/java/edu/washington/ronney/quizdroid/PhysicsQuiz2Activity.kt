package edu.washington.ronney.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup

class PhysicsQuiz2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_quiz2)
        val answerGroup = findViewById<View>(R.id.ppRadioGroup) as RadioGroup
        val submit = findViewById<View>(R.id.ppFinish)

        var answer : String = "";
        val correctAnswer = "Kinetic Energy"
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
            val intent = Intent(this, PhysicsAnswerActivity::class.java)
            intent.putExtra("answer", answer)
            intent.putExtra("correctAnswer", correctAnswer)
            intent.putExtra("questionCount", questionCount)
            intent.putExtra("correct", correct)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, PhysicsQuizActivity::class.java)
        startActivity(intent)
    }
}
