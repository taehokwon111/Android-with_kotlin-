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

        val heightEditText: EditText = findViewById(R.id.height);
        val weightEditText = findViewById<EditText>(R.id.weight);

        val result = findViewById<Button>(R.id.button);

        result.setOnClickListener {
            Log.d("MainActivity", "버튼눌림")

            if(heightEditText.text.isEmpty() || weightEditText.text.isEmpty()){
                Toast.makeText(this, "빈 값이 있다.", Toast.LENGTH_SHORT).show();
                return@setOnClickListener
            }

            val height: Int = heightEditText.text.toString().toInt();
            val weight: Int = weightEditText.text.toString().toInt();

            Log.d("MainActivity", "height : $height weight : $weight")

            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("height", height);
            intent.putExtra("weight", weight);


            startActivity(intent);
        }

    }
}