package com.agvber.designsystem.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.agvber.designsystem.R
import com.agvber.designsystem.theme.Gray20
import com.agvber.designsystem.theme.PROGRAPHY_ANDROID_Theme

@Composable
fun PhotoCardView(
    modifier: Modifier = Modifier,
    content: @Composable() (BoxScope.() -> Unit)
) {
    Box(
        modifier = modifier
            .background(color = Gray20, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp)),
        content = content
    ) 
}

@Composable
fun PhotoCardView(
    text: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    BoxWithConstraints(
        modifier = modifier
            .background(color = Gray20, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
    ) {
        content()
        Box(
            modifier = Modifier
                .matchParentSize()
        ) {//#0000004d
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color(0xFFACACAF)
                            )
                        )
                    )
                    .padding(top = 12.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
            ) {
                Text(
                    text = text,
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_medium)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF)
                    ),
                    maxLines = 2,
                    softWrap = true
                )
            }
        }
    }
}

@Preview
@Composable
fun PhotoCardViewPreview() {
    PROGRAPHY_ANDROID_Theme {
        PhotoCardView(
            modifier = Modifier.size(100.dp)
        ) {
        }
    }
}

@Preview
@Composable
fun PhotoCardViewWithTextPreview() {
    PROGRAPHY_ANDROID_Theme {
        PhotoCardView(
            text = "titletitletitle\n타이틀은 최대 2줄 까지",
        ) {
            Canvas(modifier = Modifier.size(150.dp)) {
                drawRect(color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun PhotoCardViewWithTextAndPhotoPreview() {
    PROGRAPHY_ANDROID_Theme {
        PhotoCardView(
            text = "titletitletitle\n타이틀은 최대 2줄 까지",
        ) {
            Image(
                painter = painterResource(id = R.drawable.photo_test_item),
                contentDescription = null
            )
        }
    }
}