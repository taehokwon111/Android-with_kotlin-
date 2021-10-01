package com.example.secret_flie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    private val numberPicker1: NumberPicker by lazy{
        findViewById<NumberPicker>(R.id.NumberPicker1)
            .apply {
                minValue = 0;
                maxValue = 9;

            }
    }
    private val numberPicker2: NumberPicker by lazy{
        findViewById<NumberPicker>(R.id.NumberPicker2)
            .apply {
                minValue = 0;
                maxValue = 9;

            }
    }
    private val numberPicker3: NumberPicker by lazy{
        findViewById<NumberPicker>(R.id.NumberPicker3)
            .apply {
                minValue = 0;
                maxValue = 9;

            }
    }

    private val openButton: AppCompatButton by lazy {
        findViewById<AppCompatButton>(R.id.openbtn)
    }
    private val changeButton: AppCompatButton by lazy {
        findViewById<AppCompatButton>(R.id.changebtn)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker1
        numberPicker2
        numberPicker3

        openButton.setOnClickListener {
            
        }
    }
}