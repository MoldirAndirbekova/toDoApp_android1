package com.example.first_lesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

private const val TAG:String = "ActivityLifeCycle"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.hello_world)
        textView.text = "Hello from Kotlin"

        Log.i(TAG, "MainActivity#onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "MainActivity#onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "MainActivity#onResume")
    }

    override fun onPause() {
        Log.i(TAG, "MainActivity#onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i(TAG, "MainActivity#onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i(TAG, "MainActivity#onDestroy")
        super.onDestroy()
    }
}