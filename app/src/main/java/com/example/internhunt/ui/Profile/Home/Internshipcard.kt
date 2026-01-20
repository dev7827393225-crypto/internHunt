package com.example.internhunt.ui.Profile.Home

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internhunt.data.model.remote.Internship
import com.example.internhunt.ui.Profile.Search.openUrl


@Composable
fun InternshipHorizontalCard(internship: Internship) {
val context= LocalContext.current
    Card(
        modifier = Modifier
            .width(240.dp)
            .height(220.dp),
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


                Spacer(modifier = Modifier.width(30.dp))

                Column {
                    Text(
                        internship.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        maxLines = 2
                    )

                    Text(
                        internship.company.display_name,
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
            }
Spacer(modifier = Modifier.height(10.dp))
            Text(
                internship.location.display_name,
                fontSize = 18.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(7.dp))
Text(
    text=""+internship.redirect_url.toString(),
    fontSize = 14.sp,
    color = Color.Blue
    , modifier = Modifier.padding(start = 0.dp).clickable{
        openUrl(context = context,url=internship.redirect_url.toString())
    }
)
        }
    }
}


