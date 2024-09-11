package com.agvber.prography_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.agvber.core.designsystem.theme.PROGRAPHY_ANDROID_Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PROGRAPHY_ANDROID_Theme {
                PrographyNavHost()
            }
        }
    }
}