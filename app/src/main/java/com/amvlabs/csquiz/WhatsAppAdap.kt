package com.amvlabs.csquiz

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class WhatsAppAdap(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val count = 3
    override fun getCount(): Int {
        return count
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ChatFragment()
            1 -> CallFragment()
            2 -> ChatFragment()
            else -> {
                CallFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Tab ${position + 1}"
    }
}