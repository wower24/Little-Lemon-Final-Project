package com.wower.littlelemon

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import androidx.navigation.NavHostController
import com.wower.littlelemon.ui.theme.Green
import com.wower.littlelemon.ui.theme.Yellow

@Composable
fun Profile(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("LittleLemon", Context.MODE_PRIVATE)
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

        Column(
            modifier = Modifier. fillMaxWidth(0.9f)
                .background(Color(0x5571807B))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Profile Information",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 64.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 64.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "First Name:",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = sharedPreferences.getString("firstName", "---").toString(),
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom = 32.dp),
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 64.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Last Name:",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = sharedPreferences.getString("lastName", "---").toString(),
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom = 32.dp),
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 64.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Email Address:",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
                Text(
                    text = sharedPreferences.getString("emailAddress", "---").toString(),
                    fontSize = 24.sp,
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
                context.getSharedPreferences("LittleLemon", Context.MODE_PRIVATE).edit() {
                    putBoolean(
                        "isLoggedIn",
                        false
                    )
                    putString(
                        "firstName",
                        ""
                    )
                    putString(
                        "lastName",
                        ""
                    )
                    putString(
                        "emailAddress",
                        ""
                    )
                }

                navController.navigate(Onboarding.route)
            }
        ) {
            Text(
                text = "Log Out",
                color = Color.Black,
                fontSize = 24.sp
            )
        }
    }
}

@Preview
@Composable
fun ProfilePreview() {
    val navController = NavHostController(LocalContext.current)
    Profile(navController)
}