package com.example.kt_motivation.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.kt_motivation.infra.MotivationConstants
import com.example.kt_motivation.R
import com.example.kt_motivation.infra.SecurityPreferences
import com.example.kt_motivation.databinding.UserBinding

/**
 * User login screen
 */
class UserActivity : ComponentActivity(), View.OnClickListener {
    private lateinit var binding: UserBinding

    /**
     * Handles the user's name, saving in the SharedPreferences
     */
    private fun handleSave() {
        val name = binding.editName.text.toString()
        if (name != "") {

            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)

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

    /**
     * Checks if the user has already entered their name before
     */
    private fun verifyUserName() {
        val name = SecurityPreferences(this).getStoredString(MotivationConstants.KEY.USER_NAME)
        if (name.isNotEmpty()) {
            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )  // Responsible for page redirecting
            finish() // Destroys the current activity
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = UserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSave.setOnClickListener(this)

        verifyUserName()
    }


    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()

        }
    }


}