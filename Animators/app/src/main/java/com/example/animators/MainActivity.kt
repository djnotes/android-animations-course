package com.example.animators

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.animators.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.hello.setOnClickListener {button->
            val xScale = ObjectAnimator.ofFloat(button, View.SCALE_X, 5f)

            xScale.repeatCount = 3
            xScale.repeatMode = ValueAnimator.REVERSE
            xScale.duration = 1000

            xScale.start()
        }
    }
}