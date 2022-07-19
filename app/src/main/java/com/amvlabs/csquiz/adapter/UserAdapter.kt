package com.amvlabs.csquiz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.amvlabs.csquiz.R
import com.amvlabs.csquiz.model.User
import com.google.android.material.textview.MaterialTextView

class UserAdapter(private val context: Context,private val userList : ArrayList<User>): BaseAdapter() {
    override fun getCount(): Int {
       return userList.size
    }

    override fun getItem(position: Int): Any {
        return  position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView= convertView

        convertView = LayoutInflater.from(context).inflate(R.layout.user_item_adapter,parent,false)

        var name = convertView.findViewById<MaterialTextView>(R.id.mtvName)
        var college = convertView.findViewById<MaterialTextView>(R.id.mtvCollege)
        var email = convertView.findViewById<MaterialTextView>(R.id.mtvEmail)

        name.text = userList[position].name
        email.text = userList[position].email
        college.text = userList[position].college

        return convertView
    }

}