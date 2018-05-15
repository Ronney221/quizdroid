package edu.washington.ronney.quizdroid2

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class AnswerFragment : Fragment() {

    var answer = ""
    var correctAnswer = ""
    var questionNumber = 0
    var questionsCorrect = 0
    var topic = ""
    var topics : TopicRepository.Topic = TopicRepository.Topic("", "", "", ArrayList<TopicRepository.Quiz>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            answer = arguments.getString("answer")
            correctAnswer = arguments.getString("correctAnswer")
            questionNumber = arguments.getInt("questionNumber")
            questionsCorrect = arguments.getInt("questionsCorrect")
            topic = arguments.getString("topic");
            topics = arguments.getSerializable("topics") as TopicRepository.Topic
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_answer, container, false) as View

        val answerText = view.findViewById<View>(R.id.givenAnswer) as TextView
        val correctText = view.findViewById<View>(R.id.correctAnswer) as TextView
        val runningTotal = view.findViewById<View>(R.id.runningTotal) as TextView
        val button = view.findViewById<View>(R.id.answerButton) as Button

        //changing textview
        answerText.text = "The answer you gave is: " + answer
        correctText.text = "The correct answer is: " + correctAnswer

        if (answer.equals(correctAnswer)) {
            questionsCorrect ++
        }

        runningTotal.text = "You have " + questionsCorrect +" out of " + questionNumber +" correct"

        //changing button
        if (questionNumber == topics.questions.size) { //last question
            button.setText("FINISH")
        } else {
            button.setText("NEXT")
        }

        button.setOnClickListener {

            if (questionNumber == topics.questions.size) {
                (activity as QuizActivity).finished()
            } else {
                val transaction = fragmentManager.beginTransaction()
                val frag = QuestionFragment()

                val instance = Bundle()
                questionNumber ++
                instance.putString("topic", topic)
                instance.putInt("questionNumber", questionNumber)
                instance.putInt("questionsCorrect", questionsCorrect)
                instance.putString("answer", answer)
                instance.putString("correctAnswer", correctAnswer)
                instance.putSerializable("topics", topics)

                frag.arguments = instance
                transaction.replace(R.id.fragment, frag).commit()
            }


        }


        return view
    }

}
