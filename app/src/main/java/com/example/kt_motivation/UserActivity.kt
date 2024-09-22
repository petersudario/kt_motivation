package com.example.kt_motivation

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.example.kt_motivation.databinding.UserBinding

class UserActivity :  ComponentActivity(), View.OnClickListener {
    private lateinit var binding: UserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = UserBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            var s = ""
        }
    }
}