package com.yael.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yael.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val preguntasB = listOf(
        Pregunta(R.string.pregunta_australia, true),
        Pregunta(R.string.pregunta_oceanos, true),
        Pregunta(R.string.pregunta_mideast, false),
        Pregunta(R.string.pregunta_africa, false),
        Pregunta(R.string.pregunta_americas, true),
        Pregunta(R.string.pregunta_asia, true)
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnV.setOnClickListener {
            checkAnswer(true)
        }

        binding.btnF.setOnClickListener {
            checkAnswer(false)
        }

        binding.btnSig.setOnClickListener {
            currentIndex = (currentIndex + 1) % preguntasB.size
            updateQuestion()
        }

        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId = preguntasB[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = preguntasB[currentIndex].respuesta

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.msg_correcto
        } else {
            R.string.msg_incorrecto
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
}