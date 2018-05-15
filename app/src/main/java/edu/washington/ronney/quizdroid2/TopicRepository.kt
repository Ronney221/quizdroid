package edu.washington.ronney.quizdroid2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Parcelable
import org.json.JSONArray
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.Serializable

interface TopicRepository  {



    companion object {
      //  val math = Topic("Math", "Math quiz", "This will be a quiz to test your MATH abilities",
          //      arrayListOf(Quiz("What is 4 * 5?", "1", "5", "20", "hello", "20"),
          //              Quiz("What is the derivative of x^2?", "2", "3x^3", "2x" ,"x^2", "2x")))

      //  val physics = Topic("Physics", "Physics quiz", "This will be a quiz to test your Physics abilities",
      //          arrayListOf(Quiz("WHICH LAW OF PHYSICS MAKES A PERPETUAL MOTION MACHINE IMPOSSIBLE?", "First law of thermodynamics", "Second law of thermodynamics", "Third law of thermodynamics", "First and second laws of thermodynamics", "First and second laws of thermodynamics"),
        //                Quiz("IF AN OBJECT IS IN MOTION, WHAT KIND OF ENERGY DOES IT POSSESS?", "Metabolic Energy", "Caloric Energy", "Kinetic Energy", "Potential Energy", "Kinetic Energy")))
       // val marvel = Topic("Marvel", "Marvel quiz", "This will be a quiz to test your Marvel abilities",
        //        arrayListOf(Quiz("Which super hero can use and produce webs", "Super Man", "Spider Man", "Iron Man", "Captain American", "Spider Man"),
         //               Quiz("Which super hero carries around a shield?", "Super Man", "Spider Man", "Iron Man", "Captain American", "Captain American")))
    }

    // quiz domain object has the correct string instead of answer number to better tailor to my activities
    // serializable so these objects can pass through intent
    data class Quiz(val question: String, val a1 : String, val a2 : String, val a3 : String, val a4 : String, val correct : String) : Serializable
    data class Topic(val title : String, val shortDesc : String,val longDesc : String, val questions : ArrayList<Quiz>) : Serializable

    fun getRepository() : TopicRepository.Companion {
        return TopicRepository
    }
}
