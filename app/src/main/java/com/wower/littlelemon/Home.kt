package com.wower.littlelemon

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.wower.littlelemon.ui.theme.Gray
import com.wower.littlelemon.ui.theme.Green
import com.wower.littlelemon.ui.theme.LightGreen
import com.wower.littlelemon.ui.theme.Yellow

@Composable
fun Home(
    navController: NavHostController,
    menuItems: List<MenuItemRoom> = listOf()
    ) {
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
                modifier = Modifier
                    .padding(32.dp)
                    .size(height = 80.dp, width = 300.dp),
                contentScale = ContentScale.FillWidth
            )
            RestaurantInformation()
        }

        MenuCategories(menuItems)
        MenuItems(menuItems)

        Button(
            modifier = Modifier
                .padding(32.dp)
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

@Composable
fun MenuCategories(menuItems: List<MenuItemRoom> = listOf()) {
    val categories = listOf("Starters", "Mains", "Desserts")
    var menuItemsFiltered = listOf<MenuItemRoom>()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        categories.map { category ->
            Button(
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGreen
                ),
                onClick = {
                    menuItemsFiltered = menuItems.filter {
                        it.category.equals(category, ignoreCase = true)
                    }
                }
            ) {
                Text(
                    text = category,
                    color = Green
                    )
            }
        }
    }
    }

@Composable
fun RestaurantInformation() {
Column(
    modifier = Modifier
        .fillMaxWidth()
        .background(Green)
        .padding(16.dp)
) {
    Text(
        text = "Little Lemon",
        fontSize = 54.sp,
        color = Yellow,
        fontWeight = FontWeight.Bold
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(0.6f),
            horizontalAlignment = Alignment.Start

        ) {
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = "Chicago",
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.fillMaxWidth(0.9f),
                text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                color = Color.White
            )
        }

        Image(
            modifier = Modifier.size(height = 150.dp, width = 150.dp),
            painter = painterResource(R.drawable.hero),
            contentDescription = "Food Image",
            contentScale = ContentScale.FillWidth
        )
    }
}
}

//TODO: Design and add Image after Column

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItems(menuItems: List<MenuItemRoom>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.75f)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        menuItems.map { it ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.75f),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = it.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(0.9f)
                        .padding(vertical = 4.dp),
                        text = it.description,
                        maxLines = 2
                    )
                    Text(
                        text = "$${it.price}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Gray
                    )
                }

                GlideImage(
                    modifier = Modifier.size(height = 100.dp, width = 100.dp),
                    model = it.image,
                    contentDescription = "Food Image",
                    contentScale = ContentScale.FillHeight
                )


            }
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    val navController = NavHostController(LocalContext.current)
    Home(navController)
}