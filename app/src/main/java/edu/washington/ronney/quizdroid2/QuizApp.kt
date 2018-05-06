package edu.washington.ronney.quizdroid2

import android.app.Application
import android.util.Log

class QuizApp : Application(), TopicRepository {


    companion object {
        var quiz: QuizApp = QuizApp()
        var math = TopicRepository.math
        var physics = TopicRepository.physics
        var marvel = TopicRepository.marvel
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("QuizApp", "emits a message to the diagnostic log to ensure it is being loaded and run")
        math = getRepository().math
        physics = getRepository().physics
        marvel = getRepository().marvel

    }

    override fun getRepository() : TopicRepository.Companion {
        return TopicRepository
    }

}
