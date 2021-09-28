package com.example.my_kotlin_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val height: EditText = findViewById(R.id.height);
        val weight = findViewById<EditText>(R.id.height);

        val result = findViewById<Button>(R.id.button);

        result.setOnClickListener {
            Log.d("MainActivity", "버튼눌림")

            if(height.text.isEmpty() || weight.text.isEmpty()){
                Toast.makeText(this, "빈 값이 있다.", Toast.LENGTH_SHORT).show();
                return@setOnClickListener
            }

            val heightt: Int = height.text.toString().toInt();
            val weightt: Int = weight.text.toString().toInt();

            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("height", heightt);
            intent.putExtra("weight", weightt);


            startActivity(intent);
        }

    }
}