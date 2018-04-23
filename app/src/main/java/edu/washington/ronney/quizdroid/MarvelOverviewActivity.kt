package edu.washington.ronney.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MarvelOverviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marvel_overview)

        val beginButton = findViewById<View>(R.id.mbutton)

        beginButton.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, MarvelQuizActivity::class.java)
            startActivity(intent)
        }
    }
}
