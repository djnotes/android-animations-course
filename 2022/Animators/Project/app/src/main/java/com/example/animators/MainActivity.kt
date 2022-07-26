package com.example.animators

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.animators.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.hello.setOnClickListener {button->
//            val xScale = ObjectAnimator.ofFloat(button, View.SCALE_X, 5f)
//
//            xScale.repeatCount = 3
//            xScale.repeatMode = ValueAnimator.REVERSE
//            xScale.duration = 1000
//
//            val yScale = ObjectAnimator.ofFloat(button, View.SCALE_Y, 4f)
//            yScale.repeatCount = 3
//            yScale.repeatMode = ValueAnimator.REVERSE
//            yScale.duration = 1000
//
////            val rotate = ObjectAnimator.ofFloat(binding.loudspeaker, View.ROTATION, 1000f)
//
//            val animatorSet = AnimatorSet()
//
//            animatorSet.playTogether(xScale, yScale)
//
//            animatorSet.start()
//
//            binding.loudspeaker.animate()
//                .rotation(1000f)
//                .xBy(200f)
//                .yBy(100f)
//                .alpha(0.5f)
//                .withEndAction {
//                    Toast.makeText(this, "Animation Finished",
//                    Toast.LENGTH_LONG).show()
//                }
//                .start()

            val resAnimator = AnimatorInflater.loadAnimator(
                this, R.animator.my_animator
            )

            resAnimator.setTarget(binding.loudspeaker)

            resAnimator.start()






        }
    }
}