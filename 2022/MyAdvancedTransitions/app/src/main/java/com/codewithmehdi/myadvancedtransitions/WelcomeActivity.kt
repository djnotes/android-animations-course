package com.codewithmehdi.myadvancedtransitions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.forEach
import androidx.core.view.forEachIndexed
import com.codewithmehdi.myadvancedtransitions.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    private var slideDone = false

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
                        slideDone = true

                    }

                    R.id.go_transforms -> {
                        startActivity(
                            Intent(this, TransformActivity::class.java)
                        )
                    }

                    R.id.go_shared_element_transition -> {
                        startActivity(
                            Intent(this, SharedElementActivity::class.java),
                            ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                            binding.cat, "cat")
                                .toBundle()
                        )
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

    override fun onBackPressed() {
        if (slideDone){
            binding.list.forEachIndexed { index, view ->
                view.postDelayed({
                    TransitionManager.beginDelayedTransition(
                        binding.root,
                        Slide(Gravity.END)
                    )

                    view.visibility = View.VISIBLE
                },
                index * 200 .toLong())

            }
            slideDone = false
        }
        else
            super.onBackPressed()
    }
}