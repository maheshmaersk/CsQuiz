package com.amvlabs.csquiz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

//    lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        mContext= applicationContext

        val loginButton = findViewById<Button>(R.id.btLogin)
        loginButton.setOnClickListener {
            Log.d("TestLogs","Login Bt Click")
            startActivity(Intent(it.context, OnBoardingActivity::class.java))
        }

    }
}