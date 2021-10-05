package com.example.secret_flie

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.edit

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
    private var changePasswordMode = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker1
        numberPicker2
        numberPicker3
        openButton.setBackgroundColor(Color.BLACK);
        changeButton.setBackgroundColor(Color.BLACK);

        openButton.setOnClickListener {

            if (changePasswordMode){
                Toast.makeText(this, "비밀번호 변경중.", Toast.LENGTH_SHORT).show();
                return@setOnClickListener;
            }

            val passwordPreferences = getSharedPreferences("password", Context.MODE_PRIVATE);

            val passwordFromUser = "${numberPicker1.value}${numberPicker2.value}${numberPicker3.value}";

            if(passwordPreferences.getString("password", "000").equals(passwordFromUser)){
                //패스워드 성공
                //TODO 다이어리 후 남겨줘야함
                //startActivity()
            }else {
                showErrorDialog()
                //실패
            }
        }

        changeButton.setOnClickListener {
            val passwordPreferences = getSharedPreferences("password", Context.MODE_PRIVATE);
            val passwordFromUser = "${numberPicker1.value}${numberPicker2.value}${numberPicker3.value}";

            if(changePasswordMode){
                //번호를 저장하는 기능

                passwordPreferences.edit(){
                    putString("password", passwordFromUser);
                }

                changePasswordMode = false
                changeButton.setBackgroundColor(Color.BLACK);

            } else {
                // changePasswordMode가 활성화 :: 비밀번호 유효성 체크

                if(passwordPreferences.getString("password", "000").equals(passwordFromUser)){
                    //패스워드 성공
                    //TODO 다이어리 후 남겨줘야함

                    changePasswordMode = true
                    Toast.makeText(this, "변경할 비밀번호 입력", Toast.LENGTH_SHORT).show();

                    changeButton.setBackgroundColor(Color.RED);

                }else {
                    showErrorDialog()
                    //실패
                }
            }
        }
    }

    private fun showErrorDialog(){
        AlertDialog.Builder(this)
            .setTitle("실패")
            .setMessage("비밀번호 불일치")
            .setPositiveButton("확인"){ _, _ -> }
            .create()
            .show()
    }

}