package com.example.playwithtransitions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.OvershootInterpolator
import androidx.constraintlayout.widget.ConstraintSet
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import androidx.transition.AutoTransition
import androidx.transition.ChangeBounds
import androidx.transition.Fade
import androidx.transition.Scene
import androidx.transition.TransitionInflater
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
import androidx.transition.Visibility
import com.example.playwithtransitions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var scene2: Scene
    private lateinit var mainScene: Scene
    private var transitionStarted = false
    private lateinit var myTransitionSet: TransitionSet


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        mainScene = Scene.getSceneForLayout(binding.root, R.layout.activity_main, this)
        scene2 = Scene.getSceneForLayout(binding.root, R.layout.other_layout, this)

        myTransitionSet = TransitionInflater.from(this)
            .inflateTransition(R.transition.my_transitions) as TransitionSet

        binding.hello.setOnClickListener{
//
//            TransitionManager.beginDelayedTransition(binding.root, myTransitionSet)
//            binding.group.visibility = View.VISIBLE
//            binding.hello.visibility = View.GONE


//            TransitionManager.go(scene2, myTransitionSet)
//            transitionStarted = true

            val constraintSet = ConstraintSet()
            constraintSet.clone(this, R.layout.other_layout)
            TransitionManager.beginDelayedTransition(binding.root, myTransitionSet)
            constraintSet.applyTo(binding.root)
        }
    }

    override fun onBackPressed() {
        if (transitionStarted){
            TransitionManager.go(mainScene)
            transitionStarted = false
        }
        else {
            super.onBackPressed()
        }
    }
}