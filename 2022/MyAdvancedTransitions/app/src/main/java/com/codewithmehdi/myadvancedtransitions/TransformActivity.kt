package com.codewithmehdi.myadvancedtransitions

import android.graphics.Rect
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.ChangeClipBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.ChangeTransform
import androidx.transition.TransitionManager
import com.codewithmehdi.myadvancedtransitions.databinding.ActivityTransformBinding

class TransformActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTransformBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransformBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.changeTransformImage.setOnClickListener {image->
            //TODO:
        }
        binding.changeImageTransformImage.setOnClickListener {image->
            //TODO:
        }
        binding.changeClipBoundsImage.setOnClickListener {  image->
            //TODO:
        }


    }
}