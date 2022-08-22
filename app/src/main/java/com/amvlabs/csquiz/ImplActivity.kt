package com.amvlabs.csquiz

import android.Manifest
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.amvlabs.csquiz.databinding.ActivityImplBinding
import com.amvlabs.csquiz.model.Marks
import com.amvlabs.csquiz.model.Mobile
import com.amvlabs.csquiz.model.Profile
import com.amvlabs.csquiz.retrofitsample.APIInterface
import com.amvlabs.csquiz.retrofitsample.User
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class ImplActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityImplBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Intents 2 types Implict Explicit

        binding.btCall.setOnClickListener {
            val mobile = Mobile("324", "342", "234")
            val marks = ArrayList<Marks>()
            marks.add(Marks(45.5f, "VTU", "Graduate"))
            marks.add(Marks(95.5f, "Kuvempu", "POST Graduate"))
            marks.add(Marks(85.5f, "Christ", "Secondary"))
            val profile = Profile("Harsha", "HSR Layout", mobile, true, marks)
            val jsonString = Gson().toJson(profile)

            Log.e("GSONCONVe", jsonString)

            callUserList()
        }
        binding.btPhone.setOnClickListener {
            throw RuntimeException("Test Crash")
        }
        binding.btCamera.setOnClickListener {
            onClickRequestPermission(it)
        }
        binding.btTimer.setOnClickListener {
            startTimer("Test Timer", 30)
        }

        binding.btSqlite.setOnClickListener {
            startActivity(Intent(applicationContext, SqliteDemoActivity::class.java))
        }

    }

    fun startTimer(message: String, seconds: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_LENGTH, seconds)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }


    fun callUserList() {
        val apiInte: APIInterface = APIClient().getClient()!!.create(APIInterface::class.java)
        apiInte.getUsersList().enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                val userD = response.body()
                Log.e("UserResponse",response.body().toString())
                val dat = userD?.userList
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }

        })
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val thumbnail: Bitmap = data?.getParcelableExtra("data")!!
            Log.e("Test", "Camera")
        }
    }

    companion object {
        const val REQUEST_IMAGE_CAPTURE = 1
    }


    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Log.i("Permission: ", "Granted")
            } else {
                Log.i("Permission: ", "Denied")
            }
        }

    fun onClickRequestPermission(view: View) {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                showSnackbar(
                    view,
                    getString(R.string.permission_granted),
                    Snackbar.LENGTH_INDEFINITE,
                    null
                ) {}
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CAMERA
            ) -> {
                showSnackbar(
                    view,
                    getString(R.string.permission_required),
                    Snackbar.LENGTH_INDEFINITE,
                    getString(R.string.ok)
                ) {
                    requestPermissionLauncher.launch(
                        Manifest.permission.CAMERA
                    )
                }
            }

            else -> {
                requestPermissionLauncher.launch(
                    Manifest.permission.CAMERA
                )
            }
        }
    }
}

fun showSnackbar(
    view: View,
    msg: String,
    length: Int,
    actionMessage: CharSequence?,
    action: (View) -> Unit
) {
    val snackbar = Snackbar.make(view, msg, length)
    if (actionMessage != null) {
        snackbar.setAction(actionMessage) {
            action(view)
        }.show()
    } else {
        snackbar.show()
    }
}

