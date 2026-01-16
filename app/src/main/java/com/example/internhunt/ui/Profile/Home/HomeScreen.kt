package com.example.internhunt.ui.Profile.Home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.internhunt.ui.Profile.Navigation.BottomNavigationBar
import com.example.internhunt.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ){}
    Box(
modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter =painterResource(R.drawable.pag2)
            , contentDescription = null
        , modifier = Modifier.fillMaxWidth()
        )
        Column(
            //verticalArrangement = Arrangement.Top
             modifier = Modifier.fillMaxHeight()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(top=49.dp, start = 18.dp, end = 16.dp).fillMaxWidth()
            ){
                Column(

                ){
                    Text(
                        "Hello,", fontSize = 21.sp  , color = Color.White
                    )
                    Spacer(modifier = Modifier.height(1.dp))

                    Text(
                        text = "Dev Sengar"
                        , modifier = Modifier.padding(start = 0.dp)
                        , fontSize = 35.sp
                        , color = Color.White
                        , fontWeight = FontWeight.Medium
                    )
                }

                Image(painter = painterResource(R.drawable.img_7),
                    contentDescription = null
                    , modifier = Modifier.size(50.dp)
                        .padding(top =  0.dp)
                        .clip(shape = CircleShape))
            }
          Spacer(modifier = Modifier.height(92.dp))

     Row(
         modifier = Modifier.fillMaxWidth()
         , horizontalArrangement = Arrangement.SpaceBetween
     ) {
         Card(
             modifier = Modifier.padding(5.dp)
                 .fillMaxWidth(.49f)
                 .height(150.dp)
             , colors = CardDefaults.cardColors(containerColor = Color(0xFF794ED2))
         ) {

                 Column(
                     modifier = Modifier.padding(15.dp)
                     , horizontalAlignment = Alignment.CenterHorizontally
                 ) {
                     Row(
                         horizontalArrangement = Arrangement.SpaceBetween,
                         modifier = Modifier.fillMaxWidth()
                     ){
                         Column {
                             Text(
                                 text = "Internship"
                                 , color = Color.White
                                 , fontWeight = FontWeight.Medium
                                 , fontSize = 26.sp
                                 , modifier = Modifier.padding(top = 0.dp, start = 1.dp)
                             )
                             Text(
                                 text = "   Applied"
                                 , color = Color.White
                                 , fontSize = 21.sp
                                 , fontWeight = FontWeight.Medium
                             )
                         }

                         Icon(imageVector = Icons.Default.Info,
                             tint = Color.White,
                             contentDescription = null
                             , modifier = Modifier.padding(top=3.dp, start = 6.dp))
                     }

                     Spacer(modifier = Modifier.height(10.dp))
                     Text("224"
                         , fontWeight = FontWeight.Bold
                         , color = Color.White
                         , fontSize = 32.sp)
                 }


         }
         Card(
             modifier = Modifier.fillMaxWidth().align(Alignment.Bottom)
                 .padding(5.dp)  .height(150.dp)
             , colors = CardDefaults.cardColors(containerColor = Color(0xFF747277))
         ) {

             Column(
                 modifier = Modifier.padding(15.dp)
                 , horizontalAlignment = Alignment.CenterHorizontally
             ) {
                 Row(
                     horizontalArrangement = Arrangement.SpaceBetween,
                     modifier = Modifier.fillMaxWidth()
                 ){
                     Column {
                         Text(
                             text = "Internship"
                             , color = Color.White
                             , fontWeight = FontWeight.Medium
                             , fontSize = 26.sp
                             , modifier = Modifier.padding(top = 0.dp, start = 1.dp)
                         )
                         Text(
                             text = "     Saved"
                             , color = Color.White
                             , fontSize = 22.sp
                             , fontWeight = FontWeight.Medium
                         )
                     }

                     Icon(imageVector = Icons.Default.Info,
                         tint = Color.White,
                         contentDescription = null
                         , modifier = Modifier.padding(top=4.dp, start = 0.dp))
                 }

                 Spacer(modifier = Modifier.height(10.dp))
                 Text("24"
                     , fontWeight = FontWeight.Bold
                     , color = Color.White
                     , fontSize = 32.sp)
             }


         }
     }
Row(){
    Text("Recent Listings",
        fontWeight = FontWeight.Medium,
        fontSize = 30.sp
    , modifier = Modifier.padding(start = 16.dp, top = 10.dp)
    )
}



        }

    }

}