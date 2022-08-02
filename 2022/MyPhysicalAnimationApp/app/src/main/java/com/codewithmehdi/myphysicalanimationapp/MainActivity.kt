package com.codewithmehdi.myphysicalanimationapp

import android.os.Bundle
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation
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