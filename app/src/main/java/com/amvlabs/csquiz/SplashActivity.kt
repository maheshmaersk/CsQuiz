package com.amvlabs.csquiz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(
            "SampleData",
            Context.MODE_PRIVATE
        )

        val sharedPreferences1: SharedPreferences = this.getSharedPreferences(
            "LoginData",
            Context.MODE_PRIVATE
        )


        val splashTime = sharedPreferences.getInt("splashDisplayCount", 0)

        if (splashTime == 0 || splashTime < 5) {
            Log.e("Splash", "${sharedPreferences.getInt("splashDisplayCount", 0)}")
            Handler().postDelayed({
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putInt(
                    "splashDisplayCount",
                    (sharedPreferences.getInt("splashDisplayCount", 0) + 1)
                )
                editor.apply()
                editor.commit()
                startActivity(Intent(applicationContext, ImplActivity::class.java))
            }, 3000)
        } else {
            startActivity(Intent(applicationContext, ImplActivity::class.java))
        }


    }
}