package me.mehdi.progresslottie

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View

import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun startAnimation(view: View) {
        val lottie = findViewById<LottieAnimationView>(R.id.lottieView)
        lottie.visibility = View.VISIBLE
        lottie.playAnimation()
    }
}
