package com.example.internhunt.ui.Profile.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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


@Composable
fun StatCard(
    title: String,
    subtitle: String,
    count: String,
    color: Color
) {
    Card(
        modifier = Modifier
            .height(140.dp).width(180.dp),
        colors = CardDefaults.cardColors(containerColor = color),
        shape = RoundedCornerShape(18.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(title, color = Color.White,
                    fontSize = 28.sp
                    , modifier = Modifier.align(Alignment.CenterHorizontally))
                Text(subtitle, color = Color.White,
                    fontSize = 21.sp
                    , modifier = Modifier.align(Alignment.CenterHorizontally))

            }

            Text(
                count,
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
                , modifier = Modifier.padding(start = 0.dp).align(Alignment.CenterHorizontally)
            )
        }
    }
}