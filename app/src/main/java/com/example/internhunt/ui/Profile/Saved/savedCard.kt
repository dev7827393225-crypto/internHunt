package com.example.internhunt.ui.Profile.Saved

import android.content.Context
import android.content.Intent
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
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.SaveAlt
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internhunt.ui.Profile.Home.CompanyInitialLogo
import androidx.core.net.toUri
import com.example.internhunt.data.model.remote.Internship

@Composable
fun SavedCard(
    title: String
    , company: String
    , Location: String
    , url: String,
    onClick: ()->Unit
) {
    val context= LocalContext.current
    Card(
        modifier = Modifier.padding(10.dp).height(120.dp)
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
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                    , modifier = Modifier.fillMaxWidth()
                ){
                    Text(text=""+title, fontSize = 19.sp)
                    Icon(imageVector = Icons.Default.Delete,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 10.dp)
                            .clickable{onClick()})
                }


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