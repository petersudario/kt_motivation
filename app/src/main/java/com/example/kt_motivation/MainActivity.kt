package com.example.kt_motivation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.kt_motivation.databinding.MainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: MainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}