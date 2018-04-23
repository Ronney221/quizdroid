package edu.washington.ronney.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MathOverviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_overview)

        val beginButton = findViewById<View>(R.id.button4)

        beginButton.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, MathQuizActivity::class.java)
            startActivity(intent)
        }
    }
}
