package com.example.secret_flie

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class DiaryActivity : AppCompatActivity() {

    private val diaryEditText: EditText by lazy {
        findViewById<EditText>(R.id.diaryEditText)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        val diaryEditText = findViewById<EditText>(R.id.diaryEditText);
        val detailPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE);

        diaryEditText.setText(detailPreferences.getString("detail", ""))

    }


}