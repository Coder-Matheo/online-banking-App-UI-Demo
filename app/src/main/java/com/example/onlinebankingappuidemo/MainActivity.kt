package com.example.onlinebankingappuidemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.onlinebankingappuidemo.mainScreen.CallDrawer
import com.example.onlinebankingappuidemo.mainScreen.HomeScreen
import com.example.onlinebankingappuidemo.ui.theme.OnlineBankingAppUiDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnlineBankingAppUiDemoTheme {

                CallDrawer()
            }
        }
    }
}



