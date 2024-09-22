package com.example.kt_motivation

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.example.kt_motivation.databinding.MainBinding

class MainActivity : ComponentActivity(), View.OnClickListener {
    private lateinit var binding: MainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.helloUser.text = "Hello, ${SecurityPreferences(this).getStoredString("USER_NAME")}!"

        binding.buttonNewPhrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase) {
            var s = ""
        }
    }


}