package com.fahad.calculator.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.fahad.calculator.utils.EventUi


import com.fahad.calculator.utils.Operator
import com.fahad.calculator.utils.State

import java.text.DecimalFormat

class CalculatorViewModel : ViewModel() {
    val State : MutableState<State> = mutableStateOf(State())

    fun onEvent(Event: EventUi){

            when (Event){
                is EventUi.On0Clicked, EventUi.On1Clicked, EventUi.On2Clicked, EventUi.On3Clicked,
                    EventUi.On4Clicked, EventUi.On5Clicked, EventUi.On6Clicked, EventUi.On7Clicked,
                    EventUi.On8Clicked, EventUi.On9Clicked ->{
                        updateNumber(Event.character!!)
                    }
                is EventUi.OnClearAll ->{
                    State.value = State()
                }
                is EventUi.OnClear ->{
                    clear()
                }
                is EventUi.OnPlusClicked, EventUi.OnMinusClicked, EventUi.OnTimesClicked,
                    EventUi.OnDivideClicked ->{
                        operate(Event.operator)
                    }
                is EventUi.OnEvalClicked ->{
                    egalize()
                }
            }




    }

    private fun updateNumber(numberCharacter : String){
        if(State.value.answer.isNotEmpty()){
            State.value = State.value.copy(
                firstNumber = "0", currentOperator = Operator.NONE,
                calculationExpression = ""
            )
        }
        if(State.value.currentOperator == Operator.NONE){
            State.value = State.value.copy(
                firstNumber = State.value.firstNumber + numberCharacter,
                answer = ""
            )
        }else{
            State.value = State.value.copy(
                calculationExpression = "${myDecimalFormatter(State.value.firstNumber.toDouble())} " +
                        "${State.value.currentOperator.symbol}",
                secondNumber = State.value.secondNumber + numberCharacter
            )
        }
    }

    private fun clear(){
        if(State.value.answer.isNotEmpty()){
            return
        }
        if(State.value.currentOperator == Operator.NONE){
            State.value = State.value.copy(
                firstNumber = State.value.firstNumber.dropLast(1)
            )
        }else{
            State.value = State.value.copy(
                secondNumber = State.value.secondNumber.dropLast(1)
            )
        }
    }

    private fun operate(operator: Operator){
        State.value = State.value.copy(
            answer = "",
            currentOperator = operator,
            calculationExpression = "${myDecimalFormatter(State.value.firstNumber.toDouble())} " +
                    "${operator.symbol}"
        )
    }

    private fun egalize(){
        when (State.value.currentOperator){
            Operator.ADDITION ->{
                State.value = State.value.copy(
                    answer = (State.value.firstNumber.toDouble() + State.value.secondNumber.toDouble()).toString(),
                    firstNumber = (State.value.firstNumber.toDouble() + State.value.secondNumber.toDouble()).toString(),
                    currentOperator = Operator.NONE,
                    calculationExpression = "${myDecimalFormatter(State.value.firstNumber.toDouble())} " +
                            "${State.value.currentOperator.symbol} " +
                            "${myDecimalFormatter(State.value.secondNumber.toDouble())} =",
                    secondNumber = "0"
                )
            }
            Operator.SUBSTRACTION->{
                State.value = State.value.copy(
                    answer = (State.value.firstNumber.toDouble() - State.value.secondNumber.toDouble()).toString(),
                    firstNumber = (State.value.firstNumber.toDouble() - State.value.secondNumber.toDouble()).toString(),
                    currentOperator = Operator.NONE,
                    calculationExpression = "${myDecimalFormatter(State.value.firstNumber.toDouble())} " +
                            "${State.value.currentOperator.symbol} " +
                            "${myDecimalFormatter(State.value.secondNumber.toDouble())} =",
                    secondNumber = "0"
                )
            }
            Operator.MULTIPLICATION->{
                State.value = State.value.copy(
                    answer = (State.value.firstNumber.toDouble() * State.value.secondNumber.toDouble()).toString(),
                    firstNumber = (State.value.firstNumber.toDouble() * State.value.secondNumber.toDouble()).toString(),
                    currentOperator = Operator.NONE,
                    calculationExpression = "${myDecimalFormatter(State.value.firstNumber.toDouble())} " +
                            "${State.value.currentOperator.symbol} " +
                            "${myDecimalFormatter(State.value.secondNumber.toDouble())} =",
                    secondNumber = "0"
                )
            }
            Operator.DIVISION->{
                State.value = State.value.copy(
                    answer = (State.value.firstNumber.toDouble() / State.value.secondNumber.toDouble()).toString(),
                    firstNumber = (State.value.firstNumber.toDouble() / State.value.secondNumber.toDouble()).toString(),
                    currentOperator = Operator.NONE,
                    calculationExpression = "${myDecimalFormatter(State.value.firstNumber.toDouble())} " +
                            "${State.value.currentOperator.symbol} " +
                            "${myDecimalFormatter(State.value.secondNumber.toDouble())} =",
                    secondNumber = "0"
                )
            }
            Operator.NONE->{}
        }
    }

    private fun myDecimalFormatter(input : Double) : String = DecimalFormat("###.#").format(input)

}