package com.example.calc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.lang.NumberFormatException
import java.util.function.BinaryOperator
import kotlin.math.exp

class MainActivity : AppCompatActivity() {

    private val expressionTextView: TextView by lazy {
        findViewById<TextView>(R.id.expressionTextView);
    }

    private val resultTextView: TextView by lazy {
        findViewById<TextView>(R.id.resultTextView);
    }

    private var isOperator = false;
    private var hasOperator = false;

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
        if (expressionText.last().length >= 15){
            Toast.makeText(this, "15자리 까지만 사용할 수 있습니다.", Toast.LENGTH_SHORT).show();
            return
        }
        else if (expressionText.isEmpty() && number == "0"){
            Toast.makeText(this, "0은 제일 앞에 둘 수 없습니다.", Toast.LENGTH_SHORT).show();
            return
        }

        expressionTextView.append(number);
    }

    private fun operatorButtonClicked(operator: String){
        if (expressionTextView.text.isEmpty()){
            return
        }
        when {
            isOperator ->{
                val text = expressionTextView.text.toString();
                expressionTextView.text = text.dropLast(1) + operator;
            }
            hasOperator ->{
                Toast.makeText(this, "연산자는 한 번만 사용할 수 있습니다", Toast.LENGTH_SHORT).show();
                return
            }
            else ->{
                expressionTextView.append(" $operator");
            }
        }
        val ssd = SpannableStringBuilder(expressionTextView.text);

        ssd.setSpan(
                ForegroundColorSpan(ContextCompat.getColor(this, R.color.green)),
                expressionTextView.text.length -1,
                expressionTextView.text.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        expressionTextView.text = ssd;

        isOperator = true;
        hasOperator = true;
    }


    fun historybtnclick(v: View){
        Toast.makeText(this, "응애", Toast.LENGTH_SHORT).show()
    }
    fun resultbtnclick(v: View){
        Toast.makeText(this, "응애", Toast.LENGTH_SHORT).show()
    }

    private fun calculateExpression(): String{
        val expressionTexts = expressionTextView.text.split("")

        if (hasOperator.not() || expressionTexts.size != 3){
            return ""
        }else if(expressionTexts[0].isNumber().not() || expressionTexts[2].isNumber().not()){
            return ""
        }
        val expl1 = expressionTexts[0].toBigInteger();
        val expl2 = expressionTexts[2].toBigInteger();
        val op =  expressionTexts[1]

        return when(op){
                "+" ->(expl1 + expl2).toString();
                "-" ->(expl1 - expl2).toString();
                "*" ->(expl1 * expl2).toString();
                "/" ->(expl1 / expl2).toString();
                "%" ->(expl1 % expl2).toString();
                else -> ""
        }

    }
    fun clearbtnclick(v: View){

        expressionTextView.text = "";
        resultTextView.text = "";
        isOperator = false;
        hasOperator = false;
    }
}

fun String.isNumber(): Boolean{
    return try {
        this.toBigInteger();
        true;
    }catch (e: NumberFormatException) {
        false
    }

}