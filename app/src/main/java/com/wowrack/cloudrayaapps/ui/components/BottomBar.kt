package com.wowrack.cloudrayaapps.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.wowrack.cloudrayaapps.R
import com.wowrack.cloudrayaapps.ui.navigation.NavigationItem
import com.wowrack.cloudrayaapps.ui.navigation.Screen

@Composable
fun BottomBar(
    navigator: (String) -> Unit,
    currentRoute: String,
    modifier: Modifier = Modifier,
) {
    val iconSize = 24.dp

    val navigationItems = listOf(
        NavigationItem(
            title = stringResource(R.string.menu_home),
            icon = painterResource(id = R.drawable.ic_home_solid),
            screen = Screen.Home
        ),
        NavigationItem(
            title = stringResource(R.string.menu_resource),
            icon = painterResource(id = R.drawable.ic_list_solid),
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
            icon = painterResource(id = R.drawable.ic_user_solid),
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
                        painter = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier.size(iconSize)
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