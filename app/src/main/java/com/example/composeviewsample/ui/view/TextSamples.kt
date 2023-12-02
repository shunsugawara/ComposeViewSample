package com.example.composeviewsample.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextSamples() {
    var fontSize by remember { mutableFloatStateOf(10f) }

    Column {
        Text(
            text = "${fontSize.toInt()} sp font",
            fontSize = fontSize.toInt().sp,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
        )
        SettingSliderView(fontSize) { fontSize = it }
    }
}

@Composable
private fun SettingSliderView(fontSize: Float, changedFontSize: (Float) -> Unit) {
    Row {
        Text(text = "fontSize")
        Slider(
            value = fontSize,
            onValueChange = changedFontSize,
            valueRange = 0f..50f,
            steps = 49,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        )
    }
}