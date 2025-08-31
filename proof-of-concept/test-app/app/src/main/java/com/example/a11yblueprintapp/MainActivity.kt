package com.example.a11yblueprintapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This line connects the code to the XML layout
        setContentView(R.layout.activity_main)
    }
}