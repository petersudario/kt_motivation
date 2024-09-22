package com.example.kt_motivation.ui.activities

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.example.kt_motivation.R
import com.example.kt_motivation.infra.SecurityPreferences
import com.example.kt_motivation.databinding.MainBinding

/**
 * Main screen of the app
 */
class MainActivity : ComponentActivity(), View.OnClickListener {
    private lateinit var binding: MainBinding;


    /**
     * Sets the "hello" message with the user's name
     */
    private fun handleUserName() {
        val name = SecurityPreferences(this).getStoredString("USER_NAME")
        if (name != "") {
            binding.helloUser.text = "Hello, $name!"
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleUserName()
        binding.buttonNewPhrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase) {
            var s = ""
        }
    }


}