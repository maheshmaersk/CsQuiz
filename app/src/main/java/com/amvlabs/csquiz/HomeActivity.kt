package com.amvlabs.csquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amvlabs.csquiz.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewPager()
    }

    private fun setViewPager(){
        val pager = binding.vPager
        pager.adapter = WhatsAppAdap(supportFragmentManager)
    }
}