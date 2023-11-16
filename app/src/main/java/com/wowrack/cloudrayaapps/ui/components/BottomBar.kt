package com.wowrack.cloudrayaapps.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MiscellaneousServices
import androidx.compose.material.icons.filled.Monitor
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.wowrack.cloudrayaapps.R
import com.wowrack.cloudrayaapps.ui.navigation.NavigationItem
import com.wowrack.cloudrayaapps.ui.navigation.Screen

@Composable
fun BottomBar(
    navigator: (String) -> Unit,
    currentRoute: String,
    modifier: Modifier = Modifier
) {
    val navigationItems = listOf(
        NavigationItem(
            title = stringResource(R.string.menu_home),
            icon = Icons.Default.Home,
            screen = Screen.Home
        ),
        NavigationItem(
            title = stringResource(R.string.menu_resource),
            icon = Icons.Default.MiscellaneousServices,
            screen = Screen.Resource
        ),
//        NavigationItem(
//            title = stringResource(R.string.menu_monitor),
//
//            icon = Icons.Default.Monitor,
//            screen = Screen.Monitor
//        ),
//        NavigationItem(
//            title = stringResource(R.string.menu_server),
//            icon = Icons.Default.Security,
//            screen = Screen.Server
//        ),
        NavigationItem(
            title = stringResource(R.string.menu_profile),
            icon = Icons.Default.AccountCircle,
            screen = Screen.Profile
        ),
    )

    NavigationBar(
        modifier = modifier,
    ) {
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navigator(item.screen.route)
                }
            )
        }
    }
}