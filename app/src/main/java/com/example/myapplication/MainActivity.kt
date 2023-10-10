package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        //onclick listener for the button
//        findViewById<Button>(R.id.btn_done).setOnClickListener{
//            addNickName(it)
//        }


        //Accessing through the Binding
        binding.btnDone.setOnClickListener{
            addNickName(it)
        }
    }

    private fun addNickName(view: View){
//        val etText =findViewById<EditText>(R.id.nickname_et)
//        val nicknameTv =findViewById<TextView>(R.id.tv_nickname)

//        nicknameTv.text =etText.text //Setting the value of the text view
//        etText.visibility=View.GONE
//        view.visibility=View.GONE
//        nicknameTv.visibility=View.VISIBLE

        binding.apply {
            tvNickname.text=nicknameEt.text
            invalidateAll() // clear all othe bidings
            nicknameEt.visibility=View.GONE
            btnDone.visibility=View.GONE
            tvNickname.visibility=View.VISIBLE
        }
        //Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}