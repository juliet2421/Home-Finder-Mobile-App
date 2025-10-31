package com.example.myapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.ui.theme.MyAppTheme

@Composable
fun BookHouseScreen(navController: NavController, houseName: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Book: $houseName")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("payment") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF87CEEB))
        ) {
            Text("Proceed to Payment")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BookHouseScreenPreview() {
    MyAppTheme {
        BookHouseScreen(rememberNavController(), "Sample House")
    }
}
