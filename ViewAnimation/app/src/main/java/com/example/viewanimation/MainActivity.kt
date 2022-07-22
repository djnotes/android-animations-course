package com.example.viewanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.*
import com.example.viewanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)

        binding.start.setOnClickListener {button->
            val myAnimationSet = AnimationSet(true)
            myAnimationSet.duration = 3000
            val translate = TranslateAnimation(
                0f,
            300f,
                 0f,
                 300f
            )

            val rotate = RotateAnimation(0f, 360f)
            val alpha = AlphaAnimation(1f, 0f)
            val scale = ScaleAnimation(
                1f, 3f,
            1f, 3f)


            myAnimationSet.apply{
                addAnimation(translate)
                addAnimation(rotate)
                addAnimation(alpha)
                addAnimation(scale)
            }

            button.startAnimation(myAnimationSet)

        }


    }
}