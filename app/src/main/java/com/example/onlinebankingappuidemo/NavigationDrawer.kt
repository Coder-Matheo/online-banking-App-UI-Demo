package com.example.onlinebankingappuidemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun DrawerHeader(
    scaffoldState: ScaffoldState
) {
    val scope = rememberCoroutineScope()
    Box {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd,
        ) {
            IconButton(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(60.dp)
                    .padding(12.dp)
                    .background(Color.DarkGray),
                onClick = {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_close_drawer),
                    contentDescription = null
                )
            }
        }
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.CenterStart
    ) {

        Column(modifier = Modifier.padding(start = 16.dp)) {
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
            Text(
                text = stringResource(id = R.string.user_name_text),
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(text = stringResource(id = R.string.perfetional_user))

        }
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItemDrawer>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItemDrawer) -> Unit
) {

    LazyColumn(modifier) {
        items(items) { item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    //show which Item clicked
                    onItemClick(item)
                }
                .padding(16.dp)
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.conentDescription
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

}