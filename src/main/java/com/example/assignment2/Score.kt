package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Score : AppCompatActivity() {

    private lateinit var scoreText: TextView
    private lateinit var feedbackText: TextView
    private lateinit var retryButton: Button
    private lateinit var exitButton: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        scoreText = findViewById(R.id.scoreText)
        feedbackText = findViewById(R.id.feedbackText)
        retryButton = findViewById(R.id.retryButton) // Reusing the same button ID
        exitButton = findViewById(R.id.exitButton)

        val score = intent.getIntExtra("score", 0)
        scoreText.text = "Your Score: $score"

        feedbackText.text = if (score >= 3) {
            "Great job!"
        } else {
            "Keep practicing!"
        }

        retryButton.text = "Retry Quiz" // Optional: Change text at runtime

        retryButton.setOnClickListener {
            val intent = Intent(this, Questions::class.java)
            startActivity(intent)
            finish() // Optional: close Score screen so it doesn't stay in the back stack
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}
