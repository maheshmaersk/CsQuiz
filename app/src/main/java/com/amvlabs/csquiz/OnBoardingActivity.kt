package com.amvlabs.csquiz

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.amvlabs.csquiz.databinding.ActivityOnBoardingBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class OnBoardingActivity : AppCompatActivity() {

    lateinit var mContext: Context

    private lateinit var binding : ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mContext = binding.tetUserName.context

        binding.btShow.setOnClickListener {
            val userEnter = binding.tetUserName.text.toString()
            val passEnter = binding.tetPassword.text.toString()

            if (userEnter.trim().isEmpty()) {
                binding.tilUserName.error = "Username cannot be empty"
            } else if (passEnter.trim().isEmpty()) {
                binding.tilUserName.error=null
                binding.tilPassword.error = "Password cannot be empty"
            } else {
                binding.tilUserName.error=null
                binding.tilPassword.error=null
                Toast.makeText(mContext, "Username is $userEnter", Toast.LENGTH_LONG).show()
                Snackbar.make(it, "Username is $userEnter", Snackbar.LENGTH_SHORT)
                    .setAction("UnDo") {
                        Toast.makeText(mContext, "Connected", Toast.LENGTH_LONG).show()
                    }.show()
            }
        }



    }
}