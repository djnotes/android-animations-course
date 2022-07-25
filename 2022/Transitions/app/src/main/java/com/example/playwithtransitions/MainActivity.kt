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
import androidx.transition.TransitionInflater
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
            val scene2 = Scene.getSceneForLayout(binding.root, R.layout.other_layout, this)
//
//            val t1 = Fade()
//            val t2 = ChangeBounds()
//
//            val transitionSet = TransitionSet()
//
//            transitionSet.apply{
//                addTransition(t1)
//                addTransition(t2)
//                interpolator = AnticipateOvershootInterpolator()
//                duration = 500
//            }
//
//            TransitionManager.go(scene2, transitionSet)
            val myTransitionSet = TransitionInflater.from(this)
                .inflateTransition(R.transition.my_transitions)

//            val myTransitionMgr = TransitionInflater.from(this)
//                .inflateTransitionManager(R.transition.my_transition_mgr, binding.root)
//
//            myTransitionMgr.transitionTo(scene2)

            TransitionManager.go(scene2, myTransitionSet)
        }
    }
}