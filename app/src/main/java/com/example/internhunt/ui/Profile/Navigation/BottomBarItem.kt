package com.example.internhunt.ui.Profile.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PersonAddAlt1
import androidx.compose.material.icons.filled.PersonSearch
import androidx.compose.material.icons.filled.SaveAs
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItem (
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home:BottomBarItem(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home)
    object jobdetail: BottomBarItem(
        route = "jobdetail"
        , title = "job"
        ,icon=Icons.Default.SaveAs
    )
    object saved: BottomBarItem(
        route = "saved"
        , title = "Saved"
, icon = Icons.Default.PersonAddAlt1
        )
    object search: BottomBarItem(
        route = "search"
        , title = "Search"
, icon = Icons.Default.PersonSearch)

}