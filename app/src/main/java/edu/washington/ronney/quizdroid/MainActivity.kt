package edu.washington.ronney.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import edu.washington.ronney.quizdroid.R.id.listView
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    val names = arrayOf("Math", "Physics", "Marvel Super Heroes")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        val adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, names)

        listView.adapter = adapter



        val clickListener = AdapterView.OnItemClickListener { parent, v, position, id ->
            if (names[position] == "Math") {
                val intent = Intent(this, MathOverviewActivity::class.java)
                startActivity(intent)
            } else if (names[position] == "Physics") {
                val intent = Intent(this, PhysicsOverviewActivity::class.java)
                startActivity(intent)
            } else if (names[position] == "Marvel Super Heroes") {
                val intent = Intent(this, MarvelOverviewActivity::class.java)
                startActivity(intent)
            }

            Log.i("MainActivity", "You selected ${names[position]}")
        }

        listView.setOnItemClickListener(clickListener)

    }
}
