package com.example.internhunt.ui.Profile.Navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavHostController) {
val items=listOf(
    BottomBarItem.Home,
    BottomBarItem.search,
    BottomBarItem.jobdetail,
    BottomBarItem.saved,
    )

    NavigationBar {
val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute=navBackStackEntry?.destination?.route

        items.forEach {item ->
         NavigationBarItem(
             selected = currentRoute==item.route,
             onClick = {if(item.route!=currentRoute){
                 navController.navigate(item.route){
                     popUpTo(navController.graph.startDestinationId){
                         saveState=true
                     }

                     launchSingleTop=true
                     restoreState=true
             }
             }
             },
             icon = {
Icon(item.icon, contentDescription = item.title) },
label = { item.title}
         )
        }

    }


}