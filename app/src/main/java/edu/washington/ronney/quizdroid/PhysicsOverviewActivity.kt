package edu.washington.ronney.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PhysicsOverviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_overview)

        val beginButton = findViewById<View>(R.id.pbutton)

        beginButton.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, PhysicsQuizActivity::class.java)
            startActivity(intent)
        }
    }
}
