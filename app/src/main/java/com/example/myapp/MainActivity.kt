package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tvCounter = findViewById<TextView>(R.id.tvCounter)
        val btnIncrement = findViewById<Button>(R.id.btnIncrement)
        val btnDecrement = findViewById<Button>(R.id.btnDecrement)
        val btnOpenSecond = findViewById<Button>(R.id.btnOpenSecond)

        btnIncrement.setOnClickListener {
            count++
            tvCounter.text = count.toString()
        }

        btnDecrement.setOnClickListener {
            count--
            tvCounter.text = count.toString()
        }

        btnOpenSecond.setOnClickListener {
            // intent = unde ajunge
            val intent = Intent(this, SecondActivity::class.java)
            // pui string in intent
            intent.putExtra("message", "Mesaj din activitatea 1")
            // deschidem activitatea 2
            startActivity(intent)
        }


        // initializarea recyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        // creare lista date
        val items = listOf(
            ItemModel(
                "1. Android Studio & Kotlin",
                "Mediu de dezvoltare si structura proiectului."
            ),
            ItemModel(
                "2. Activity Component",
                "Ciclul de viața al unei activități."
            ),
            ItemModel(
                "3. Lists",
                "Utilizarea RecyclerView, CustomAdapter si LayoutManager."
            )
        )
        // elem vertical in jos si setare adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(items)
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "MainActivity: onStart() called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "MainActivity: onResume() called", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "MainActivity: onPause() called", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "MainActivity: onStop() called", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "MainActivity: onDestroy() called", Toast.LENGTH_SHORT).show()
    }
}