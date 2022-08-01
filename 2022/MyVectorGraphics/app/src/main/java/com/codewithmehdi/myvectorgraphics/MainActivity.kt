package com.codewithmehdi.myvectorgraphics

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
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


        binding.startAVDDynamic.setOnClickListener{
            val avd = AnimatedVectorDrawableCompat.create(this, R.drawable.avd_progress_circle)
            findViewById<ViewGroup>(android.R.id.content).addView(
                ImageView(this).apply{
                    setImageDrawable(avd)
                }
            )

            avd?.start()
        }

        binding.startAVDBackground.setOnClickListener{button->
            button.setBackgroundResource(R.drawable.avd_writing_tick)
            (button.background as AnimatedVectorDrawable).start()
        }



    }
}