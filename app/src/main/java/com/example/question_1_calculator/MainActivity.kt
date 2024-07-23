package com.example.question_1_calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val resultText = findViewById<TextView>(R.id.resultText)

        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)

        addButton.setOnClickListener { calculate(number1, number2, resultText, "+") }
        subtractButton.setOnClickListener { calculate(number1, number2, resultText, "-") }
        multiplyButton.setOnClickListener { calculate(number1, number2, resultText, "*") }
        divideButton.setOnClickListener { calculate(number1, number2, resultText, "/") }
    }

    private fun calculate(number1: EditText, number2: EditText, resultText: TextView, operation: String) {
        val num1 = number1.text.toString().toDoubleOrNull()
        val num2 = number2.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            resultText.text = "Invalid input"
            return
        }

        val result = when (operation) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> {
                if (num2 != 0.0) {
                    num1 / num2
                } else {
                    resultText.text = "Cannot divide by zero"
                    return
                }
            }
            else -> {
                resultText.text = "Invalid operation"
                return
            }
        }

        resultText.text = "Result: $result"
    }
}
