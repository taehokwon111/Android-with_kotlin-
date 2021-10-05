package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.util.function.BinaryOperator

class MainActivity : AppCompatActivity() {

    private val expressionTextView: TextView by lazy {
        findViewById<TextView>(R.id.expressionTextView);
    }

    private val resultTextView: TextView by lazy {
        findViewById<TextView>(R.id.resultTextView);
    }

    private var isOperator = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnclick(v: View){
        when(v.id){
            R.id.btn0 -> numberButtonClicked("0");
            R.id.btn1 -> numberButtonClicked("1");
            R.id.btn2 -> numberButtonClicked("2");
            R.id.btn3 -> numberButtonClicked("3");
            R.id.btn4 -> numberButtonClicked("4");
            R.id.btn5 -> numberButtonClicked("5");
            R.id.btn6 -> numberButtonClicked("6");
            R.id.btn7 -> numberButtonClicked("7");
            R.id.btn8 -> numberButtonClicked("8");
            R.id.btn9 -> numberButtonClicked("9");
            R.id.plusbtn -> operatorButtonClicked("+");
            R.id.minusbtn -> operatorButtonClicked("-");
            R.id.multibtn -> operatorButtonClicked("*");
            R.id.dividerbtn -> operatorButtonClicked("/");
            R.id.modulobtn -> operatorButtonClicked("%");


        }
    }

    private fun numberButtonClicked(number: String){

        if(isOperator){
            expressionTextView.append(" ")
        }

        isOperator = false;

        val expressionText = expressionTextView.text.split("");
        if (expressionText.isNotEmpty() && expressionText.last().length >= 15){
            Toast.makeText(this, "15자리 까지만 사용할 수 있습니다.", Toast.LENGTH_SHORT).show();
            return
        } else if (expressionText.last().isEmpty() && number == "0"){
            Toast.makeText(this, "0은 제일 앞에 둘 수 없습니다.", Toast.LENGTH_SHORT).show();
            return
        }

        expressionTextView.append(number);
    }

    private fun operatorButtonClicked(operator: String){
        if (expressionTextView.text.isEmpty()){

        }
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