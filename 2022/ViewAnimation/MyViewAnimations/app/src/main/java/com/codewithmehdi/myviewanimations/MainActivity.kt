package com.codewithmehdi.myviewanimations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import com.codewithmehdi.myviewanimations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val translate = TranslateAnimation(0f, 0f, 0f, 400f)

        val alpha = AlphaAnimation(0f, 1f)

        val scale = ScaleAnimation(1f, 1.2f, 1f, 2f, 0f, 0f)

        val animationSet = AnimationSet(true)

        animationSet.apply{
            addAnimation(translate)
            addAnimation(alpha)
            addAnimation(scale)
            duration = 2000
            interpolator = AnticipateOvershootInterpolator()
        }

        binding.startShow.setOnClickListener {
            binding.welcome.startAnimation(animationSet)
        }
    }
}