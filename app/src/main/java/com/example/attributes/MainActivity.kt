package com.example.attributes

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var buttonBlackText: Button
    private lateinit var buttonRedText: Button
    private lateinit var buttonSize8sp: Button
    private lateinit var buttonSize24sp: Button
    private lateinit var buttonWhiteBackground: Button
    private lateinit var buttonYellowBackground: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Инициализация элементов
        editText = findViewById(R.id.editText)
        buttonBlackText = findViewById(R.id.buttonBlackText)
        buttonRedText = findViewById(R.id.buttonRedText)
        buttonSize8sp = findViewById(R.id.buttonSize8sp)
        buttonSize24sp = findViewById(R.id.buttonSize24sp)
        buttonWhiteBackground = findViewById(R.id.buttonWhiteBackground)
        buttonYellowBackground = findViewById(R.id.buttonYellowBackground)

        // Обработчики кнопок
        buttonBlackText.setOnClickListener {
            editText.setTextColor(Color.BLACK)
        }

        buttonRedText.setOnClickListener {
            editText.setTextColor(Color.RED)
        }

        buttonSize8sp.setOnClickListener {
            editText.textSize = 8f // Устанавливаем размер шрифта в 8sp
        }

        buttonSize24sp.setOnClickListener {
            editText.textSize = 24f // Устанавливаем размер шрифта в 24sp
        }

        buttonWhiteBackground.setOnClickListener {
            editText.setBackgroundColor(Color.WHITE) // Устанавливаем белый фон
        }

        buttonYellowBackground.setOnClickListener {
            editText.setBackgroundColor(Color.YELLOW) // Устанавливаем желтый фон
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}