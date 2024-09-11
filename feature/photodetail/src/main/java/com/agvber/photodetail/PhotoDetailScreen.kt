package com.agvber.photodetail

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.agvber.core.designsystem.nonReplyClick
import com.agvber.core.designsystem.theme.Gray30
import com.agvber.core.designsystem.theme.PROGRAPHY_ANDROID_Theme
import com.agvber.core.domain.model.FakeModel

@Composable
fun PhotoDetailRoute(
    onBackRequest: () -> Unit,
    photoDetailViewModel: PhotoDetailViewModel = hiltViewModel(),
) {
    val photoDetailUiState by photoDetailViewModel.photoDetail.collectAsStateWithLifecycle()
    PhotoDetailScreen(
        onBackRequest = onBackRequest,
        downloadButtonClick = { },
        bookmarkButtonClick = {
            if (it) {
                photoDetailViewModel.addBookmark()
            } else {
                photoDetailViewModel.deleteBookmark()
            }
        },
        photoDetailUiState = photoDetailUiState
    )
}

@Composable
fun PhotoDetailScreen(
    onBackRequest: () -> Unit,
    downloadButtonClick: () -> Unit,
    bookmarkButtonClick: (Boolean) -> Unit,
    photoDetailUiState: PhotoDetailUiState
) {
    var isBookmark by rememberSaveable { mutableStateOf(true) }
    Scaffold(
        topBar = {
            if (photoDetailUiState is PhotoDetailUiState.Success) {
                PhotoDetailHeader(
                    closeButtonClick = onBackRequest,
                    downloadButtonClick = downloadButtonClick,
                    bookmarkButtonClick = {
                        isBookmark = !isBookmark
                        bookmarkButtonClick(isBookmark)
                    },
                    userName = photoDetailUiState.data.userName,
                    isBookmarked = photoDetailUiState.data.isBookmarked
                )
            }
        },
        containerColor = Color.Black
    ) { scaffoldPaddingValue ->
        if (photoDetailUiState !is PhotoDetailUiState.Success) return@Scaffold

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(scaffoldPaddingValue)
        ) {

            AsyncImage(
                model = photoDetailUiState.data.url.regular,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                placeholder = painterResource(id = com.agvber.core.designsystem.R.drawable.photo_test_item),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .clip(RoundedCornerShape(15.dp))
            )

            PhotoDetailFooter(
                title = photoDetailUiState.data.title,
                description = photoDetailUiState.data.description,
                tags = photoDetailUiState.data.tag,
                modifier = Modifier.align(Alignment.BottomStart)
            )
        }
    }

}

@Composable
fun PhotoDetailHeader(
    closeButtonClick: () -> Unit,
    downloadButtonClick: () -> Unit,
    bookmarkButtonClick: () -> Unit,
    userName: String,
    isBookmarked: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(36.dp)
                    .background(Gray30, CircleShape)
                    .nonReplyClick { closeButtonClick() }
            ) {
                Icon(
                    painter = painterResource(id = com.agvber.core.designsystem.R.drawable.ic_close_black),
                    contentDescription = null
                )
            }
            Text(
                text = userName,
                fontFamily = FontFamily(Font(com.agvber.core.designsystem.R.font.pretendard_bold)),
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = com.agvber.core.designsystem.R.drawable.ic_download),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .padding(10.dp)
                    .nonReplyClick { downloadButtonClick() }
            )
            val alphaAnimation by animateFloatAsState(
                targetValue = if (isBookmarked) 1f else .3f
            )
            Icon(
                painter = painterResource(id = com.agvber.core.designsystem.R.drawable.ic_bookmark_black),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.Top)
                    .alpha(alphaAnimation)
                    .nonReplyClick { bookmarkButtonClick() }
            )
        }
    }
}

@Composable
fun PhotoDetailFooter(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    tags: List<String>
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 10.dp)
    ) {
        Text(
            text = title,
            fontFamily = FontFamily(Font(com.agvber.core.designsystem.R.font.pretendard_bold)),
            fontSize = 20.sp,
            color = Color.White
        )
        Text(
            text = description,
            fontFamily = FontFamily(Font(com.agvber.core.designsystem.R.font.pretendard_medium)),
            fontSize = 15.sp,
            color = Color.White,
            maxLines = 2,
            softWrap = true,
            modifier = Modifier.padding(top = 4.dp)
        )
        Row(
            modifier = Modifier.padding(top = 8.dp)
        ) {
            tags.subList(0, 3).forEach {
                Text(
                    text = "#${it}",
                    fontFamily = FontFamily(Font(com.agvber.core.designsystem.R.font.pretendard_medium)),
                    fontSize = 15.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun PhotoDetailHeaderPreview() {
    PROGRAPHY_ANDROID_Theme {
        PhotoDetailHeader(
            closeButtonClick = { },
            downloadButtonClick = { },
            bookmarkButtonClick = { },
            userName = "UserName",
            isBookmarked = false
        )
    }
}

@Preview
@Composable
fun PhotoDetailFooterPreview() {
    PROGRAPHY_ANDROID_Theme {
        PhotoDetailFooter(
            title = "title",
            description = "description\ndescription은 최대 2줄",
            tags = listOf("tag", "tag", "tag", "tag", "tag")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PhotoDetailScreenPreview() {
    PROGRAPHY_ANDROID_Theme {
        PhotoDetailScreen(
            onBackRequest = {},
            downloadButtonClick = {},
            bookmarkButtonClick = {},
            photoDetailUiState = PhotoDetailUiState.Success(FakeModel.photoDetail)
        )
    }
}