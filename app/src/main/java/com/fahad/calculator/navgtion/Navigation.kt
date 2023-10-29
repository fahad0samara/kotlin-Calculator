package com.fahad.calculator.navgtion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fahad.calculator.screen.CalculatorScreen
import com.fahad.calculator.screen.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Splash") {
        composable("Splash") {
            SplashScreen(
                navController = navController
            )
        }

        composable("Home") {
            CalculatorScreen()
        }
    }

}
