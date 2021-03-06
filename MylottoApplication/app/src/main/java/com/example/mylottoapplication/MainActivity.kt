package com.example.mylottoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

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




    private val numberTextViewList: List<TextView> by lazy {
        listOf<TextView>(
            findViewById<TextView>(R.id.textnum1),
            findViewById<TextView>(R.id.textnum2),
            findViewById<TextView>(R.id.textnum3),
            findViewById<TextView>(R.id.textnum4),
            findViewById<TextView>(R.id.textnum5),
            findViewById<TextView>(R.id.textnum6)
        )
    }

    private var didrun = false

    private val pickNumberSet = hashSetOf<Int>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker.minValue = 1;
        numberPicker.maxValue = 45;

        initRunButton();
        initAddButton();
        initClearButton();
    }

    private fun initRunButton() {
        runButton.setOnClickListener {
            val list = getRandumNumber();

            didrun = true;

            list.forEachIndexed{ index, number ->
                val textView = numberTextViewList[index]

                textView.text = number.toString();
                textView.isVisible = true;

                setNumberBackground(number, textView);
            }



            Log.d("MainActivity", list.toString());
        }
    }
    private fun initAddButton() {
        addButton.setOnClickListener {

            if(didrun){
                Toast.makeText(this, "????????? ?????? ??????????????????", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(pickNumberSet.size >= 5){
                Toast.makeText(this, "????????? 5???????????? ?????? ??? ??? ????????????.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(pickNumberSet.contains(numberPicker.value)) {
                Toast.makeText(this, "?????? ??????~", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val textView = numberTextViewList[pickNumberSet.size]
            textView.isVisible = true;
            textView.text = numberPicker.value.toString();

            setNumberBackground(numberPicker.value, textView);

            pickNumberSet.add(numberPicker.value);
        }
    }

    private fun setNumberBackground(number:Int, textView: TextView){
        when(number){
            in 1..10 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_y)
            in 11..20 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_b)
            in 21..30 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_r)
            in 31..40 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_g)
            else -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_gre)
        }
    }

    private fun initClearButton() {
        clearButton.setOnClickListener {
            pickNumberSet.clear();
            numberTextViewList.forEach{
                it.isVisible = false;
            }

            didrun = false
        }
    }

    private fun getRandumNumber(): List<Int> {
        val numberList = mutableListOf<Int>()
            .apply {
                for (i in 1..45){
                    if(pickNumberSet.contains(i)){
                        continue
                        }
                    this.add(i)
                }
            }

        numberList.shuffle();

        val newList = pickNumberSet.toList() + numberList.subList(0, 6 - pickNumberSet.size);

        return  newList.sorted();

    }
}

