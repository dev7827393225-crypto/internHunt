package com.example.internhunt.ui.Profile.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internhunt.data.model.remote.Internship


@Composable
fun InternshipHorizontalCard(internship: Internship) {

    Card(
        modifier = Modifier
            .width(230.dp)
            .height(140.dp),
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {

                CompanyInitialLogo(internship.company.display_name)


                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        internship.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        maxLines = 2
                    )

                    Text(
                        internship.company.display_name,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }

            Text(
                internship.location.display_name,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}


