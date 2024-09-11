package com.agvber.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.agvber.core.designsystem.theme.Gray30
import com.agvber.core.designsystem.theme.PROGRAPHY_ANDROID_Theme
import com.agvber.core.designsystem.R

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
        HorizontalDivider(
            modifier = Modifier.align(Alignment.BottomCenter),
            thickness = 1.dp,
            color = Gray30
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