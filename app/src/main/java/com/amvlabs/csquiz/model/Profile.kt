package com.amvlabs.csquiz.model

import com.google.gson.annotations.SerializedName

/*
* {
* "name": "Harsha",
* "address": "bangalore",
* "ab": {
* "primary":"34234",
* "additional":"34234"
* "home":"324234"
* },
* "bas": "true",
* "marks":[
* {
* "percentage":94.5,
* "College":"VTU"
* "Type":"Graduate"
* },
* {
* "percentage":54.5,
* "College":"KSE"
* "Type":"Secondary School"
* }
* ]
* }
*
* GSON - Google (Google)
* JSON - Java Script Object Notiation(Oracle)
* */


data class Profile(
    val name: String,
    val address: String,
    @SerializedName("ab") val mobile: Mobile,
    val bas: Boolean,
    val marks: ArrayList<Marks>
)

