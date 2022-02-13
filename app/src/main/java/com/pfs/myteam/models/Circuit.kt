package com.pfs.myteam.models

data class Circuit (
    val corners: Int,
    val image: String,
    val circuitLength: Double,
    val laps: Int,
    val name: String,
    val raceLength: Double,
    val raceWeek: Int,
)
