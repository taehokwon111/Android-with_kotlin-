package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnclick(v: View){
        Toast.makeText(this, "응애", Toast.LENGTH_SHORT).show()
    }
    fun historybtnclick(v: View){
        Toast.makeText(this, "응애", Toast.LENGTH_SHORT).show()
    }
    fun resultbtnclick(v: View){
        Toast.makeText(this, "응애", Toast.LENGTH_SHORT).show()
    }
    fun clearbtnclick(v: View){
        Toast.makeText(this, "응애", Toast.LENGTH_SHORT).show()
    }
}