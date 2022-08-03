package com.codewithmehdi.playwithmotionlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codewithmehdi.playwithmotionlayout.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}