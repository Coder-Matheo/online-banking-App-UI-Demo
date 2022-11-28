package com.example.onlinebankingappuidemo.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlinebankingappuidemo.*
import com.example.onlinebankingappuidemo.R
import kotlinx.coroutines.launch


@Composable
fun CallDrawer() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen
        ,
        drawerContent = {
            DrawerHeader(scaffoldState)
            DrawerBody(
                items = listOf(
                    MenuItemDrawer(
                        id = "Corporate App",
                        title = "Corporate",
                        conentDescription = "Go to Corporate screen",
                        icon = Icons.Default.Place
                    ),MenuItemDrawer(
                        id = "Security Settings",
                        title = "Settings",
                        conentDescription = "Go to settings screen",
                        icon = Icons.Default.Settings
                    ),MenuItemDrawer(
                        id = "Online Shopping",
                        title = "online shopping",
                        conentDescription = "Go to shopping screen",
                        icon = Icons.Default.ShoppingCart
                    ),MenuItemDrawer(
                        id = "Groceries",
                        title = "Groceries",
                        conentDescription = "Go to Groceries screen",
                        icon = Icons.Default.MoreVert
                    ),MenuItemDrawer(
                        id = "Utilities",
                        title = "Utilities",
                        conentDescription = "Go to Utilities screen",
                        icon = Icons.Default.Info
                    ),MenuItemDrawer(
                        id = "Thumb Scanner",
                        title = "Thumb Scanner",
                        conentDescription = "Go to Thumb Scanner screen",
                        icon = Icons.Default.ThumbUp
                    )
                ),

                onItemClick = {
                    println("Clicked on ${it.title}")
                }
            )
        }
    ) {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)

    ) {

        TextAndBoxBalance()
        LazyRowTransaction()
        TextActivities()

        Chart(
            data = mapOf(
                Pair(0.5f, "Jun"),
                Pair(0.6f, "Feb"),
                Pair(0.4f, "April"),
                Pair(0.7f, "Aug"),
                Pair(0.2f, "Feb"),
                Pair(0.2f, "Feb")

            ),
            max_value = 1000
        )
    }
}


@Composable
fun TextAndBoxBalance() {
    Text(
        modifier = Modifier
            .padding(start = 20.dp),
        text = "Your Balance",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
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
                .background(Color.DarkGray)
                .align(Alignment.Center)


        ) {

            Column() {
                Text(
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                    text = "12.12.2022",
                    fontSize = 15.sp,
                    color = Color.White,

                    )
                Row(
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(end = 100.dp),
                        text = "$3.456.543",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
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

}

@Composable
fun LazyRowTransaction() {
    Column() {
        val transactionOption = listOf(
            transactionInfo("Send", R.drawable.ic_arrow_send),
            transactionInfo("Receive", R.drawable.ic_arrow_receice),
            transactionInfo("Loan", R.drawable.ic_money),
            transactionInfo("Topup", R.drawable.ic_topup),

            )

        LazyRow(contentPadding = PaddingValues(5.dp)) {

            items(transactionOption) { item ->
                MyLazyRowTransaction(
                    transName = item.transactionName,
                    transIcon = item.transactionIcon
                )
            }
        }
    }

}

@Composable
fun MyLazyRowTransaction(transName: String, transIcon: Int) {

    Column(
        modifier = Modifier
            .fillMaxWidth(0.9f)


    ) {
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(8.dp)
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(Color.DarkGray),
                contentAlignment = Alignment.Center

            ) {
                Image(
                    painterResource(id = transIcon),
                    contentDescription = ""
                )
            }
        }

        Text(

            text = transName,
            Modifier
                .background(Color.Transparent)
                .padding(start = 22.dp, top = 0.dp),
            color = Color.White
        )

    }

}


@Composable
fun TextActivities() {

    Row(modifier = Modifier.padding(start = 20.dp)) {
        Text(
            text = stringResource(id = R.string.activitiesText),
            fontSize = 20.sp,
            color = Color.White
        )
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .offset(170.dp, 0.dp)
                .padding(end = 40.dp)
        ) {
            Text(text = stringResource(id = R.string.btnActivitiesText))
        }
    }


}
