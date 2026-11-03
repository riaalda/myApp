package com.example.myapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // citim string prin ac cheie
        val message = intent.getStringExtra("message")
        // gasire text view din activity_second.xml
        val tvReceived = findViewById<TextView>(R.id.tvSecondMessage)
        if (message != null) {
            tvReceived.text = message
        }
        //finish() - ecranul se inchide la finish, de ex pt "back"
    }
    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "SecondActivity: onStart() called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "SecondActivity: onResume() called", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "SecondActivity: onPause() called", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "SecondActivity: onStop() called", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "SecondActivity: onDestroy() called", Toast.LENGTH_SHORT).show()
    }
}