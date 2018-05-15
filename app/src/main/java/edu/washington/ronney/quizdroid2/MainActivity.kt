package edu.washington.ronney.quizdroid2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    val names = arrayOf("Science!", "Marvel Super Heroes", "Mathematics")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.listView)

        val adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, names)

        //trigger the on create log
        QuizApp.quiz

        listView.adapter = adapter

        val clickListener = AdapterView.OnItemClickListener { parent, v, position, id ->

            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra("topic", names[position])
            startActivity(intent)
        }

        listView.setOnItemClickListener(clickListener)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator = menuInflater
        inflator.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
