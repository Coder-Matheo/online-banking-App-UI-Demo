package com.example.onlinebankingappuidemo

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.onlinebankingappuidemo.ui.theme.Purple500

@Composable
fun Chart(
    data: Map<Float, String>,
    max_value: Int
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .height(200.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            //graph
            data.forEach {
                Box(modifier = Modifier
                    .padding(20.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .width(20.dp)
                    .fillMaxHeight(it.key)
                    .background(Purple500)
                    .clickable {
                        Toast
                            .makeText(context, it.key.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            data.values.forEach {
                Text(
                    modifier = Modifier.width(40.dp),
                    text = it.toString(),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}
