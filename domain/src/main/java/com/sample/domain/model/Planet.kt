package com.sample.domain.model

import java.io.Serializable
import java.util.*

data class Planets(
    val count: Int,
    val planets: List<Planet>
) : Serializable

data class Planet(
    val name: String,
    val climate: String,
    val diameter: String,
    val created: Date?,
    val edited: Date?,
    val gravity: String,
    val orbitalPeriod: String,
    val population: String,
    val rotationPeriod: String,
    val surfaceWater: String,
    val terrain: String,
    val filmsIds: List<Int>,
    val residentsIds: List<Int>,
) : Serializable