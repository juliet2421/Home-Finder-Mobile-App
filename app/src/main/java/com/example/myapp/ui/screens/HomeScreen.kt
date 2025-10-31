package com.example.myapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.R
import com.example.myapp.ui.theme.MyAppTheme

data class House(@DrawableRes val image: Int, val name: String)

@Composable
fun HomeScreen(navController: NavController) {
    var district by remember { mutableStateOf("") }
    var budget by remember { mutableStateOf("") }
    var houseType by remember { mutableStateOf("") }

    val houses = remember {
        listOf(
            House(R.drawable.ic_launcher_foreground, "Modern House"),
            House(R.drawable.ic_launcher_foreground, "Country House"),
            House(R.drawable.ic_launcher_foreground, "Beach House"),
            House(R.drawable.ic_launcher_foreground, "Mansion")
        )
    }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = district,
            onValueChange = { district = it },
            placeholder = { Text("Enter district") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = budget,
            onValueChange = { budget = it },
            placeholder = { Text("Enter budget") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = houseType,
            onValueChange = { houseType = it },
            placeholder = { Text("Enter house type") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* TODO: Implement search logic */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF87CEEB))
        ) {
            Text("Find Home")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(houses) { house ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { navController.navigate("bookhouse/${house.name}") }
                ) {
                    Image(painter = painterResource(id = house.image), contentDescription = house.name)
                    Text(text = house.name)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    MyAppTheme {
        HomeScreen(rememberNavController())
    }
}
