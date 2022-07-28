package com.codewithmehdi.myadvancedtransitions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.Slide
import android.view.Gravity
import com.codewithmehdi.myadvancedtransitions.databinding.ActivityMyFragmentBinding

class MyFragmentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMyFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMyFragmentBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.trigger.setOnClickListener {
            //TODO: Add fragment to FrameLayout

        }


    }
}