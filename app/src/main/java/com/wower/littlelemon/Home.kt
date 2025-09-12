package com.wower.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.wower.littlelemon.ui.theme.Yellow

@Composable
fun Home(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
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
            navController.navigate(Profile.route)
        }) {
            Text(
                text = "Profile",
                color = Color.Black,
                fontSize = 24.sp
            )
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    val navController = NavHostController(LocalContext.current)
    Home(navController)
}