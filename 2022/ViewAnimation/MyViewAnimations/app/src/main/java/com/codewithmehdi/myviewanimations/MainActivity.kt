package com.codewithmehdi.myviewanimations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
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

        val loadedAnim  = AnimationUtils.loadAnimation(this, R.anim.my_animation)
        loadedAnim.duration = 2000

        binding.startShow.setOnClickListener {
            binding.welcome.startAnimation(animationSet)
            binding.art.startAnimation(loadedAnim)
        }

        binding.startSecond.setOnClickListener {
            startActivity(
                Intent(this, SecondActivity::class.java)
            )

            overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out)
        }

    }
}