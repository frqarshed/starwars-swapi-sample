package com.sample.data.core

import android.app.Application
import com.sdk.starwars.presentation.core.main.StarWarsController

fun Application.initializeApp() {
    StarWarsController.initializeSDK(this)
}
