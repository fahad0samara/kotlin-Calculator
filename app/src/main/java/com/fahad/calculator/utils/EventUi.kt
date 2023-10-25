package com.fahad.calculator.utils
sealed class EventUi(
    val character : String? = null,
    val operator: Operator = Operator.NONE
){
    data object On0Clicked : EventUi(character = "0")
    data object On1Clicked : EventUi(character = "1")
    data object On2Clicked : EventUi(character = "2")
    data object On3Clicked : EventUi(character = "3")
    data object On4Clicked : EventUi(character = "4")
    data object On5Clicked : EventUi(character = "5")
    data object On6Clicked : EventUi(character = "6")
    data object On7Clicked : EventUi(character = "7")
    data object On8Clicked : EventUi(character = "8")
    data object On9Clicked : EventUi(character = "9")
    data object OnPlusClicked : EventUi(operator = Operator.ADDITION)
    data object OnMinusClicked : EventUi(operator = Operator.SUBSTRACTION)
    data object OnDivideClicked : EventUi(operator = Operator.DIVISION)
    data object OnTimesClicked : EventUi(operator = Operator.MULTIPLICATION)

    data object OnClear : EventUi()
    data object OnClearAll : EventUi()
    data object OnEvalClicked : EventUi()
}