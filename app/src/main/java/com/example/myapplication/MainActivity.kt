package com.example.myapplication

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Nickname
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //onclick listener for the button
        findViewById<Button>(R.id.btn_done).setOnClickListener{
            addNickName(it)
        }
    }

    private fun addNickName(view: View){
        val etText =findViewById<EditText>(R.id.nickname_et)
        val NicknameTv =findViewById<TextView>(R.id.tv_nickname)

        NicknameTv.text =etText.text //Setting the value of the text view
        etText.visibility=View.GONE
        view.visibility=View.GONE
        NicknameTv.visibility=View.VISIBLE

        //Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}