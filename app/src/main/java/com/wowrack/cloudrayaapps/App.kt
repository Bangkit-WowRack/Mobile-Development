package com.wowrack.cloudrayaapps


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    modifier: Modifier = Modifier,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
//            if (currentRoute != Screen.DetailReward.route) {
//                BottomBar(navController)
//            }
        },
        modifier = modifier
    ) { innerPadding ->
//        NavHost(
//            navController = navController,
//            startDestination = Screen.Home.route,
//            modifier = Modifier.padding(innerPadding)
//        ) {
//            composable(Screen.Home.route) {
//                HomeScreen(
//                    navigateToDetail = { rewardId ->
//                        navController.navigate(Screen.DetailReward.createRoute(rewardId))
//                    }
//                )
//            }
//            composable(Screen.Cart.route) {
//                val context = LocalContext.current
//                CartScreen(
//                    onOrderButtonClicked = { message ->
//                        shareOrder(context, message)
//                    }
//                )
//            }
//            composable(Screen.Profile.route) {
//                ProfileScreen()
//            }
//            composable(
//                route = Screen.DetailReward.route,
//                arguments = listOf(navArgument("rewardId") { type = NavType.LongType }),
//            ) {
//                val id = it.arguments?.getLong("rewardId") ?: -1L
//                DetailScreen(
//                    rewardId = id,
//                    navigateBack = {
//                        navController.navigateUp()
//                    },
//                    navigateToCart = {
//                        navController.popBackStack()
//                        navController.navigate(Screen.Cart.route) {
//                            popUpTo(navController.graph.findStartDestination().id) {
//                                saveState = true
//                            }
//                            launchSingleTop = true
//                            restoreState = true
//                        }
//                    }
//                )
//            }
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    CloudRayaAppsTheme {
        App()
    }
}
