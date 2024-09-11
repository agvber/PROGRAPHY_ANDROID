package com.agvber.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.agvber.core.designsystem.nonReplyClick
import com.agvber.core.designsystem.previewPlaceholder
import com.agvber.core.designsystem.theme.BrandColor
import com.agvber.core.designsystem.theme.Gray30
import com.agvber.core.designsystem.theme.Gray60
import com.agvber.core.designsystem.theme.PROGRAPHY_ANDROID_Theme
import com.agvber.core.designsystem.R

@Composable
fun RandomPhotoCardView(
    bookmarkOnRequest: () -> Unit,
    infoButtonOnClick: () -> Unit,
    closeButtonOnClick: () -> Unit,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    var isImageLoading by rememberSaveable { mutableStateOf(true) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(size = 15.dp)
            )
            .padding(top = 12.dp, start = 12.dp, end = 12.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(
                    color = Color(0xFF070707),
                    shape = RoundedCornerShape(size = 10.dp)
                )
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                placeholder = previewPlaceholder(id = R.drawable.photo_test_item),
                onSuccess = {
                    isImageLoading = false
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
            if (isImageLoading) {
                CircularProgressIndicator(
                    color = BrandColor,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterHorizontally),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(52.dp)
                    .border(
                        width = 1.dp,
                        color = Gray30,
                        shape = CircleShape
                    )
                    .nonReplyClick(onClick = closeButtonOnClick)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_close_black),
                    contentDescription = null,
                    tint = Gray60,
                    modifier = Modifier.size(36.dp)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(72.dp)
                    .background(
                        color = BrandColor,
                        shape = RoundedCornerShape(size = 36.dp)
                    )
                    .padding(20.dp)
                    .nonReplyClick(onClick = bookmarkOnRequest)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bookmark_black),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(52.dp)
                    .border(
                        width = 1.dp,
                        color = Gray30,
                        shape = CircleShape
                    )
                    .nonReplyClick(onClick = infoButtonOnClick)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_info_black),
                    contentDescription = null,
                    tint = Gray60,
                    modifier = Modifier
                        .size(23.2.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun RandomPhotoCardViewPreview() {
    PROGRAPHY_ANDROID_Theme {
        RandomPhotoCardView(
            bookmarkOnRequest = {},
            infoButtonOnClick = {},
            closeButtonOnClick = {},
            imageUrl = "https://images.unsplash.com/photo-1682687982468-4584ff11f88a?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w1NTk5MzZ8MXwxfGFsbHwzMXx8fHx8fDJ8fDE3MDY1MzM5NzB8&ixlib=rb-4.0.3&q=80&w=1080",
            modifier = Modifier
                .width(327.dp)
                .height(553.dp)
        )
    }
}
