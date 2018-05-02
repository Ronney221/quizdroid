package edu.washington.ronney.quizdroid2

import android.app.Fragment
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_fragment)

        var topic = intent.extras.getString("topic")

        if (topic == "Physics") {
            topic = "physic"
        } else if (topic == "Marvel Super Heroes") {
            topic = "marvel"
        }

        val descriptionText =  getString(resources.getIdentifier(topic+"Desc", "string", packageName))

        //start of fragments
        val transaction = fragmentManager.beginTransaction()
        val instance = Bundle()

        instance.putString("topic", topic)
        instance.putString("descriptionText", descriptionText)

        val frag = OverviewFragment()
        frag.arguments = instance

        transaction.add(R.id.fragment, frag).commit()
    }

    fun finished() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
