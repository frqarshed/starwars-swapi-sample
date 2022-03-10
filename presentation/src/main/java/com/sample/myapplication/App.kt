package com.sample.myapplication

import android.app.Application
import com.sample.data.core.initializeApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeApp()
    }
}