package com.example.kt_motivation.ui.activities

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import com.example.kt_motivation.R
import com.example.kt_motivation.data.Mock
import com.example.kt_motivation.infra.SecurityPreferences
import com.example.kt_motivation.databinding.MainBinding
import com.example.kt_motivation.infra.MotivationConstants

/**
 * Main screen of the app
 */
class MainActivity : ComponentActivity(), View.OnClickListener {
    private lateinit var binding: MainBinding
    private var categoryId = 1


    /**
     * Sets the "hello" message with the user's name
     */
    private fun handleUserName() {
        val name = SecurityPreferences(this).getStoredString("USER_NAME")
        if (name != "") {
            binding.helloUser.text = "Hello, $name!"
        }
    }

    /**
     * Handles the next phrase to be shown
     */
    private fun handleNextPhrase() {
        binding.textPhrase.text = Mock().getPhrase(categoryId)
    }

    /**
     * Handles the filter of the phrases in the main screen
     */
    private fun handleFilter(id: Int) {
        // Changes the color of the icons, to show the user which filter is active. Gets the color from the resources using the ContextCompat
        binding.icAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.icHappyFace.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.icSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        when (id) {
            R.id.ic_all_inclusive -> {
                binding.icAllInclusive.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                categoryId = MotivationConstants.PHRASEFILTER.ALL
            }

            R.id.ic_happy_face -> {
                binding.icHappyFace.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                categoryId = MotivationConstants.PHRASEFILTER.HAPPY
            }

            R.id.ic_sunny -> {
                binding.icSunny.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                categoryId = MotivationConstants.PHRASEFILTER.SUNNY
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleUserName()
        handleFilter(R.id.ic_all_inclusive)
        handleNextPhrase()

        binding.buttonNewPhrase.setOnClickListener(this)

        // Binding for Icons in top bar
        binding.icAllInclusive.setOnClickListener(this)
        binding.icHappyFace.setOnClickListener(this)
        binding.icSunny.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase) {
            handleNextPhrase()
        } else if (view.id in listOf(R.id.ic_all_inclusive, R.id.ic_happy_face, R.id.ic_sunny)) {
            handleFilter(view.id)
        }
    }

}