package com.yael.quizapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnVerdadero: Button = findViewById(R.id.btn_v)
        val btnFalso: Button = findViewById(R.id.btn_f)

        btnVerdadero.setOnClickListener {
            Toast.makeText(this, "¡Respuesta correcta!", Toast.LENGTH_SHORT).show()
        }

        btnFalso.setOnClickListener {
            Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show()
        }
    }
}