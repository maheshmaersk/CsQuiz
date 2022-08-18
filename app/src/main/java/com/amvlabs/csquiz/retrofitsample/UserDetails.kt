package com.amvlabs.csquiz.retrofitsample

import com.google.gson.annotations.SerializedName

data class UserDetails(
    var id: Int,
    var email: String,
    @SerializedName("first_name") var fName: String,
    @SerializedName("last_name") var lName: String,
    @SerializedName("avatar") var userImage: String
)
