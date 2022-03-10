package com.sample.domain.model

import android.graphics.Color
import java.io.Serializable
import java.util.*

data class Characters(
    val count: Int,
    val people: List<Character>
) : Serializable

data class Character(
    val name: String,
    val birthYear: String,
    val created: Date?,
    val edited: Date?,
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    val height: String,
    val homeWorldId: Int?,
    val mass: String,
    val skinColor: String,
    val filmsIds: List<Int>,
    val speciesIds: List<Int>,
    val starshipsIds: List<Int>,
    val vehiclesIds: List<Int>
) : Serializable {

    enum class EyeColor(val eyeColor: String, val hexValue: Int) {
        BLUE("blue", Color.parseColor("#0000FF")),
        YELLOW("yellow", Color.parseColor("#FFFF00")),
        RED("red", Color.parseColor("#FF0000")),
        BROWN("brown", Color.parseColor("#964B00")),
        BLUE_GRAY("blue-gray", Color.parseColor("#6699CC")),
        UNKNOWN("unknown", Color.parseColor("#000000"));


        companion object {
            fun fromString(value: String): EyeColor =
                values().find { it.eyeColor == value } ?: UNKNOWN
        }

    }
}