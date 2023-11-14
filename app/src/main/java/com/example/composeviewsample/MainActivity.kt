package com.example.composeviewsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeviewsample.ui.theme.ComposeViewSampleTheme
import com.example.composeviewsample.ui.view.ListTop
import com.example.composeviewsample.ui.view.TextSamples

enum class NavigationKey {
    LIST_TOP, TEXT
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeViewSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavigationKey.LIST_TOP.name
                    ) {
                        composable(route = NavigationKey.LIST_TOP.name) {
                            ListTop(modifier = Modifier, navController)
                        }
                        composable(route = NavigationKey.TEXT.name) {
                            TextSamples(navController = navController)
                        }
                    }
                }
            }
        }
    }
}