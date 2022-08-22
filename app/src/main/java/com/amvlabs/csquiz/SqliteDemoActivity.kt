package com.amvlabs.csquiz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.amvlabs.csquiz.databinding.ActivityImplBinding
import com.amvlabs.csquiz.databinding.ActivitySqliteDemoBinding

class SqliteDemoActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySqliteDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSave.setOnClickListener {
            val db = DbHelper(this, null)

            db.addName(binding.etName.text.toString(), binding.etEmail.text.toString())
            Toast.makeText(it.context, "Added Successfully", Toast.LENGTH_LONG).show()
            binding.etName.text?.clear()
            binding.etEmail.text?.clear()
        }


        binding.btRetrieve.setOnClickListener {
            val db = DbHelper(this, null)
            val Name: String? = null
            val email: String? = null
            val cursor = db.getName()

            cursor!!.moveToFirst()
            Log.e("email", cursor.getString(cursor.getColumnIndex(DbHelper.EMAIL_COL)))
            Log.e("name", cursor.getString(cursor.getColumnIndex(DbHelper.NAME_COl)))

            // moving our cursor to next
            // position and appending values
            while (cursor.moveToNext()) {
                Log.e("email", cursor.getString(cursor.getColumnIndex(DbHelper.EMAIL_COL)))
                Log.e("name", cursor.getString(cursor.getColumnIndex(DbHelper.NAME_COl)))
//                cursor.getString(cursor.getColumnIndex(DbHelper.NAME_COl))
//                cursor.getString(cursor.getColumnIndex(DbHelper.EMAIL_COL))
            }

            // at last we close our cursor
            cursor.close()

        }

    }
}