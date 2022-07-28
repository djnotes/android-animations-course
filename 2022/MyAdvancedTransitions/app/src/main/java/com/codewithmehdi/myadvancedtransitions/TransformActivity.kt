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
            TransitionManager.beginDelayedTransition(binding.root, ChangeTransform())
            image.scaleX = 1.5f
            image.scaleY = 1.5f
            image.rotation = -35f
        }
        binding.changeImageTransformImage.setOnClickListener {image->
            TransitionManager.beginDelayedTransition(binding.root, ChangeImageTransform())
            (image as ImageView).scaleType = ImageView.ScaleType.FIT_XY
        }
        binding.changeClipBoundsImage.setOnClickListener {  image->
            TransitionManager.beginDelayedTransition(binding.root, ChangeClipBounds())
            val width = image.width
            val height = image.height
            image.clipBounds = Rect(50, 50, width - 30, height - 30)
        }


    }
}