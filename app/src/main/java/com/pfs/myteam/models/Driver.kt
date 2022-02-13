package com.pfs.myteam.models

import java.io.Serializable

data class Driver (
    val firstName: String,
    val lastName: String,
    val buyPrice: Int,
    val fantasyPoints: Int,
    val constructor: String,
    val number: Int,
    val seasonPoints: Int,
) : Serializable {

    constructor():this("","",0,0,"",0,0)

    override fun toString(): String {
        return "Driver(firstName='$firstName', lastName='$lastName', buyPrice=$buyPrice, fantasyPoints=$fantasyPoints, constructor='$constructor', number=$number, seasonPoints=$seasonPoints)"
    }


}

