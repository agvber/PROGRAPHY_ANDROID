package com.agvber.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.agvber.designsystem.R
import com.agvber.designsystem.theme.Gray30
import com.agvber.designsystem.theme.PROGRAPHY_ANDROID_Theme

@Composable
fun PrographyAppBar(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_prography_logo),
            contentDescription = "prography logo",
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Divider(
            thickness = 1.dp,
            color = Gray30,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
fun PrographyAppBarPreview() {
    PROGRAPHY_ANDROID_Theme {
        PrographyAppBar()
    }
}