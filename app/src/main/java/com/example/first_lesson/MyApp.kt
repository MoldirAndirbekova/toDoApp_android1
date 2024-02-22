package com.example.first_lesson

import android.app.Application
import android.util.Log

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Log.i("MyApp", "onCreate")
    }
}