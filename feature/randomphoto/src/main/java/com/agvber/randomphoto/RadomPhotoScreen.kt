package com.agvber.randomphoto

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.agvber.designsystem.component.PrographyAppBar
import com.agvber.designsystem.component.PrographyNavigationBar
import com.agvber.designsystem.component.PrographyNavigationItem
import com.agvber.designsystem.component.RandomPhotoCardView
import com.agvber.designsystem.theme.PROGRAPHY_ANDROID_Theme
import com.agvber.model.FakeModel
import com.agvber.model.Photo
import kotlinx.coroutines.flow.flowOf

@Composable
fun RandomPhotoRoute(
    navigationItemOnChange: (PrographyNavigationItem) -> Unit,
    photoInfoButtonOnClick: (String) -> Unit,
    randomPhotoViewModel: RandomPhotoViewModel = hiltViewModel(),
) {
    val randomPhoto = randomPhotoViewModel.randomPhoto.collectAsLazyPagingItems()
    RandomPhotoScreen(
        navigationItemOnChange = navigationItemOnChange,
        bookmarkOnRequest = { randomPhotoViewModel.addBookmark(it.id) },
        infoButtonOnClick = { photoInfoButtonOnClick(it) },
        closeButtonOnClick = { randomPhotoViewModel.deleteBookmark(it.id) },
        randomPhoto = randomPhoto
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RandomPhotoScreen(
    navigationItemOnChange: (PrographyNavigationItem) -> Unit,
    bookmarkOnRequest: (Photo) -> Unit,
    infoButtonOnClick: (String) -> Unit,
    closeButtonOnClick: (Photo) -> Unit,
    randomPhoto: LazyPagingItems<Photo>
) {

    Scaffold(
        topBar = { PrographyAppBar() },
        bottomBar = {
            PrographyNavigationBar(
                itemOnClick = navigationItemOnChange,
                state = PrographyNavigationItem.RANDOM_PHOTO
            )
        },
        modifier = Modifier
    ) { scaffoldPaddingValue ->
        val pagerState = rememberPagerState(
            initialPage = 1,
            pageCount = { randomPhoto.itemCount }
        )
        HorizontalPager(
            state = pagerState,
            pageSpacing = 8.dp,
            contentPadding = PaddingValues(horizontal = 24.dp),
        ) {page ->
            RandomPhotoCardView(
                bookmarkOnRequest = {
                    randomPhoto[page]?.let { bookmarkOnRequest(it) }
                },
                infoButtonOnClick = {
                    randomPhoto[page]?.let { infoButtonOnClick(it.id) }
                },
                closeButtonOnClick = {
                    randomPhoto[page]?.let { closeButtonOnClick(it) }
                },
                imageUrl = randomPhoto[page]?.url?.regular ?: "",
                modifier = Modifier
                    .padding(scaffoldPaddingValue)
                    .padding(top = 28.dp, bottom = 44.dp)
                    .shadow(6.dp, RoundedCornerShape(size = 15.dp), true)
            )
        }
    }
}

@Preview
@Composable
fun RandomPhotoScreenPreview() {
    PROGRAPHY_ANDROID_Theme {
        RandomPhotoScreen(
            navigationItemOnChange = {},
            bookmarkOnRequest = {},
            infoButtonOnClick = {},
            closeButtonOnClick = {},
            randomPhoto = flowOf(PagingData.from(FakeModel.photos)).collectAsLazyPagingItems()
        )
    }
}