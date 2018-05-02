package edu.washington.ronney.quizdroid2

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class OverviewFragment : Fragment() {

    var topic : String = ""
    var desc : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            topic = arguments.getString("topic")
            desc = arguments.getString("descriptionText")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_overview, container, false) as View

        val beginButton = view.findViewById<View>(R.id.overviewButton)
        val description : TextView = view.findViewById(R.id.overviewDesc)

        description.text = desc

        beginButton.setOnClickListener {

            val transaction = fragmentManager.beginTransaction()
            val frag = QuestionFragment()

            val instance = Bundle()
            instance.putString("topic", topic)
            instance.putInt("questionNumber", 1)
            instance.putInt("questionsCorrect", 0)

            frag.arguments = instance
            transaction.replace(R.id.fragment, frag).commit()
        }
        return view
    }
}
