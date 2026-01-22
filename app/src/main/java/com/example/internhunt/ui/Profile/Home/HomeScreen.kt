package com.example.internhunt.ui.Profile.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.example.internhunt.ui.Profile.Navigation.BottomNavigationBar
import com.example.internhunt.R
import com.example.internhunt.data.model.local.InternshipDatabase
import com.example.internhunt.data.model.remote.RetrofitInstance
import com.example.internhunt.data.model.repo.InternshipRepository

@Composable
fun HomeScreen(navController: NavHostController) {

    val context = LocalContext.current

    val repo = InternshipRepository(
        RetrofitInstance.api,
        InternshipDatabase.getDatabase(context).internshipDao()
    )

    val viewModel: HomeViewmodel =
        viewModel(factory = HomeViewmodelFactory(repo))

    val internships = viewModel.internships.collectAsState()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            //  Top Header Background
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
                        .padding(top=25.dp, start = 17.dp, end = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("Hello,", color = Color.White, fontSize = 20.sp)
                        Text(
                            "Dev Sengar",
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

            Spacer(modifier = Modifier.height(10.dp))

            //  Stats Cards
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                StatCard(
                    title = "Internship",
                    subtitle = "Applied",
                    count = "224",
                    color = Color(0xFF7C4DFF)
                )

                StatCard(
                    title = "Internship",
                    subtitle = "Saved",
                    count = "24",
                    color = Color(0xFF607D8B)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            FilterChips()
            Spacer(modifier = Modifier.height(8.dp))
            //  Recent Listings Title
            Text(
                "Recent Listings",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            //
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(internships.value) { internship ->
                    InternshipHorizontalCard(internship)
                }
            }
        }
    }
}


@Composable
fun FilterChips() {
    LazyRow(
        modifier = Modifier.padding(start = 16.dp, top = 0.dp, end = 10.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(listOf("All", "Remote", "Full-time", "Part-time")) { chip ->
            AssistChip(
                onClick = { },
                label = { Text(chip, fontSize = 15.sp) }
            )
        }
    }
}

