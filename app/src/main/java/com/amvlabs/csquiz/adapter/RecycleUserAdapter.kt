package com.amvlabs.csquiz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.amvlabs.csquiz.R
import com.amvlabs.csquiz.model.User

class RecycleUserAdapter(private var userList: ArrayList<User>) :
    RecyclerView.Adapter<RecycleUserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val vie = LayoutInflater.from(parent.context).inflate(R.layout.user_info_adapter,parent,false)
        return UserViewHolder(vie)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.email.text = userList[position].email
        holder.name.text = userList[position].name
        holder.college.text = userList[position].college
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name = view.findViewById<AppCompatTextView>(R.id.title)
        var college = view.findViewById<AppCompatTextView>(R.id.year)
        var email = view.findViewById<AppCompatTextView>(R.id.genre)
    }
}