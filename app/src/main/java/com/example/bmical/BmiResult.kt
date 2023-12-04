package com.example.bmical

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
import kotlin.math.round

class BmiResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_result)
        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        var value = weight / (height/100.0).pow(2.0)
        value = round( value * 10.0 / 10.0)

        var resultText = ""
        var resultImage = 0
        var resultColor = 0

        if(value < 18.5) {
            resultText = "저체중"
            resultImage = R.drawable.lv1st
            resultColor = Color.GRAY
        }else if(value >= 18.5 && value < 23.0) {
            resultText = "정상체중"
            resultImage = R.drawable.lv2nd
            resultColor = Color.GREEN
        }else if(value >= 23.0 && value < 25.0) {
            resultText = "과체중"
            resultImage = R.drawable.lv3rd
            resultColor = Color.BLUE
        }else if(value >= 25.0 && value < 30.0) {
            resultText = "경도비만"
            resultImage = R.drawable.lv4th
            resultColor = Color.MAGENTA
        }else if(value >= 30.0 && value <35.0) {
            resultText = "중정도비만"
            resultImage = R.drawable.lv5th
            resultColor = Color.CYAN
        }else {
            resultText = "고도비만"
            resultImage = R.drawable.lv6th
            resultColor = Color.RED
        }

        val resValue = findViewById<TextView>(R.id.resultNumber)
        val resText = findViewById<TextView>(R.id.resultText)
        val resImage = findViewById<ImageView>(R.id.resultImage)
        val returnButton = findViewById<Button>(R.id.resultButton)


        resValue.text = value.toString()
        resText.text = resultText
        resImage.setImageResource(resultImage)
        resText.setTextColor(resultColor)

        returnButton.setOnClickListener{
            finish()
        }

    }
}