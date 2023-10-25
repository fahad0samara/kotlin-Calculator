package com.fahad.calculator.utils

data class State(
    val calculationExpression : String = "",
    val firstNumber : String = "0",
    val secondNumber : String = "0",
    val currentOperator : Operator = Operator.NONE,
    val answer : String = ""
)
