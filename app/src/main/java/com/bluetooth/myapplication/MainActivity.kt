package com.bluetooth.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.bluetooth.bluelibrary.view.MainActivityLib
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {
    private var lytFrame: FrameLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       startActivity(Intent(this, MainActivityLib::class.java))
    }

}