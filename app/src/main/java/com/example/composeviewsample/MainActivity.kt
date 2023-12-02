package com.example.composeviewsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
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
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val backStacks by navController.currentBackStack.collectAsState()
            val currentRoute = backStacks.lastOrNull()?.destination?.route

            ComposeViewSampleTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBarView(currentRoute, navController) }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = NavigationKey.LIST_TOP.name,
                        modifier = Modifier.padding(it)
                    ) {
                        composable(route = NavigationKey.LIST_TOP.name) {
                            ListTop(navController)
                        }
                        composable(route = NavigationKey.TEXT.name) {
                            TextSamples()
                        }
                    }
                }
            }
        }
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    private fun TopBarView(
        currentRoute: String?,
        navController: NavHostController
    ) {
        TopAppBar(
            title = {
                Text(text = currentRoute ?: "")
            },
            navigationIcon = {
                val iconSizeModifier = Modifier.size(30.dp)
                if (currentRoute != NavigationKey.LIST_TOP.name) {
                    BackButton(
                        modifier = iconSizeModifier,
                        onClick = { navController.navigateUp() })
                } else {
                    Spacer(
                        modifier = iconSizeModifier
                    )
                }
            },
        )
    }

    @Composable
    private fun BackButton(modifier: Modifier, onClick: () -> Unit) {
        IconButton(
            onClick = { onClick() },
            modifier = modifier
        ) {
            Icon(
                painter = painterResource(id = android.R.drawable.arrow_up_float),
                contentDescription = null,
                modifier = Modifier.rotate(270f)
            )
        }
    }
}