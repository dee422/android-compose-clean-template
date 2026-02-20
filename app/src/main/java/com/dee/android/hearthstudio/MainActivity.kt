package com.dee.android.hearthstudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dee.android.hearthstudio.navigation.AppNavHost
import com.dee.android.hearthstudio.ui.theme.HearthStudioTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HearthStudioTheme {
                AppNavHost()
            }
        }
    }
}