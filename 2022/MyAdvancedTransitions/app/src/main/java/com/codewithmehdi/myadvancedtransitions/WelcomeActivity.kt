package com.codewithmehdi.myadvancedtransitions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.core.view.forEach
import androidx.core.view.forEachIndexed
import com.codewithmehdi.myadvancedtransitions.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.list.forEach {
            it.setOnClickListener { view->
                when(view.id){
                    R.id.go_explode_slide -> startActivity(
                        Intent(this, ExplodeSlideActivity::class.java)
                    )
                    R.id.go_coordinated -> {
                        binding.list.forEachIndexed { index, listItem ->
                            listItem.postDelayed(
                                {
                                    TransitionManager.beginDelayedTransition(
                                        binding.root,
                                        Slide(Gravity.END)
                                    )

                                    listItem.visibility = View.INVISIBLE
                                },
                                index * 200 .toLong()
                            )

                        }
                    }

                    R.id.go_transforms -> {

                    }

                    R.id.go_shared_element_transition -> {

                    }

                    R.id.go_window_content_transition -> {

                    }

                    R.id.go_fragment_transition -> {

                    }

                    else -> Toast.makeText(applicationContext, R.string.not_implemented,
                        Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
}