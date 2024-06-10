package com.example.practium20

import android.annotation.SuppressLint
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var music: Button
    private var mediaPlayer: MediaPlayer? = null

    private lateinit var morningWeather: EditText
    private lateinit var afternoonWeather: EditText
    private lateinit var saveButton: Button
    private val daysData = Array(3) { IntArray(2) }
    private var currentDay = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clear = findViewById<Button>(R.id.clear)
        clear.setOnClickListener {
            val morningWeather= morningWeather.text.clear()
            val afternoonWeather= afternoonWeather.text.clear()
        }
        val music = findViewById<Button>(R.id.music)
        music.setOnClickListener {
            playAudio()
        }



        morningWeather = findViewById(R.id.morningWeather)
        afternoonWeather = findViewById(R.id.afternoonWeather)
        saveButton = findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            val morningTime = morningWeather.text.toString().toIntOrNull() ?: 0
            val afternoonTime = afternoonWeather.text.toString().toIntOrNull() ?: 0
            daysData[currentDay][0] = morningTime
            daysData[currentDay][1] = afternoonTime
            currentDay++

            if (currentDay >= daysData.size) {
                val intent = Intent(this, DetailedActivity::class.java).apply {
                    putExtra("DAYS_DATA", daysData)
                }
                startActivity(intent)
            } else {
                morningWeather.text.clear()
                afternoonWeather.text.clear()
            }
        }
    }

    private fun playAudio() {
        fun playAudio() {
            val audiourl = "https://archive.org/download/ModjoLadyHearMeTonight/Modjo%20-%20Lady%20%28Hear%20Me%20Tonight%29.mp3"
            mediaPlayer = MediaPlayer()
            mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
            try {
                mediaPlayer!!.setDataSource(audiourl)
                mediaPlayer!!.prepare()
                mediaPlayer!!.start()
            }catch (e: IOException){

            }
            Toast.makeText(this, "Audio Started", Toast.LENGTH_LONG).show()
        }
    }
}
