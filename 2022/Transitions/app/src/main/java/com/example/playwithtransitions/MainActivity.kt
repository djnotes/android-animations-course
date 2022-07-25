package com.example.playwithtransitions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnticipateInterpolator
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.OvershootInterpolator
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import androidx.transition.AutoTransition
import androidx.transition.ChangeBounds
import androidx.transition.Fade
import androidx.transition.Scene
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
import androidx.transition.Visibility
import com.example.playwithtransitions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.hello.setOnClickListener{
            val t1 = ChangeBounds()

            val t2 = Fade(Visibility.MODE_IN)

            val set = TransitionSet()
            set.apply{
                addTransition(t1)
                addTransition(t2)
                duration = 1000
                interpolator = AnticipateOvershootInterpolator()
            }


            val scene2 = Scene.getSceneForLayout(binding.root, R.layout.other_layout, this)
            TransitionManager.go(scene2, set)

        }
    }
}