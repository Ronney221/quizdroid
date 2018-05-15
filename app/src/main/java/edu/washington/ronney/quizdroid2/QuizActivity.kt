package edu.washington.ronney.quizdroid2

import android.app.Fragment
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import org.json.JSONArray
import java.io.File
import java.io.FileInputStream

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_fragment)

        val topics = ArrayList<TopicRepository.Topic>()

        val questions = File(Environment.getExternalStorageDirectory(), "customQuestions.json")
        val questionsInput = FileInputStream(questions)
        val input = questionsInput.bufferedReader().use { it.readText() }

        val questionsJSON = JSONArray(input)

        for (i in 0..(questionsJSON.length() - 1)) {
            val section = questionsJSON.getJSONObject(i)
            val title = section.getString("title")
            val desc = section.getString("desc")
            val questions = section.getJSONArray("questions")

            val question = arrayListOf<TopicRepository.Quiz>()
            for (j in 0..(questions.length() - 1)) {
                val questionSection = questions.getJSONObject(j)
                val text = questionSection.getString("text")
                val correctAnswerIndex = questionSection.getInt("answer") - 1
                val jsonAnswers = questionSection.getJSONArray("answers")
                val answers = Array(jsonAnswers.length()) { "" }
                for (f in 0..(jsonAnswers.length() - 1)) {
                    answers[f] = jsonAnswers[f].toString()
                }
                question.add(TopicRepository.Quiz(text, answers[0], answers[1], answers[2], answers[3], answers[correctAnswerIndex]))
            }
            topics.add(TopicRepository.Topic(title, desc, desc, question))
        }


        var position = 0
        var topic = intent.extras.getString("topic")
        var descriptionText : String = ""

        if (topic == "Science!") {
            descriptionText = topics.get(0).longDesc
        } else if (topic == "Marvel Super Heroes") {
            descriptionText = topics.get(1).longDesc
            position = 1
        } else if (topic == "Mathematics") {
            descriptionText = topics.get(2).longDesc
            position = 2
        }

        //start of fragments
        val transaction = fragmentManager.beginTransaction()
        val instance = Bundle()

        instance.putString("topic", topic)
        instance.putString("descriptionText", descriptionText)
        instance.putSerializable("topics", topics.get(position))

        val frag = OverviewFragment()
        frag.arguments = instance

        transaction.add(R.id.fragment, frag).commit()
    }

    fun finished() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
