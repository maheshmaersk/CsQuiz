package com.amvlabs.csquiz.retrofitsample

import com.google.gson.annotations.SerializedName

data class User(
    var page: Int,
    var per_page: Int,
    var total: Int,
    var total_pages: Int,
    var support: Support,
    @SerializedName("data") var userList: ArrayList<UserDetails>
)
