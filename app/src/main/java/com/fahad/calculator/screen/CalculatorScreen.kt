package com.fahad.calculator.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fahad.calculator.model.CalculatorViewModel
import com.fahad.calculator.utils.EventUi
import com.fahad.calculator.utils.Operator
import java.text.DecimalFormat

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){

    val uiState = viewModel.State

    Column(modifier = Modifier.fillMaxSize().padding(4.dp),) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(2f)){
            Column(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)) {
                Text(
                    text = uiState.value.calculationExpression,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    style = TextStyle(
                        fontSize = 30.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.End
                    )
                )
                Text(
                    text = if(uiState.value.answer.isNotEmpty())
                        DecimalFormat("###.#").format(uiState.value.answer.toDouble())
                    else if(uiState.value.currentOperator == Operator.NONE)
                        DecimalFormat("###.#").format(uiState.value.firstNumber.toDouble())
                    else DecimalFormat("###.#").format(uiState.value.secondNumber.toDouble())
                    ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    style = TextStyle(
                        fontSize = 60.sp,
                        textAlign = TextAlign.End
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(3f)
            .padding(8.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "CA",
                    isHighLight = true,
                    onActionCalculatorClick = {
                        viewModel.onEvent(EventUi.OnClearAll)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "/",
                    isHighLight = true,
                    onActionCalculatorClick = {
                        viewModel.onEvent(EventUi.OnDivideClicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "X",
                    isHighLight = true,
                    onActionCalculatorClick = {
                        viewModel.onEvent(EventUi.OnTimesClicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.ArrowBack,
                    isHighLight = true,
                    onActionCalculatorClick = {
                        viewModel.onEvent(EventUi.OnClear)
                    }
                )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "7",
                    onActionCalculatorClick = {
                        viewModel.onEvent(EventUi.On7Clicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "8",
                    onActionCalculatorClick = {
                        viewModel.onEvent(EventUi.On8Clicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "9",
                    onActionCalculatorClick = {
                        viewModel.onEvent(EventUi.On9Clicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "-",
                    isHighLight = true,
                    onActionCalculatorClick = {
                        viewModel.onEvent(EventUi.OnMinusClicked)
                    }
                )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "4",
                    onActionCalculatorClick = {
                        viewModel.onEvent(EventUi.On4Clicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "5",
                    onActionCalculatorClick = {
                        viewModel.onEvent(EventUi.On5Clicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "6",
                    onActionCalculatorClick = {
                        viewModel.onEvent(EventUi.On6Clicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "+",
                    isHighLight = true,
                    onActionCalculatorClick = {
                        viewModel.onEvent(EventUi.OnPlusClicked)
                    }
                )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(2f)) {
                Column(modifier = Modifier.weight(3f)) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ActionCalculator(
                            modifier = Modifier.weight(1f),
                            character = "1",
                            onActionCalculatorClick = {
                                viewModel.onEvent(EventUi.On1Clicked)
                            }
                        )
                        ActionCalculator(
                            modifier = Modifier.weight(1f),
                            character = "2",
                            onActionCalculatorClick = {
                                viewModel.onEvent(EventUi.On2Clicked)
                            }
                        )
                        ActionCalculator(
                            modifier = Modifier.weight(1f),
                            character = "3",
                            onActionCalculatorClick = {
                                viewModel.onEvent(EventUi.On3Clicked)
                            }
                        )
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ActionCalculator(
                            modifier = Modifier.weight(3f),
                            character = "0",
                            onActionCalculatorClick = {
                                viewModel.onEvent(EventUi.On0Clicked)
                            }
                        )
                    }
                }
                Box(modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)){
                    Box(modifier = Modifier
                        .fillMaxHeight(0.7f)
                        .width(55.dp)
                        .clip(RoundedCornerShape(60))
                        .background(MaterialTheme.colorScheme.primary)
                        .align(Alignment.Center)
                        .clickable {
                            viewModel.onEvent(EventUi.OnEvalClicked)
                        }
                    ){
                        Text(
                            text = "=",
                            style = TextStyle(fontSize = 30.sp, color = MaterialTheme.colorScheme.onPrimary),
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ActionCalculator(
    modifier: Modifier = Modifier,
    character : String? = null,
    icon : ImageVector? = null,
    isHighLight : Boolean = false,
    onActionCalculatorClick : () -> Unit
){
    Box(modifier = modifier
        .size(60.dp)
        .clip(RoundedCornerShape(50))
        .clickable { onActionCalculatorClick() }
    ){
        if(icon != null){
            Icon(imageVector = icon, contentDescription = "",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.align(Alignment.Center)
            )
        }else{
            Text(text = character!!,
                style = TextStyle(
                    fontSize = 30.sp,
                    color = if(isHighLight) MaterialTheme.colorScheme.onSurface
                    else MaterialTheme.colorScheme.onSurfaceVariant
                ),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}