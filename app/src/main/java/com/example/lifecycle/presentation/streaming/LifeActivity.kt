package com.example.lifecycle.presentation.streaming

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LifeActivity : AppCompatActivity() {

    private val liveVideo = LiveVideo()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(liveVideo)
    }
}