package com.example.viewanimation

import android.content.Intent
import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.*
import com.example.viewanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)


        title = "MainActivity"
        binding.start.setOnClickListener {button->
            val myResAnimSet = AnimationUtils.loadAnimation(this, R.anim.my_anim)

            myResAnimSet.setAnimationListener(object: Animation.AnimationListener{
                override fun onAnimationStart(p0: Animation?) {
                    Log.d("MainActivity", "onAnimationStart: ")
                }

                override fun onAnimationEnd(p0: Animation?) {
                    Log.d("MainActivity", "onAnimationEnd: button animation finished")
                    val intent = Intent(applicationContext, SecondActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out)
                }

                override fun onAnimationRepeat(p0: Animation?) {
                    Log.d("MainActivity", "onAnimationRepeat: ")
                }

            })
            button.startAnimation(myResAnimSet)


            binding.view.setBackgroundResource(R.drawable.my_frame_anim)
            val bgAnim = binding.view.background
            if (bgAnim is Animatable){
                bgAnim.start()
            }
//            val myAnimationSet = AnimationSet(true)
//            myAnimationSet.duration = 3000
//            val translate = TranslateAnimation(
//                0f,
//            300f,
//                 0f,
//                 300f
//            )
//
//            val rotate = RotateAnimation(0f, 360f)
//            val alpha = AlphaAnimation(1f, 0f)
//            val scale = ScaleAnimation(
//                1f, 3f,
//            1f, 3f)
//
//
//            myAnimationSet.apply{
//                addAnimation(translate)
//                addAnimation(rotate)
//                addAnimation(alpha)
//                addAnimation(scale)
//            }
//
//            button.startAnimation(myAnimationSet)

        }


        binding.startActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out)

        }


    }
}