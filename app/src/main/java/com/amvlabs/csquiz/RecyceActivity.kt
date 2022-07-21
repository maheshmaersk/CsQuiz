package com.amvlabs.csquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amvlabs.csquiz.adapter.RecycleUserAdapter
import com.amvlabs.csquiz.model.User

class RecyceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyce)

        var dsds = findViewById<RecyclerView>(R.id.rec)


        val stateList: ArrayList<User> = ArrayList()
        stateList.add(User("Harsha", "BMS", "harsha@gmail.com"))
        stateList.add(User("Deepak", "PES", "Deepak@gmail.com"))
        stateList.add(User("Siddu", "VTU", "Siddu@gmail.com"))
        stateList.add(User("Chandana", "MIT", "Chandana@gmail.com"))
        stateList.add(User("charvi", "NIT", "charvi@gmail.com"))
        stateList.add(User("Harsha", "BMS", "harsha@gmail.com"))
        stateList.add(User("Deepak", "PES", "Deepak@gmail.com"))
        stateList.add(User("Siddu", "VTU", "Siddu@gmail.com"))
        stateList.add(User("Chandana", "MIT", "Chandana@gmail.com"))
        stateList.add(User("charvi", "NIT", "charvi@gmail.com"))
        stateList.add(User("Harsha", "BMS", "harsha@gmail.com"))
        stateList.add(User("Deepak", "PES", "Deepak@gmail.com"))
        stateList.add(User("Siddu", "VTU", "Siddu@gmail.com"))
        stateList.add(User("Chandana", "MIT", "Chandana@gmail.com"))
        stateList.add(User("charvi", "NIT", "charvi@gmail.com"))
        stateList.add(User("Harsha", "BMS", "harsha@gmail.com"))
        stateList.add(User("Deepak", "PES", "Deepak@gmail.com"))
        stateList.add(User("Siddu", "VTU", "Siddu@gmail.com"))
        stateList.add(User("Chandana", "MIT", "Chandana@gmail.com"))
        stateList.add(User("charvi", "NIT", "charvi@gmail.com"))
        stateList.add(User("Harsha", "BMS", "harsha@gmail.com"))
        stateList.add(User("Deepak", "PES", "Deepak@gmail.com"))
        stateList.add(User("Siddu", "VTU", "Siddu@gmail.com"))
        stateList.add(User("Chandana", "MIT", "Chandana@gmail.com"))
        stateList.add(User("charvi", "NIT", "charvi@gmail.com"))
        stateList.add(User("Harsha", "BMS", "harsha@gmail.com"))
        stateList.add(User("Deepak", "PES", "Deepak@gmail.com"))
        stateList.add(User("Siddu", "VTU", "Siddu@gmail.com"))
        stateList.add(User("Chandana", "MIT", "Chandana@gmail.com"))
        stateList.add(User("charvi", "NIT", "charvi@gmail.com"))
        stateList.add(User("Harsha", "BMS", "harsha@gmail.com"))
        stateList.add(User("Deepak", "PES", "Deepak@gmail.com"))
        stateList.add(User("Siddu", "VTU", "Siddu@gmail.com"))
        stateList.add(User("Chandana", "MIT", "Chandana@gmail.com"))
        stateList.add(User("charvi", "NIT", "charvi@gmail.com"))
        val layoutManager = GridLayoutManager(applicationContext, 6)

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                when (position) {
                    0, 1, 2 -> return 2
                    3, 4 -> return 3
                    5 -> return 6
                    else -> return 2
                }
            }
        }

        dsds.layoutManager = layoutManager


//        dsds.layoutManager= LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
        dsds.adapter = RecycleUserAdapter(stateList)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_optiion_ex, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_about -> {
                startActivity(Intent(applicationContext,MainActivity::class.java))
                return true
            }
            R.id.menu_logout -> {

                return true
            }
            R.id.menu_profile -> {
                startActivity(Intent(applicationContext,LoginActivity::class.java))
                return true
            }
            R.id.menu_help -> {
                startActivity(Intent(applicationContext,OnBoardingActivity::class.java))
                return true
            }
            R.id.menu_settings -> {
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }

        }


    }
}