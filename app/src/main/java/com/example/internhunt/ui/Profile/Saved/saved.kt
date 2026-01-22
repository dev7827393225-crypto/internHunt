package com.example.internhunt.ui.Profile.Saved

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.internhunt.R
import com.example.internhunt.data.model.local.InternshipDatabase
import com.example.internhunt.data.model.remote.RetrofitInstance
import com.example.internhunt.data.model.repo.InternshipRepository
import com.example.internhunt.ui.Profile.Navigation.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SavedJobScreen(navController: NavHostController) {
    val context= LocalContext.current
    val repo= InternshipRepository(
        RetrofitInstance.api,
        InternshipDatabase.getDatabase(context).internshipDao()
    )
val viewModel: savedviewmodel = viewModel(factory = savedviewmodelfactory(repo))
val internship=viewModel.internships.collectAsState()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }

    ){

            Column (
            modifier = Modifier.fillMaxSize()
                .padding(top=10.dp)
        ){
                Box {1
                    Image(
                        painter = painterResource(R.drawable.pag2),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(210.dp),
                        contentScale = ContentScale.Crop
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top=27.dp, start = 19.dp, end = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text("Saved,", color = Color.White, fontSize = 20.sp)
                            Text(
                                "internship",
                                color = Color.White,
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Image(
                            painter = painterResource(R.drawable.img_7),
                            contentDescription = null,
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                        )
                    }
                }
            LazyColumn(
            ) {
                items(internship.value){internship->
                    SavedCard(
                        title = internship.title,
                        company = internship.company,
                        Location = internship.location
                        , url = internship.applyUrl ?: ""
                        , onClick = {
                            viewModel.deleteInternship(internship)
                        }
                    )
                }
            }
        }

    }
}