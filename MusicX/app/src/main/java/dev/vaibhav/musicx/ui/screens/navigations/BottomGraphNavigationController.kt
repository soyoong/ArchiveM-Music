package dev.vaibhav.musicx.ui.screens

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.vaibhav.musicx.data.viewmodel.MainViewModel
import dev.vaibhav.musicx.ui.screens.homeScreen2.HomeScreen3
import dev.vaibhav.musicx.ui.screens.navigations.BottomScreens
import dev.vaibhav.musicx.ui.screens.navigations.BottomScreens.Items.items
import dev.vaibhav.musicx.ui.screens.navigations.Screens
import dev.vaibhav.musicx.ui.theme.ComposeBottomNavigationTheme
import dev.vaibhav.musicx.utils.BottomConstants.ROUTE_FAVORITE
import dev.vaibhav.musicx.utils.BottomConstants.ROUTE_HOME
import dev.vaibhav.musicx.utils.BottomConstants.ROUTE_NOTIFICATION
import dev.vaibhav.musicx.utils.BottomConstants.ROUTE_SETTING

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BottomNavigationController(
    viewModel: MainViewModel,
    navHostController: NavHostController
) {

    val navController = rememberNavController()

    ComposeBottomNavigationTheme {
        Scaffold(
            bottomBar = {
                BottomNavigation(
                    backgroundColor = MaterialTheme.colors.background,
                    elevation = 16.dp,
                    modifier = Modifier
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()           //when ever backStack changes it will recompose itself
                    val currentRoute =
                        navBackStackEntry?.destination?.route                        //fetching current backStack entry

                    items.forEach {
                        BottomNavigationItem(
                            icon = {                                                                //bottom nav icon
                                Icon(
                                    imageVector = it.icon,
                                    contentDescription = "",
                                    tint = if (currentRoute == it.route) Color.DarkGray else Color.LightGray
                                )
                            },
                            selected = currentRoute == it.route,                                    //current destination that is visible to user
                            label = {
                                Text(                                                               //bottom nav text
                                    text = it.label,
                                    color = if (currentRoute == it.route) Color.DarkGray else Color.LightGray,
                                    maxLines = 1,
                                    textAlign = TextAlign.Center,
                                    fontSize = 10.sp
                                )
                            },
                            onClick = {
                                if (currentRoute != it.route) {                                     //current route is not equal to same route
                                    navController.graph.startDestinationRoute?.let { item ->        //then handle back press
                                        navController.popBackStack(
                                            item, false
                                        )
                                    }
                                }
                                if (currentRoute != it.route) {                                     //condition to check current route is not equal to screens route
                                    navController.navigate(it.route)
                                }
                            },
                            alwaysShowLabel = false,                                                 // showing/hiding title text
                            selectedContentColor = MaterialTheme.colors.secondary,                  // ripple color
                        )
                    }

                }
            }
        ) {
            NavHost(navController = navController, startDestination = BottomScreens.Home.route) {
                composable(BottomScreens.Home.route) {
                    HomeScreen3(mainViewModel = viewModel)
                }
                composable(BottomScreens.Notification.route) {
                    Notification()
                }
                composable(BottomScreens.Favorite.route) {
                    Favorite()
                }
                composable(BottomScreens.Setting.route) {
                    Settings()
                }
            }
        }
    }
}