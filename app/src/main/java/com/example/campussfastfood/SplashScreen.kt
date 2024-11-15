package com.example.campussfastfood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.campussfastfood.ui.theme.CampussFastFoodTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CampussFastFoodTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF5CB58)
                ) {
                    SplashScreen()
                }
            }
        }
    }
}

@Composable
fun SplashScreen() {
    var navigateToMainScreen by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(3500)
        navigateToMainScreen = true
    }

    if (navigateToMainScreen) {
        MainScreen()
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Image(
                painter = painterResource(id = R.drawable.logo_1),
                contentDescription = "Logo",
                modifier = Modifier.size(350.dp)
            )
        }
    }
}

@Composable
fun MainScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE95322))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            Spacer(modifier = Modifier.height(100.dp))
            Image(
                painter = painterResource(id = R.drawable.logo_2),
                contentDescription = "Logo",
                modifier = Modifier.size(350.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod.",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 32.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Tombol Log In
            CustomButton(text = "Log In")

            Spacer(modifier = Modifier.height(8.dp))

            // Tombol Sign Up
            CustomButton(text = "Sign Up")
        }
    }
}

@Composable
fun CustomButton(text: String) {
    var isPressed by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .padding(vertical = 2.dp)
            .clickable(onClick = { isPressed = !isPressed }) // Toggle warna saat ditekan
            .background(
                color = if (isPressed) Color(0xFFF5CB58) else Color(0xFFF3E9B5),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(vertical = 12.dp)
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
