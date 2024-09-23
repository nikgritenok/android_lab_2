package com.example.logging

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Инициализация Timber
        Timber.plant(Timber.DebugTree())

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Найдем EditText и Button по их ID
        val editText = findViewById<EditText>(R.id.editText)
        val logButton = findViewById<Button>(R.id.button_log)
        val timberButton = findViewById<Button>(R.id.button_timber) // Добавляем кнопку timber

        // Установим обработчик нажатия для кнопки logButton
        logButton.setOnClickListener {
            // Получаем текст из EditText
            val text = editText.text.toString()

            // Отправляем verbose сообщение в лог
            Log.v("From EditText", text)

        }

        // Установим обработчик нажатия для кнопки timberButton
        timberButton.setOnClickListener {
            // Получаем текст из EditText
            val text = editText.text.toString()

            // Отправляем verbose сообщение без тега
            Timber.v(text)
        }
    }
}