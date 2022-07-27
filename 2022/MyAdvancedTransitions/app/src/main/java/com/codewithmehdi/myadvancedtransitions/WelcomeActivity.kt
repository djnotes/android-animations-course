package com.codewithmehdi.myadvancedtransitions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.widget.Toast
import androidx.core.view.forEach
import com.codewithmehdi.myadvancedtransitions.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.forEach {
            it.setOnClickListener { view->
                when(view.id){
                    R.id.go_explode_slide -> startActivity(
                        Intent(this, ExplodeSlideActivity::class.java)
                    )
                    R.id.go_coordinated -> {

                    }

                    else -> Toast.makeText(applicationContext, R.string.not_implemented,
                        Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
}