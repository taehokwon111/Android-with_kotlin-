package com.example.mylottoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker

class MainActivity : AppCompatActivity() {

    private val clearButton: Button by lazy {
        findViewById<Button>(R.id.resetButton);
    }

    private val addButton: Button by lazy {
        findViewById<Button>(R.id.AddButton);
    }

    private val runButton: Button by lazy {
        findViewById<Button>(R.id.runButton)
    }

    private val numberPicker: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.numberPicker);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker.minValue = 1;
        numberPicker.maxValue = 45;

        initRumButton();
        initAddButton();

    }

    private fun initRumButton() {
        runButton.setOnClickListener {
            val list = getRandumNumber();
            Log.d("MainActivity", list.toString());
        }
    }
    private fun initAddButton() {
        addButton.setOnClickListener {



        }
    }
    private fun getRandumNumber(): List<Int> {
        val numberList = mutableListOf<Int>()
            .apply {
                for (i in 1..45){
                    this.add(i)
                }
            }

        numberList.shuffle();

        val newList = numberList.subList(0, 6);

        return  newList.sorted();

    }
}