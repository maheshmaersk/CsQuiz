package com.amvlabs.csquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.amvlabs.csquiz.databinding.ActivityAnimationPracticeBinding
import java.util.*

class AnimationPracticeActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    lateinit var binding: ActivityAnimationPracticeBinding

    private var tts: TextToSpeech? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tts = TextToSpeech(binding.btt2s.context, this)


        binding.btFade.setOnClickListener {
            binding.animIma.startAnimation(AnimationUtils.loadAnimation(it.context, R.anim.fade_in))
        }
        binding.btFadeout.setOnClickListener {
            binding.animIma.startAnimation(
                AnimationUtils.loadAnimation(
                    it.context,
                    R.anim.fade_out
                )
            )
        }
        binding.btSlideUp.setOnClickListener {
            binding.animIma.startAnimation(
                AnimationUtils.loadAnimation(
                    it.context,
                    R.anim.slide_up
                )
            )
        }
        binding.btSlideDown.setOnClickListener {
            binding.animIma.startAnimation(
                AnimationUtils.loadAnimation(
                    it.context,
                    R.anim.slide_down
                )
            )
        }
        binding.btZoom.setOnClickListener {
            binding.animIma.startAnimation(AnimationUtils.loadAnimation(it.context, R.anim.zoom_in))
        }
        binding.btZoomOut.setOnClickListener {
            binding.animIma.startAnimation(
                AnimationUtils.loadAnimation(
                    it.context,
                    R.anim.zoom_out
                )
            )
        }

        binding.btt2s.setOnClickListener {
            initText2Spech()
        }
        binding.bts2p.setOnClickListener {
            speechToText()
        }
        binding.btWebv.setOnClickListener {

        }
    }

    fun initText2Spech() {
        tts?.speak(binding.etSpeechExa.text.toString(), TextToSpeech.QUEUE_FLUSH, null, "")
    }

    //TODO : Implicit & Explicit Intents
    fun speechToText() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        intent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE,
            Locale.getDefault()
        )
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, 10)
        } else {
            Toast.makeText(
                this,
                "Your Device Doesn't Support Speech Input",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            // set US English as language for tts
            val result = tts!!.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "The Language specified is not supported!")
            } else {
                binding.bts2p.isEnabled = true
            }

        } else {
            Log.e("TTS", "Initilization Failed!")
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            10 -> if (resultCode == RESULT_OK &&
                data != null
            ) {
                val result =
                    data.getStringArrayListExtra(
                        RecognizerIntent.EXTRA_RESULTS
                    )
                binding.tvTextExa.text = result?.get(0)
            }
        }
    }

}