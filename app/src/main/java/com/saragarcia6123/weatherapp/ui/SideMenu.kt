package com.saragarcia6123.weatherapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saragarcia6123.weatherapp.ui.theme.SecondaryDark
import kotlinx.coroutines.launch

@Preview
@Composable
fun SideBarPreview() {
    SideBarContainer(
        items = listOf(Screen.Search, Screen.Settings),
        onItemClick = {},
        scaffoldState = rememberScaffoldState(),
        width = 240.dp
    )
}

@Composable
fun SideBarContainer(items: List<Screen>, scaffoldState: ScaffoldState, modifier: Modifier = Modifier, onItemClick: (Screen) -> Unit, width: Dp) {
    Column(
        modifier = modifier
            .background(SecondaryDark)
            .fillMaxHeight()
            .width(width)
    ) {
        SideBarHeader(scaffoldState, width)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            items.forEach { item ->
                SideBarContent(item = item, onClick = onItemClick)
            }
        }
    }
}

@Composable
private fun SideBarHeader(scaffoldState: ScaffoldState, width: Dp) {
    Box(
        modifier = Modifier
            .width(width)
            .padding(8.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        val scope = rememberCoroutineScope()
        IconButton(
            onClick = { scope.launch { scaffoldState.drawerState.close() } }){
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Close Side Menu",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }
}

@Composable
private fun SideBarContent(modifier: Modifier = Modifier, item: Screen, onClick: ((Screen) -> Unit)) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .height(46.dp)
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .clickable { onClick(item) }
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.title,
            tint = Color.White,
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 2.dp)
        )
        Text(
            text = item.title,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .padding(start = 16.dp)
        )
    }
}