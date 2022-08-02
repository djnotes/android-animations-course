package com.codewithmehdi.myphysicalanimationapp

import android.media.MediaPlayer
import android.os.Bundle
import android.util.TypedValue
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.codewithmehdi.myphysicalanimationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private var gestureDetectors: MutableMap<View, GestureDetector> = mutableMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)





        val myViews = listOf(
            binding.sun,
            binding.cloud1,
            binding.cloud2,
            binding.bird
        )

        myViews.forEach { image->
            gestureDetectors[image] = GestureDetector(this, MyOnGestureListener(image))
        }

        //Initialize gesture listeners
        myViews.forEach {image->
            image.setOnTouchListener { v, event ->
                gestureDetectors[v]!!.onTouchEvent(event)
            }
        }


        binding.land.setOnClickListener {
            SpringAnimation(
                binding.greeting,
                DynamicAnimation.Y
            ).apply{
                spring = SpringForce().apply{
                    dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
                    stiffness = SpringForce.STIFFNESS_LOW
                    finalPosition = 0f
                }

                val dpPerSec = -100f
                val pxPerSec = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    dpPerSec,
                    resources.displayMetrics
                )

                setStartVelocity(pxPerSec)

                start()
                MediaPlayer.create(this@MainActivity, R.raw.hello)
                    .start()

            }


        }


    }
}



class MyOnGestureListener(private val view: View): SimpleOnGestureListener(){
    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        FlingAnimation(view, DynamicAnimation.Y).apply{
            setMinValue(0f)
            setMaxValue(view.resources.displayMetrics.heightPixels.toFloat() - view.height)
            setStartVelocity(velocityY)
            start()
        }

        FlingAnimation(view, DynamicAnimation.X).apply{
            setMinValue(0f)
            setMaxValue(view.resources.displayMetrics.widthPixels.toFloat() - view.width)
            setStartVelocity(velocityX)
            start()
        }

        return super.onFling(e1, e2, velocityX, velocityY)
    }
}