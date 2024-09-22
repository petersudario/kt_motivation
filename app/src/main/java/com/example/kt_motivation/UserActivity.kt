package com.example.kt_motivation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.kt_motivation.databinding.UserBinding

class UserActivity : ComponentActivity(), View.OnClickListener {
    private lateinit var binding: UserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = UserBinding.inflate(layoutInflater)
        binding.buttonSave.setOnClickListener(this)
        setContentView(binding.root)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()

        }
    }

    private fun handleSave() {
        val name = binding.editName.text.toString()
        if (name != "") {

            SecurityPreferences(this).storeString("USER_NAME", name)

            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )  // Responsible for page redirecting
            finish() // Destroys the current activity
        } else {
            print("did not work")
            Toast.makeText(this, "Name is required", Toast.LENGTH_SHORT).show()
        }
    }
}