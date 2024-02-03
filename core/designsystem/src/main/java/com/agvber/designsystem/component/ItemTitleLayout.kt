package com.agvber.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.agvber.designsystem.R
import com.agvber.designsystem.theme.PROGRAPHY_ANDROID_Theme

@Composable
fun ItemTitleLayout(
    text: String,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .padding(top = 10.dp, bottom = 9.dp, start = 20.dp, end = 20.dp)
) {
    Box(
        modifier = modifier
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                fontWeight = FontWeight(700),
                color = Color(0xFF070707),
            )
        )
    }
}

@Preview
@Composable
fun ItemTitleLayoutPreview() {
    PROGRAPHY_ANDROID_Theme {
        ItemTitleLayout("Title")
    }
}