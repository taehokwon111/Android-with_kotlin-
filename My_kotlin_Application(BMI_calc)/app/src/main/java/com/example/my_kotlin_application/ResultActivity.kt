package com.example.my_kotlin_application

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result);

        val height = intent.getIntExtra("height", 0);
        val weight = intent.getIntExtra("weight", 0);

        Log.d("ResultActivity", "키 $height 몸무게 $weight")
    }


}