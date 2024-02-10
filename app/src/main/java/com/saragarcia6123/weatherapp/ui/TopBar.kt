package com.saragarcia6123.weatherapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saragarcia6123.weatherapp.ui.theme.Primary

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Box()
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Menu,
                tint = Primary,
                contentDescription = "Menu",
                modifier = Modifier
                    .size(42.dp)
                    .fillMaxSize()
                    .padding(end = 16.dp)
            )
            LocationBar()
            Spacer(
                modifier = Modifier
                    .size(42.dp)
                    .padding(start = 16.dp)
            )
        }
    }
}

@Composable
fun LocationBar(modifier: Modifier = Modifier) {
    Card {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(30.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Madrid, ES")
            IconButton(
                onClick = { println() }
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down arrow",
                    tint = Color.Gray,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}