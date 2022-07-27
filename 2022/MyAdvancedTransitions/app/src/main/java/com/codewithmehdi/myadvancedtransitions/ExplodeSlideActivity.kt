package com.codewithmehdi.myadvancedtransitions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.transition.Explode
import androidx.transition.Slide
import androidx.transition.TransitionManager
import com.codewithmehdi.myadvancedtransitions.databinding.ActivityMainBinding

class ExplodeSlideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.dog.setOnClickListener {
            val explode = Explode()

            TransitionManager.beginDelayedTransition(
                binding.root, explode
            )

            binding.dog.visibility = View.INVISIBLE
        }


        binding.cat.setOnClickListener {

            val slide = Slide(Gravity.LEFT)

            TransitionManager.beginDelayedTransition(
                binding.root,
                slide
            )

            binding.cat.visibility = View.INVISIBLE
        }


        binding.reset.setOnClickListener {
            TransitionManager.beginDelayedTransition(
                binding.root,
                Explode()
            )

            binding.dog.visibility = View.VISIBLE

            TransitionManager.beginDelayedTransition(
                binding.root,
                Slide(Gravity.END)
            )

            binding.cat.visibility = View.VISIBLE
        }
    }
}