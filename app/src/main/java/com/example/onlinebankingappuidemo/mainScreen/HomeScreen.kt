package com.example.onlinebankingappuidemo.mainScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlinebankingappuidemo.R


@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        ToolbarLayer()
        TextAndBoxBalance()
    }
}

@Composable
fun ToolbarLayer() {
    var showMenu by remember { mutableStateOf(false) }
    val mContext = LocalContext.current

    TopAppBar(
        backgroundColor = Color.Black,
        title = {
            Text(text = "", modifier = Modifier.background(Color.Red))
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


@Composable
fun TextAndBoxBalance() {
    Text(
        modifier = Modifier
            .padding(start = 20.dp),
        text = "Hallo world ",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(100.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(Color.Red)
                .align(Alignment.Center)


        ) {
            Row(
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
            ) {
                Column() {
                    Text(
                        text = "12.12.2022", fontSize = 15.sp,
                        color = Color.White
                    )
                    Text(
                        text = "$3.456.543",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Text(
                    text = "15% ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

        }
    }

}

@Composable
@Preview
fun HomeScreenPreview() {
    TextAndBoxBalance()
}