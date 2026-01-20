package com.example.internhunt.ui.Profile.Search

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SaveAlt
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internhunt.ui.Profile.Home.CompanyInitialLogo
import androidx.core.net.toUri

@Composable
fun SearchCard(
    title: String
    ,company: String
    ,Location: String
    ,url: String
) {
    val context= LocalContext.current
    Card(
        modifier = Modifier.padding(8.dp).height(120.dp)
               , elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(13.dp)
            ,
           //  verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start

        ) {
            CompanyInitialLogo(""+company)
Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(text=""+title, fontSize = 19.sp)
Text(text = company, color = Color.Gray)
                Text(text=""+Location, color = Color.Gray)

                Text(text = ""+url, color = Color.Blue
                , modifier = Modifier.clickable{openUrl(context,url)})
            }
Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Default.SaveAlt, contentDescription = null)
        }
    }
}
public fun openUrl(context: Context, url: String) {
    if (url.isBlank()) return
    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
    context.startActivity(intent)
}