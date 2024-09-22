package com.example.kt_motivation.infra

/**
 * Info that was entered before in the app, is gonna be stored here.
 *
 * Can't instantiate this class.
 */
class MotivationConstants private constructor() {

    object KEY {
        val USER_NAME = "name"
    }

    object PHRASEFILTER {
        val ALL = 1
        val HAPPY = 2
        val SUNNY = 3
    }

}