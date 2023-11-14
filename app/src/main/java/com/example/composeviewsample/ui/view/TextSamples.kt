package com.example.composeviewsample.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TextSamples(navController: NavController? = null) {
    Column {
        Button(onClick = {
            navController?.popBackStack()
        }) {
            Text(text = "back to top")
        }
        Text(
            text = "second",
            fontSize = 10.sp
        )
    }

}