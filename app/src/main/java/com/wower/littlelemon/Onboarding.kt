package com.wower.littlelemon

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wower.littlelemon.ui.theme.Green
import com.wower.littlelemon.ui.theme.Yellow
import androidx.core.content.edit
import androidx.navigation.NavHostController

@Composable
fun Onboarding(navController: NavHostController,
               modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var emailAddress by remember { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Little Lemon Logo",
                modifier = Modifier.padding(32.dp)
                    .size(height = 80.dp, width = 300.dp),
                contentScale = ContentScale.FillWidth
            )

            Box(
                modifier = Modifier.fillMaxWidth()
                    .background(Green),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.padding(50.dp),
                    text = "Let's get to know you!",
                    fontSize = 30.sp,
                    color = Color.White
                )
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text="Personal Information",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            TextField(
                modifier = Modifier.padding(16.dp)
                    .border(width = 1.dp, color = Green, shape = RoundedCornerShape(10.dp))
                    .fillMaxWidth(0.9f),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor =  Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                value = firstName,
                onValueChange = { newText: String -> firstName = newText },
                placeholder = { Text(text = "Your first name") }
            )

            TextField(
                modifier = Modifier.padding(16.dp)
                    .border(width = 1.dp, color = Green, shape = RoundedCornerShape(10.dp))
                    .fillMaxWidth(0.9f),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor =  Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                value = lastName,
                onValueChange = { newText: String -> lastName = newText },
                placeholder = { Text(text = "Your last name") }
            )

            TextField(
                modifier = Modifier.padding(16.dp)
                    .border(width = 1.dp, color = Green, shape = RoundedCornerShape(10.dp))
                    .fillMaxWidth(0.9f),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor =  Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                value = emailAddress,
                onValueChange = { newText: String -> emailAddress = newText },
                placeholder = { Text(text = "Your email address") }
            )
        }

        Button(
            modifier = Modifier.padding(32.dp)
                .fillMaxWidth(0.8f)
                .height(80.dp)
                .padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Yellow
            ),
            shape = RoundedCornerShape(10.dp),
            onClick = {
                if(!firstName.isBlank() && !lastName.isBlank() && !emailAddress.isBlank()) {
                    context.getSharedPreferences("LittleLemon", Context.MODE_PRIVATE).edit() {
                        putBoolean(
                            "isLoggedIn",
                            true
                        )
                        putString(
                            "firstName",
                            firstName
                        )
                        putString(
                            "lastName",
                            lastName
                        )
                        putString(
                            "emailAddress",
                            emailAddress
                        )
                    }
                    Toast.makeText(
                        context, "Registration successful!",
                        Toast.LENGTH_SHORT
                    ).show()
                    navController.navigate(Home.route)
                } else {
                    Toast.makeText(
                        context, "Registration unsuccessful. Please enter all data.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        ) {
            Text(
                text = "Register",
                color = Color.Black,
                fontSize = 24.sp
            )
        }
    }
}

@Preview
@Composable
fun OnboardingPreview() {
    val navController = NavHostController(LocalContext.current)
    Onboarding(navController)
}