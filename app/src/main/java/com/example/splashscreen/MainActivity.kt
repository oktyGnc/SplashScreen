package com.example.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val splashTimeOut: Long = 3000

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        findViewById<ImageView>(R.id.splashScreen).startAnimation(animation)

        CoroutineScope(Dispatchers.Main).launch {
            delay(splashTimeOut)
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
            finish()
        }

    }
}
