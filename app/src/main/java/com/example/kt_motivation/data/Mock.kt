package com.example.kt_motivation.data

import com.example.kt_motivation.infra.MotivationConstants
import kotlin.random.Random

/**
 * Data class that represents a phrase
 */
data class Phrase(val description : String, val category : Int)

/**
 * Mock class that simulates a data source for the phrases
 */
class Mock {
    private val sunny = MotivationConstants.PHRASEFILTER.SUNNY
    private val happy = MotivationConstants.PHRASEFILTER.HAPPY
    private val all = MotivationConstants.PHRASEFILTER.ALL

    private val mListPhrase = listOf<Phrase>(
        Phrase("Imagine a new story for your life and believe in it.", happy),
        Phrase("The only way to do great work is to love what you do.", happy),
        Phrase("The best time to plant a tree was 20 years ago. The second best time is now.", happy),
        Phrase("Your limitation—it’s only your imagination.", happy),
        Phrase("Push yourself, because no one else is going to do it for you.", happy),
        Phrase("Great things never come from comfort zones.", happy),
        Phrase("Dream it. Wish it. Do it.", happy),
        Phrase("Success doesn’t just find you. You have to go out and get it.", happy),
        Phrase("The harder you work for something, the greater you’ll feel when you achieve it.", happy),
        Phrase("Dream bigger. Do bigger.", happy),
        Phrase("Don’t stop when you’re tired. Stop when you’re done.", happy),
        Phrase("Wake up with determination. Go to bed with satisfaction.", happy),
        Phrase("Do something today that your future self will thank you for.", happy),
        Phrase("Little things make big days.", happy),
        Phrase("It’s going to be hard, but hard does not mean impossible.", happy),
        Phrase("Don’t wait for opportunity. Create it.", happy),
        Phrase("Sometimes we’re tested not to show our weaknesses, but to discover our strengths.", happy),
        Phrase("The key to success is to focus on goals, not obstacles.", happy),
        Phrase("Dream it. Believe it. Build it.", happy),
        Phrase("You don’t have to be great to start, but you have to start to be great.", happy),
        Phrase("The secret of getting ahead is getting started.", happy),
        Phrase("You are never too old to set another goal or to dream a new dream.", happy),
        Phrase("Don’t be pushed around by the fears in your mind. Be led by the dreams in your heart.", happy),
        Phrase("It’s not about how bad you want it. It’s about how hard you’re willing to work for it.", happy),
        Phrase("The only limit is your mind.", happy),
        Phrase("The harder you work for something, the greater you’ll feel when you achieve it.", happy),
        Phrase("Don’t stop when you’re tired. Stop when you’re done.", happy),
        Phrase("Wake up with determination. Go to", happy)
    )

    /**
     * Returns a phrase from the data class, based on the category of the phrase
     */
    fun getPhrase(categoryId: Int): String {
        val filtered = mListPhrase.filter { it.category == categoryId || categoryId == all }
        val rand = Random.nextInt(filtered.size)
        return filtered[rand].description
    }
}