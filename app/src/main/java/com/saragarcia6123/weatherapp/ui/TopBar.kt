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
import androidx.compose.foundation.layout.width
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.saragarcia6123.weatherapp.ui.theme.Primary

@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(rememberNavController())
}

@Preview
@Composable
fun LocationBarPreview() {
    LocationBar({}, rememberNavController())
}

@Composable
fun LocationBar(onMenuItemClick: () -> Unit, navController: NavHostController, modifier: Modifier = Modifier) {
    Box()
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp)
        ) {
            MenuIcon {
                onMenuItemClick()
            }
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            ContentBar(
                navController = navController,
                content = { HomeBarContent() },
                padding = 8.dp
            )
        }
    }
}

@Composable
fun SearchBar(navController: NavHostController, modifier: Modifier = Modifier) {
    Box()
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp)
        ) {
            BackIcon(
                onClick = { navController.navigate(Screen.Home.route) }
            )
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            ContentBar(
                content = { SearchBarContent() },
                navController = navController,
                padding = 0.dp
            )
        }
    }
}

@Composable
fun MenuIcon(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .width(44.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Menu,
            tint = Primary,
            contentDescription = "Menu",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
fun BackIcon(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .width(44.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
            tint = Primary,
            contentDescription = "Back",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentBar(modifier: Modifier = Modifier, navController: NavHostController, content: @Composable (Modifier) -> Unit, padding: Dp) {
    Card(
        onClick = {
            navController.navigate(Screen.Search.route)
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(30.dp)
                .padding(horizontal = padding)
        ) {
            content(Modifier.fillMaxSize())
        }
    }
}

@Composable
fun HomeBarContent(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Text(text = "Madrid, ES", modifier = Modifier.padding(start = 8.dp))
    Icon(
        imageVector = Icons.Filled.KeyboardArrowDown,
        contentDescription = "Down arrow",
        tint = Color.Gray,
        modifier = Modifier
    )
}

@Composable
fun SearchBarContent(modifier: Modifier = Modifier) {
    var value by remember {
        mutableStateOf("")
    }
    EditTextField(value = value, onValueChange = { value = it }, modifier = Modifier.fillMaxWidth())
}

@Composable
fun EditTextField(value: String, onValueChange: (String) -> Unit, modifier: Modifier) {

    val focusRequester = remember { FocusRequester() }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester),
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(value) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "",
                tint = Color.Gray)
        },
        enabled = true,
        colors = textFieldColors(
            textColor = Color.Gray,
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

}

fun onSearchValueChange() {

}