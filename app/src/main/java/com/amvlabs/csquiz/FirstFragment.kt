package com.amvlabs.csquiz

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.amvlabs.csquiz.databinding.FragmentFirstBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    lateinit var mContext: Context
    var cal = Calendar.getInstance()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        mContext = binding.buttonFirst.context
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.btDialog.setOnClickListener {
            showDialog()
        }
        binding.btDatePicker.setOnClickListener {
            showDate()
        }
        binding.btTimePicker.setOnClickListener {
            showTime()
        }
        binding.btBottomSheet.setOnClickListener {
            showBottomSheet()
        }

        binding.btBottomSheetDialog.setOnClickListener {
        }
    }

    fun showDialog() {
        val build = AlertDialog.Builder(mContext)
        build.setTitle("Like the APP")
        build.setMessage("Are you liking the APP Development?")
        build.setPositiveButton("Yes") { di, w ->
            Toast.makeText(mContext, "Thanks For feedback", Toast.LENGTH_LONG).show()
        }
        build.setNegativeButton("No") { di, which ->
            Toast.makeText(mContext, "We would try to imporve.", Toast.LENGTH_LONG).show()
        }
        build.setNeutralButton("Do Later") { di, which ->
            Toast.makeText(mContext, "We would try to imporve.", Toast.LENGTH_LONG).show()
        }

        val alertDialog = build.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    fun showDate() {
        val dateSelectlis =
            DatePickerDialog.OnDateSetListener { p0, year, month, dayOfMonth ->
                binding.tvDateSelected.text = "$dayOfMonth/${month+1}/$year"
                showTime()
            }

        DatePickerDialog(
            mContext,
            dateSelectlis,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    fun showTime() {
        val timse = TimePickerDialog.OnTimeSetListener { timePicker, hourOfDay, minutes ->
            binding.tvTimeSelected.text = "$hourOfDay:$minutes"
        }
        TimePickerDialog(mContext,timse,cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),true).show()
    }

    fun showBottomSheet() {
        val bDialog = BottomSheetDialog(mContext)
        bDialog.setContentView(R.layout.layout_bottom_sheet)
        val amsd = bDialog.findViewById<TextView>(R.id.tvTitle)
        amsd?.setOnClickListener {
            bDialog.dismiss()
        }
        bDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}