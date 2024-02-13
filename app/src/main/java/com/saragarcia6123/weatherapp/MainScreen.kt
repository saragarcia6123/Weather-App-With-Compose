package com.saragarcia6123.weatherapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.saragarcia6123.weatherapp.ui.BottomNavigationGraph
import com.saragarcia6123.weatherapp.ui.Screen
import com.saragarcia6123.weatherapp.ui.SideBarContainer
import com.saragarcia6123.weatherapp.ui.theme.PrimaryDark
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = { BottomBar(navController = navController) },
            drawerContent = {
                SideBarContainer(
                    items = listOf(
                        Screen.Settings,
                        Screen.About
                    ),
                    scaffoldState = scaffoldState,
                    onItemClick = { onDrawerItemClick(it = it, navController = navController, scope = scope, scaffoldState = scaffoldState) },
                    width = 240.dp
                )
            },
        drawerShape = customShape(
            width = with(LocalDensity.current) { 240.dp.toPx() },
            height = with(LocalDensity.current) { screenHeight.toPx() }
        )
        )
        { padding ->
            BottomNavigationGraph(
                navController = navController,
                scaffoldState = scaffoldState,
                scope = scope,
                modifier = Modifier.padding(padding)
            )
        }
}

fun customShape(width: Float, height: Float) =  object : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Rectangle(Rect(0f,0f,width , height))
    }
}

fun onDrawerItemClick(it: Screen, navController: NavHostController, scope: CoroutineScope, scaffoldState: ScaffoldState) {
    navController.navigate(it.route)
    scope.launch {
        scaffoldState.drawerState.close()
    }
}

@Preview
@Composable
fun AppPreview() {
    MainScreen()
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        Screen.Search,
        Screen.Home,
        Screen.Map,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        modifier = Modifier.background(PrimaryDark)
    )
}