package com.amvlabs.csquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.amvlabs.csquiz.adapter.RecycleUserAdapter
import com.amvlabs.csquiz.model.User
import com.squareup.picasso.Picasso

class RecyceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyce)

        var dsds = findViewById<RecyclerView>(R.id.rec)
        var dssds = findViewById<TextView>(R.id.contextTest)
        var banner = findViewById<ViewPager>(R.id.banners)


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


        registerForContextMenu(dssds)

        var imagLis = ArrayList<Int>()
        imagLis= (imagLis+R.drawable.amsd) as ArrayList<Int>
        imagLis= (imagLis+R.drawable.contact) as ArrayList<Int>
        imagLis= (imagLis+R.drawable.ar) as ArrayList<Int>
        imagLis= (imagLis+R.drawable.amsd) as ArrayList<Int>

        var imagsPath = ArrayList<String>()
        imagsPath.add("https://cdn.dnaindia.com/sites/default/files/styles/full/public/2021/12/25/1011537-atrangi-re-review.jpg")
        imagsPath.add("https://i.ytimg.com/vi/aYKMdJc_Prg/maxresdefault.jpg")
        imagsPath.add("https://assets-in.bmscdn.com/discovery-catalog/events/tr:w-400,h-600,bg-CCCCCC:w-400.0,h-660.0,cm-pad_resize,bg-000000,fo-top:oi-discovery-catalog@@icons@@like_202006280402.png,ox-24,oy-617,ow-29:q-80/et00302403-jmbsnyjdek-portrait.jpg")
        imagsPath.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4eMXdqzZocxef0inw87nAsHdhU3va83sDYg&usqp=CAU")
        banner.adapter = BannerAdapter(applicationContext,imagsPath,imagLis)
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
                startActivity(Intent(applicationContext,AmazonActivity::class.java))
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
            R.id.menu_home -> {
                startActivity(Intent(applicationContext,HomeActivity::class.java))
                return true
            }
            R.id.menu_settings -> {
                startActivity(Intent(applicationContext,FlipkartActivity::class.java))
                return true
            }
            R.id.menu_dialog -> {
                startActivity(Intent(applicationContext, BarrelActivity::class.java))
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }

        }
    }


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menu?.setHeaderTitle("View As")
        menu?.add("MOVE Up")
        menu?.add("MOVE Down")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        if(item.title.toString().equals("MOVE Up")){
            Log.e("ContextMenu","Up")
        }else if(item.title.toString().equals("MOVE Down")){
            Log.e("ContextMenu","Down")
        }
        return super.onContextItemSelected(item)

    }

}