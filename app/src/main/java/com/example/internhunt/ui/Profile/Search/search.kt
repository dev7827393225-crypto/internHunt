package com.example.internhunt.ui.Profile.Search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.room.util.TableInfo
import com.example.internhunt.data.model.local.InternshipDatabase
import com.example.internhunt.data.model.remote.RetrofitInstance
import com.example.internhunt.data.model.repo.InternshipRepository
import com.example.internhunt.ui.Profile.Home.HomeViewmodel
import com.example.internhunt.ui.Profile.Home.HomeViewmodelFactory
import com.example.internhunt.ui.Profile.Navigation.BottomNavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(navController: NavHostController) {
    val context= LocalContext.current
    val repo = InternshipRepository(
        RetrofitInstance.api,
        InternshipDatabase.getDatabase(context).internshipDao()
    )
val viewModel: SearchViewModel = viewModel(factory = SearchViewModelFactory(repo))


    val internship=viewModel.internship.collectAsState()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) {
        Column(modifier = Modifier.fillMaxWidth()){

            InternshipSearchBar(onSearch = { query ->
                viewModel.searchInternships(query)
            })
            LazyColumn {

                items(internship.value) { internship ->
                    SearchCard(
                        title = internship.title,
                         company = internship.company.display_name,
                        Location = internship.location.display_name,

                        url = internship.redirect_url ?: ""
                    )
                }
            }
        }


    }
}