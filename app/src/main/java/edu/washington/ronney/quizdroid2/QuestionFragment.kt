package edu.washington.ronney.quizdroid2


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class QuestionFragment : Fragment() {

    var topic = ""
    var questionNumber = 0
    var questionsCorrect = 0
    var answer = ""
    var topics : TopicRepository.Topic = TopicRepository.Topic("", "", "", ArrayList<TopicRepository.Quiz>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            topic = arguments.getString("topic")
            questionNumber = arguments.getInt("questionNumber")
            questionsCorrect = arguments.getInt("questionsCorrect")
            topics = arguments.getSerializable("topics") as TopicRepository.Topic
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_question, container, false) as View

        val question : TextView = view.findViewById(R.id.question)
        val answerGroup = view.findViewById<View>(R.id.radioGroup) as RadioGroup
        val button: Button = view.findViewById(R.id.questionButton)
        val answer1 = view.findViewById<RadioButton>(R.id.radioButton1)
        val answer2 = view.findViewById<RadioButton>(R.id.radioButton2)
        val answer3 = view.findViewById<RadioButton>(R.id.radioButton3)
        val answer4 = view.findViewById<RadioButton>(R.id.radioButton4)

        var questions : ArrayList<String> = ArrayList<String>()
        //index 0 = question    ------ + 6 per question iteration
        //index 1 2 3 4 = options
        //index 5 = correct answer

        questions.add(topics.questions.get(questionNumber - 1).question)
        questions.add(topics.questions.get(questionNumber - 1).a1)
        questions.add(topics.questions.get(questionNumber - 1).a2)
        questions.add(topics.questions.get(questionNumber - 1).a3)
        questions.add(topics.questions.get(questionNumber - 1).a4)
        questions.add(topics.questions.get(questionNumber - 1).correct)


        question.text = questions.get(0)

        answer1.text = questions.get(1)
        answer2.text = questions.get(2)
        answer3.text = questions.get(3)
        answer4.text = questions.get(4)

        val correctAnswer = questions.get(5)

        button.text = "Submit"

        button.setEnabled(false)

        answerGroup.setOnCheckedChangeListener { group, checkedId ->
            button.setEnabled(true)
            val test = checkedId

            val selected = view.findViewById<View>(checkedId) as RadioButton
            answer = selected.getText().toString()
        }

        button.setOnClickListener {

            val transaction = fragmentManager.beginTransaction()
            val answerFragment = AnswerFragment()

            val instance = Bundle()
            instance.putString("topic", topic)
            instance.putInt("questionNumber", questionNumber)
            instance.putInt("questionsCorrect", questionsCorrect)
            instance.putString("answer", answer)
            instance.putString("correctAnswer", correctAnswer)
            instance.putSerializable("topics", topics)

            answerFragment.arguments = instance
           // transaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left)
            transaction.replace(R.id.fragment, answerFragment).commit()
        }
        return view
    }
}
