package com.example.mynavigation

import java.io.Serializable

class DataClassUser(
    val name:String,
    val surname:String,
    var age:Int,
    val birthday:String
):Serializable