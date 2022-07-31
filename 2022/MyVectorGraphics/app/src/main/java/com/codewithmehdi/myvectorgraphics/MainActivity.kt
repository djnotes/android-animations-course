package com.codewithmehdi.myvectorgraphics

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.forEach
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.codewithmehdi.myvectorgraphics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.startAVDsStatic.setOnClickListener {
            binding.AVDsContainer.forEach {view->
                if (view is ImageView){
                    (view.drawable as AnimatedVectorDrawable).start()
                }
            }
        }



    }
}