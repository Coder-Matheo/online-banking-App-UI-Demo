package com.example.onlinebankingappuidemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
) {


    TopAppBar(
        backgroundColor = Color.Black,
        title = {
            Text(text = "", modifier = Modifier.background(Color.Gray))
        },
        navigationIcon = {

            // Creating Icon button for dropdown menu
            IconButton( onNavigationIconClick ) {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = "",
                    tint = Color.White
                )
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
