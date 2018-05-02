package edu.washington.ronney.quizdroid2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    val names = arrayOf("Math", "Physics", "Marvel Super Heroes")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val listView: ListView = findViewById(R.id.listView)

        val adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, names)

        listView.adapter = adapter

        val clickListener = AdapterView.OnItemClickListener { parent, v, position, id ->

            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra("topic", names[position])
            startActivity(intent)
        }

        listView.setOnItemClickListener(clickListener)

    }


}