package com.codewithmehdi.myphysicalanimationapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codewithmehdi.myphysicalanimationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

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

        //Initialize gesture listeners
        myViews.forEach {image->

        }



    }
}
