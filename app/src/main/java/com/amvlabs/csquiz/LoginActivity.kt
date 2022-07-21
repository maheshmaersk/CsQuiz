package com.amvlabs.csquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var dfs = findViewById<TextView>(R.id.tvLogin)
        var sad = findViewById<TextView>(R.id.tvcat)


        dfs.setOnClickListener {
            showMenuPop(sad)
        }

    }


    private fun showMenuPop(vi: View) {
        val pop = PopupMenu(applicationContext, vi)
        pop.inflate(R.menu.menu_optiion_ex)

        pop.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_about -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                }
                R.id.menu_logout -> {
                }
                R.id.menu_profile -> {
                    startActivity(Intent(applicationContext, LoginActivity::class.java))
                }
                R.id.menu_help -> {
                    startActivity(Intent(applicationContext, OnBoardingActivity::class.java))
                }
                R.id.menu_settings -> {
                }
                else -> {
                }

            }
            true
        }
        pop.show()
    }


    override fun onStart() {
        Log.d("LoginAct", "onStart")
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }
}