package com.example.myapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapp.ui.screens.BookHouseScreen
import com.example.myapp.ui.screens.ForgotPasswordScreen
import com.example.myapp.ui.screens.HomeScreen
import com.example.myapp.ui.screens.LandScreen
import com.example.myapp.ui.screens.PaymentScreen
import com.example.myapp.ui.screens.SignInScreen
import com.example.myapp.ui.screens.SignUpScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute != "signin" && currentRoute != "land") { // Don't show app bar on signin or land screen
                TopAppBar(
                    title = { Text(text = currentRoute?.split("/")?.get(0)?.replaceFirstChar { it.uppercase() } ?: "") },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "land",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("land") {
                LandScreen(navController = navController)
            }
            composable("signin") {
                SignInScreen(navController = navController)
            }
            composable("signup") {
                SignUpScreen(navController = navController)
            }
            composable("home") {
                HomeScreen(navController = navController)
            }
            composable("forgotpassword") {
                ForgotPasswordScreen(navController = navController)
            }
            composable(
                "bookhouse/{houseName}",
                arguments = listOf(navArgument("houseName") { type = NavType.StringType })
            ) {
                BookHouseScreen(navController = navController, it.arguments?.getString("houseName"))
            }
            composable("payment") {
                PaymentScreen(navController = navController)
            }
        }
    }
}
