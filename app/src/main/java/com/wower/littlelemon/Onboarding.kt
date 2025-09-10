package com.wower.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Onboarding(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    Image(
        painter=painterResource(R.drawable.logo),
        contentDescription="Little Lemon Logo",
        modifier = Modifier.size(200.dp)
    )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Let's get to know you!"
            )

            var firstName by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier.padding(16.dp),
                value = firstName,
                onValueChange = { newText: String -> firstName = newText },
                placeholder = { Text(text = "Your first name") }
            )

            var lastName by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier.padding(16.dp),
                value = lastName,
                onValueChange = { newText: String -> lastName = newText },
                placeholder = { Text(text = "Your last name") }
            )

            var emailAddress by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier.padding(16.dp),
                value = emailAddress,
                onValueChange = { newText: String -> emailAddress = newText },
                placeholder = { Text(text = "Your email address") }
            )
        }

        Button(
            modifier = Modifier.padding(32.dp)
                .fillMaxWidth(0.8f),
            onClick = {}
        ) {
            Text(text = "Register")
        }
    }
}

@Preview
@Composable
fun OnboardingPreview() {
    Onboarding()
}