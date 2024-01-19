package com.example.stefanseeholzercalcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Variables
        val buttonGroup: LinearLayout = findViewById(R.id.buttonGroup)
        val equalsButton: Button = findViewById(R.id.buttonEquals)
        val plusButton: Button = findViewById(R.id.buttonPlus)
        val minusButton: Button = findViewById(R.id.buttonMinus)
        val multiplyButton: Button = findViewById(R.id.buttonMultiply)
        val divideButton: Button = findViewById(R.id.buttonDivide)
        val clearButton: Button = findViewById(R.id.buttonClear)
        val number: TextView = findViewById(R.id.textView)
        var number1 = 0.0
        var number2 = 0.0
        var operator = ""
        var i = 0
        var number2Set = false
        var reset = true
        var equalsPressed = false


        // All event listeners for number buttons
        while(i < buttonGroup.childCount){
            val button: View = buttonGroup.getChildAt(i)
            val currentNumber = i
            button.setOnClickListener{
                number2Set = false
                if(reset){
                    number.text = currentNumber.toString()
                    reset = false
                }else{
                    val numberText = number.text
                    val numberAdded = "$numberText$currentNumber"
                    number.text = numberAdded
                }
            }
            i += 1
        }

        // Event listener for plus button
        plusButton.setOnClickListener{
            number2Set = false
            if(equalsPressed) {
                equalsPressed = false
            }else if (operator != ""){
                number1 = operatorButtonClicked(number1, number, operator)
            }else{
                number1 = number.text.toString().toDouble()
            }
            operator = "+"
            reset = true
        }
        // Event listener for minus button
        minusButton.setOnClickListener{
            number2Set = false
            if(equalsPressed) {
                equalsPressed = false
            }else if (operator != ""){
                number1 = operatorButtonClicked(number1, number, operator)
            }else{
                number1 = number.text.toString().toDouble()
            }
            operator = "-"
            reset = true
        }
        // Event listener for multiplication button
        multiplyButton.setOnClickListener{
            number2Set = false
            if(equalsPressed) {
                equalsPressed = false
            }else if (operator != ""){
                number1 = operatorButtonClicked(number1, number, operator)
            }else{
                number1 = number.text.toString().toDouble()
            }
            operator = "*"
            reset = true
        }
        // Event listener for division button
        divideButton.setOnClickListener{
            number2Set = false
            if(equalsPressed) {
                equalsPressed = false
            }else if (operator != ""){
                number1 = operatorButtonClicked(number1, number, operator)
            }else{
                number1 = number.text.toString().toDouble()
            }
            operator = "/"
            reset = true
        }

        // Event listener for clear button
        clearButton.setOnClickListener{
            equalsPressed = false
            number2Set = false
            reset = true
            number.text = "0.0"
            number1 = 0.0
            number2 = 0.0
            operator = ""
        }

        // Event listener for equals button
        equalsButton.setOnClickListener{
            equalsPressed = true
            reset = true
            if(!number2Set) {
                number2 = number.text.toString().toDouble()
                number2Set = true
            }

            number1 = doTheMath(number1, number2, operator)
            number.text = number1.toString()
        }
    }

    // Function for when operator is clicked
    private fun operatorButtonClicked(number1: Double, number: TextView, operator: String): Double{
        val num = number.text.toString()
        val number2 = num.toDouble()
        val answer = doTheMath(number1, number2, operator)
        number.text = answer.toString()
        return answer
    }

    // Function to do the math ot the equation
    private fun doTheMath(number1: Double, number2: Double, operator: String): Double {
        var answer = 0.0
        when(operator){
            "+" -> answer = number1 + number2
            "-" -> answer = number1 - number2
            "*" -> answer = number1 * number2
            "/" -> answer = number1 / number2
        }
        return answer
    }
}