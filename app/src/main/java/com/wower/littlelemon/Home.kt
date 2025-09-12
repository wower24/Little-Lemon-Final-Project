package com.wower.littlelemon

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Home() {
    Text(
        modifier = Modifier.fillMaxSize(),
        text="HOME",
        textAlign = TextAlign.Center
    )
}