package com.example.practium20

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedActivity : AppCompatActivity() {

    private lateinit var screenWeatherDisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val textview = findViewById<TextView>(R.id.textView)


       textview.setOnClickListener{
            val intent = Intent(this, Splash::class.java)
            startActivity(intent)
            finish()
        }

        screenWeatherDisplay = findViewById(R.id.screenWeatherDisplay)

        val daysData = intent.getSerializableExtra("DAYS_DATA") as Array<IntArray>
        val stringBuilder = StringBuilder()
        var totalMorningDegrees = 0
        var totalAfternoonDegrees = 0
        var dayIndex = 0

        while (dayIndex < daysData.size) {
            val morningTime = daysData[dayIndex][0]
            val afternoonTime = daysData[dayIndex][1]
            totalMorningDegrees += morningTime
            totalAfternoonDegrees += afternoonTime

            stringBuilder.append("Day ${dayIndex + 1}:\n")
            stringBuilder.append("  Morning Weather: $morningTime Degrees\n")
            stringBuilder.append("  Afternoon Weather: $afternoonTime Degrees\n\n")
            dayIndex++
        }

        val averageMorningTime = totalMorningDegrees / daysData.size
        val averageAfternoonTime = totalAfternoonDegrees / daysData.size

        stringBuilder.append("Average Morning Weather: $averageMorningTime Degrees\n")
        stringBuilder.append("Average Afternoon Weather: $averageAfternoonTime Degrees\n")

        screenWeatherDisplay.text = stringBuilder.toString()
    }
}
