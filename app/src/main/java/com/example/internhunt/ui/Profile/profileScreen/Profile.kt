package com.example.internhunt.ui.Profile.profileScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.internhunt.R
import com.example.internhunt.ui.Profile.Navigation.BottomNavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ){}



    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier.
                // .padding(top = 22.dp, start = 16.dp,end=16.dp)
            fillMaxWidth()

        ) {
            Image(
                painter = painterResource(R.drawable.pag2),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.TopEnd
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 45.dp, start = 10.dp),
                horizontalArrangement = Arrangement.Start
            ) {

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
                Text(
                    "Profile",
                    modifier = Modifier.
                    padding(start = 130.dp, top = 0.dp),
                    fontSize = 22.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Default.Menu,
                    modifier = Modifier.
                    padding(start = 130.dp, top = 0.dp),
                    contentDescription = null, tint = Color.White

                )




            }
            Card(
                modifier = Modifier.padding(
                    start = 120.dp,top=200.dp)
                    .size(160.dp)

                , shape = CircleShape


            ) {
                Image(painter = painterResource(R.drawable.img_2)
                    , contentDescription = ""
                    , alignment = Alignment.Center

                )
            }
            LazyColumn(
                modifier = Modifier.
                padding(start = 10.dp, top = 380.dp)
                    .fillMaxWidth(1f)
            ){
                items(items){item->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null
                            , modifier = Modifier.clickable(
                                onClick = {

                                }
                            )
                        )
                        Spacer(modifier = Modifier.width(40.dp))
                        Text(
                            text = item.name,
                            fontSize = 22.sp
                            , modifier = Modifier.clickable(
                                onClick = {

                                }
                            ).fillMaxWidth()
                        )
                    }

                }

            }


        }
    }
}

var items= listOf(
    itemdata.invite,
    itemdata.account,
    itemdata.personal,
    itemdata.message,
    itemdata.login,
    itemdata.data,
)
open class itemdata(
    val name: String,
    val icon: ImageVector
) {
    object invite : itemdata("Invite friend", Icons.Default.AddCircle)
    object personal : itemdata("Personal profile", Icons.Default.AccountCircle)
    object account : itemdata("Account Info", Icons.Default.Person)
    object message : itemdata("Message centre", Icons.Default.MailOutline)
    object login : itemdata("Login and Security", Icons.Default.Build)
    object data : itemdata("Data and Privacy", Icons.Default.Lock)
}


