package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Questions : AppCompatActivity() {

    private val questions = arrayOf(
        "The Declaration of Independence was signed in 1776.",
        "The Great Wall of China is in Japan.",
        "Napoleon was exiled to Elba.",
        "World War I started in 1939.",
        "The Roman Empire preceded the Middle Ages."
    )

    private val answers = arrayOf(true, false, true, false, true)

    private var currentQuestionIndex = 0
    private var score = 0
    private var answered = false

    private lateinit var answerText: TextView
    private lateinit var questionText: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        // Initialize views correctly (don't use val here)
        answerText = findViewById(R.id.answerText)
        questionText = findViewById(R.id.questionText)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)

        loadQuestion()

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            if (currentQuestionIndex < questions.size - 1) {
                currentQuestionIndex++
                answered = false
                loadQuestion()
                answerText.text = "" // Clear previous answer
            } else {
                val intent = Intent(this, Score::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion() {
        questionText.text = questions[currentQuestionIndex]
    }

    @SuppressLint("SetTextI18n")
    private fun checkAnswer(userAnswer: Boolean) {
        if (!answered) {
            if (userAnswer == answers[currentQuestionIndex]) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                score++
                answerText.text = "Correct!"
            } else {
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
                answerText.text = "Incorrect!"
            }
            answered = true
        }
    }
}



