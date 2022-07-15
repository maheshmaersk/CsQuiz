package com.amvlabs.csquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.amvlabs.csquiz.databinding.ActivityFragmentTestsBinding

class FragmentTestsActivity : AppCompatActivity() {

    lateinit var binding: ActivityFragmentTestsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentTestsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button4.setOnClickListener {
            replaceFragment(ChatFragment.newInstance())
        }

        binding.button8.setOnClickListener {
            addFragment(CallFragment.newInstance())
        }
        binding.button5.setOnClickListener {
            val fag = supportFragmentManager.findFragmentByTag(CallFragment::class.simpleName)
            fag?.let {
                removeFragment(it)
            } ?: run {
                Toast.makeText(this, "Username is ", Toast.LENGTH_LONG).show()
            }
        }
        binding.button6.setOnClickListener {
            val fag: Fragment? = supportFragmentManager.findFragmentByTag("Harsha")
            showFragment(fag!!)
        }
        binding.button7.setOnClickListener {
            val fag = supportFragmentManager.findFragmentByTag("Harsha")
            hideFragment(fag!!)
        }

        supportFragmentManager.beginTransaction().apply {
            add(binding.replaceCont.id, CallFragment.newInstance(), CallFragment::class.simpleName)
//            replace(binding.replaceCont.id, CallFragment.newInstance())
//            addToBackStack("mahe")
            commit()
        }
    }

    private fun replaceFragment(fragmentChange: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.replaceCont.id, fragmentChange)
            addToBackStack("harsha")
            commit()
        }
    }

    private fun removeFragment(fragmentChange: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            remove(fragmentChange)
            commit()
        }
    }

    private fun addFragment(fragmentChange: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            add(binding.replaceCont.id, fragmentChange, fragmentChange::class.simpleName)
            commit()
        }
    }

    private fun showFragment(fragmentChange: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            show(fragmentChange)
            commit()
        }
    }

    private fun hideFragment(fragmentChange: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            hide(fragmentChange)
            commit()
        }
    }
}