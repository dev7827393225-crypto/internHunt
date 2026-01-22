package com.example.internhunt.ui.Profile.Search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.internhunt.data.model.local.InternshipDatabase
import com.example.internhunt.data.model.remote.RetrofitInstance
import com.example.internhunt.data.model.repo.InternshipRepository
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
                items(internship.value) { item ->
                    SearchCard(
                        title = item.title,
                        company = item.company.display_name,
                        Location = item.location.display_name,
                        url = item.redirect_url ?: "",
                        internship = item,
                        onsaveClick = {
                            viewModel.saveInternship(item)
                        }
                    )
                }
            }
        }


    }
}