package com.amvlabs.csquiz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.*
import com.amvlabs.csquiz.adapter.UserAdapter
import com.amvlabs.csquiz.model.User
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

        lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext= applicationContext
        val checkBo = findViewById<AppCompatCheckBox>(R.id.cbAcceptTerms)
        val rbMale = findViewById<AppCompatRadioButton>(R.id.rbMale)
        val rbFeMale = findViewById<AppCompatRadioButton>(R.id.rbFeMale)
        val loginButton = findViewById<TextInputEditText>(R.id.btLogin)
        val genderButton = findViewById<AppCompatButton>(R.id.btGender)
        val llddd = findViewById<LinearLayoutCompat>(R.id.llDynamicCheck)
        val countries = findViewById<AppCompatSpinner>(R.id.spCountries)
        val music = findViewById<AppCompatSeekBar>(R.id.sbMusic)
        val rate = findViewById<AppCompatRatingBar>(R.id.rbRate)



        loginButton.setOnClickListener {
            Log.d("TestLogs", "Login Bt Click")
            startActivity(Intent(it.context, OnBoardingActivity::class.java))
        }

        genderButton.setOnClickListener {
            var das = if (rbMale.isChecked) {
                "male"
            } else if(rbFeMale.isChecked) {
                "Female"
            } else {
                "N/A"
            }
            Log.e("GenderLogs", das)
        }


        var correctNam = CheckBox(this)
        var inCorrectNam = CheckBox(this)
        var wrongNam = CheckBox(this)

        llddd.layoutParams = LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        correctNam.text = "Correct Name"
        inCorrectNam.text = "InCorrect Name"
        wrongNam.text = "Wrong Name"
        llddd.addView(correctNam)
        llddd.addView(inCorrectNam)
        llddd.addView(wrongNam)

        checkBo.setOnCheckedChangeListener { compoundButton, isChecked ->
            Log.e("MainCb", "CheckBox Clicked $isChecked")
        }

        val stateList = arrayListOf<String>("Ka","Tn","MH","AP","TS")
//
        val mAdapter = ArrayAdapter(mContext,android.R.layout.simple_spinner_dropdown_item,stateList)
        countries.adapter= mAdapter

        countries.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Snackbar.make(view!!, "${parent!!.getItemAtPosition(position)}", Snackbar.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Snackbar.make(parent!!.rootView, "Nothing Selected", Snackbar.LENGTH_SHORT).show()
            }

        }


        music.incrementProgressBy(10)
        music.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.e("SeekBar","onProgressChanged $progress")
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                Log.e("SeekBar","onStartTrackingTouch")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Log.e("SeekBar","onStopTrackingTouch ${p0?.progress}")
            }
        })

        rate.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { p0, p1, p2 -> Log.e("RatingBar","progress $p1") }

        chipsUnderstanding()
        listUnderstanding()
        listDynamicUnderstanding()

    }

    private fun chipsUnderstanding(){
        val indiaCp = findViewById<Chip>(R.id.cpIndia)
        val ausCp = findViewById<Chip>(R.id.cpAus)
        val canCp = findViewById<Chip>(R.id.cpCan)
        val cpNak = findViewById<ChipGroup>(R.id.cpMain)

        indiaCp.setOnCloseIconClickListener {
            cpNak.removeView(it)
        }
    }
    private fun listUnderstanding(){
        val crickTeam = findViewById<ListView>(R.id.lvCricketTeams)
        val stateList = arrayListOf<String>("Ka","Tn","MH","AP","TS")
        val mAdapter = ArrayAdapter(mContext,android.R.layout.simple_list_item_checked,stateList)
        crickTeam.adapter= mAdapter
    }

    private fun listDynamicUnderstanding(){
        val contactInfo = findViewById<ListView>(R.id.lvContactInfo)
        val stateList : ArrayList<User> = ArrayList()
        stateList.add(User("Harsha","BMS","harsha@gmail.com"))
        stateList.add(User("Deepak","PES","Deepak@gmail.com"))
        stateList.add(User("Siddu","VTU","Siddu@gmail.com"))
        stateList.add(User("Chandana","MIT","Chandana@gmail.com"))
        stateList.add(User("charvi","NIT","charvi@gmail.com"))
//        val mAdapter = ArrayAdapter(mContext,android.R.layout.simple_list_item_checked,stateList)
        val mAdapter = UserAdapter(mContext,stateList)
        contactInfo.adapter= mAdapter
    }
}