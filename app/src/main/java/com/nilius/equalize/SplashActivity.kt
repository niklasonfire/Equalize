package com.nilius.equalize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar


class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        //hide progressbar for now
        var progressBar = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar
        progressBar.visibility = View.INVISIBLE;


        Handler(Looper.getMainLooper()).postDelayed ({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}