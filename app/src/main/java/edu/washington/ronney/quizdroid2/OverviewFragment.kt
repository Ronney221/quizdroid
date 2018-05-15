package edu.washington.ronney.quizdroid2

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.io.Serializable

class OverviewFragment : Fragment() {

    var topic : String = ""
    var desc : String = ""
    var topics : TopicRepository.Topic = TopicRepository.Topic("", "", "", ArrayList<TopicRepository.Quiz>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            topic = arguments.getString("topic")
            desc = arguments.getString("descriptionText")
            topics = arguments.getSerializable("topics") as TopicRepository.Topic
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_overview, container, false) as View
        val beginButton = view.findViewById<View>(R.id.overviewButton)
        val description : TextView = view.findViewById(R.id.overviewDesc)
        val overviewNumber : TextView = view.findViewById(R.id.overviewNumber)

        description.text = desc
        overviewNumber.text = "there will be " + topics.questions.size +" questions for this topic"

        beginButton.setOnClickListener {

            val transaction = fragmentManager.beginTransaction()
            val frag = QuestionFragment()

            val instance = Bundle()
            instance.putString("topic", topic)
            instance.putInt("questionNumber", 1)
            instance.putInt("questionsCorrect", 0)
            instance.putSerializable("topics", topics)

            frag.arguments = instance
            transaction.replace(R.id.fragment, frag).commit()
        }
        return view
    }
}
