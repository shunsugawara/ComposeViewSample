package com.example.composeviewsample.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composeviewsample.NavigationKey
import com.example.composeviewsample.ui.theme.ComposeViewSampleTheme

@Composable
fun ListTop(navController: NavController? = null) {
    LazyColumn {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Blue.copy(alpha = 0.1f))
                    .padding(horizontal = 20.dp)
                    .clickable { navController?.navigate(NavigationKey.TEXT.name) },
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "Text Sample",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListTopPreview() {
    ComposeViewSampleTheme {
        ListTop()
    }
}