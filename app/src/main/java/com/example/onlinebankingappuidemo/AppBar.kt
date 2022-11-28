package com.example.onlinebankingappuidemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun AppBar(){
    var showMenu by remember { mutableStateOf(false) }


    TopAppBar(
        backgroundColor = Color.Black,
        title = {
            Text(text = "", modifier = Modifier.background(Color.Gray))
        },
        navigationIcon = {
            /*IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "",
                    tint = Color.White
                )
            }*/

            // Creating Icon button for dropdown menu
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = "",
                    tint = Color.White
                )
            }


            DropdownMenu(
                modifier = Modifier
                    .background(Color.Gray)
                    .width(60.dp),
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {

                // Creating dropdown menu item, on click
                // would create a Toast message
                DropdownMenuItem(
                    onClick = { }) {
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "",
                            tint = Color.Black
                        )

                    }
                }

                // Creating dropdown menu item, on click
                // would create a Toast message
                DropdownMenuItem(onClick = {}) {
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Filled.Settings,
                            contentDescription = "",
                            tint = Color.Black
                        )
                    }
                }
            }

        },
        actions = {

            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(R.drawable.person_profil),
                    contentDescription = "Person profile",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)

                        .border(2.dp, Color.Gray, CircleShape)

                )
            }


        }

    )
}
