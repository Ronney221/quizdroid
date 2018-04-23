package edu.washington.ronney.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mathButton = findViewById<View>(R.id.button)
        val pButton = findViewById<View>(R.id.button2)
        val mButton = findViewById<View>(R.id.button3)

        mathButton.setOnClickListener {
            val intent = Intent(this, MathOverviewActivity::class.java)
            startActivity(intent)
        }

        pButton.setOnClickListener {
            val intent = Intent(this, PhysicsOverviewActivity::class.java)
            startActivity(intent)
        }

        mButton.setOnClickListener {
            val intent = Intent(this, MarvelOverviewActivity::class.java)
            startActivity(intent)
        }
    }
}
