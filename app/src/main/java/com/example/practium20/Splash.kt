package com.example.practium20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val imageview = findViewById<ImageView>(R.id.imageView)
        val textview3 = findViewById<TextView>(R.id.textView3)
        val textview2 = findViewById<TextView>(R.id.textView2)


        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}