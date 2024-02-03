package com.agvber.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import coil.compose.AsyncImage
import com.agvber.designsystem.component.ItemTitleLayout
import com.agvber.designsystem.component.PhotoCardView
import com.agvber.designsystem.component.PrographyAppBar
import com.agvber.designsystem.component.PrographyNavigationBar
import com.agvber.designsystem.component.PrographyNavigationItem
import com.agvber.designsystem.ignoreParentPadding
import com.agvber.designsystem.nonReplyClick
import com.agvber.designsystem.previewPlaceholder
import com.agvber.designsystem.theme.PROGRAPHY_ANDROID_Theme
import com.agvber.model.FakeModel
import com.agvber.model.Photo
import com.agvber.ui.SkeletonLoadingLayout
import kotlinx.coroutines.flow.flowOf

@Composable
fun HomeRoute(
    navigationItemOnChange: (PrographyNavigationItem) -> Unit,
    itemClick: (String, String) -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val bookmarkUiState by homeViewModel.bookmarkPhoto.collectAsStateWithLifecycle()
    val photos = homeViewModel.photos.collectAsLazyPagingItems()

    Box {
        HomeScreen(
            navigationItemOnChange = navigationItemOnChange,
            itemClick = itemClick,
            bookmarkUiState = bookmarkUiState,
            photos = photos
        )
    }
}

@Composable
fun HomeScreen(
    navigationItemOnChange: (PrographyNavigationItem) -> Unit,
    itemClick: (String, String) -> Unit,
    bookmarkUiState: BookmarkUiState,
    photos: LazyPagingItems<Photo>
) {
    Scaffold(
        topBar = { PrographyAppBar() },
        bottomBar = {
            PrographyNavigationBar(
                itemOnClick = navigationItemOnChange,
                state = PrographyNavigationItem.HOME
            )
        }
    ) { paddingValue ->
        AnimatedVisibility(visible = photos.loadState.refresh == LoadState.Loading) {
            SkeletonLoadingLayout()
        }
        if (bookmarkUiState !is BookmarkUiState.Success) return@Scaffold
        val density = LocalDensity.current

        val rootLayoutPaddingPx = remember {
            with(density) { 16.dp.roundToPx() }
        }

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(vertical = 20.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
                .background(Color.White)
        ) {
            if (bookmarkUiState.data.isNotEmpty()) {
                bookmarkLayout(
                    itemClick = { itemClick(it, "bookmark") },
                    photos = bookmarkUiState.data,
                    rootLayoutPaddingPx = rootLayoutPaddingPx
                )
            }
            photoListLayout(
                itemClick = { itemClick(it, "network") },
                photos = photos
            )
        }
    }
}


fun LazyStaggeredGridScope.bookmarkLayout(
    itemClick: (String) -> Unit,
    photos: List<Photo>,
    rootLayoutPaddingPx: Int
) {
    item(
        span = StaggeredGridItemSpan.FullLine
    ) {
        Column {
            ItemTitleLayout(
                text = "북마크",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(top = 10.dp, bottom = 9.dp, start = 4.dp, end = 4.dp)
            )
            LazyRow(
                contentPadding = PaddingValues(start = 16.dp, top = 12.dp, bottom = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.ignoreParentPadding(rootLayoutPaddingPx)
            ) {
                items(
                    items = photos,
                    key = { it.id }
                ) {
                    PhotoCardView(
                        modifier = Modifier.nonReplyClick { itemClick(it.id) }
                    ) {
                        AsyncImage(
                            model = it.url.thumb,
                            contentDescription = null,
                            contentScale = ContentScale.FillHeight,
                            placeholder = previewPlaceholder(id = com.agvber.designsystem.R.drawable.photo_test_item),
                            modifier = Modifier
                                .height(128.dp)
                        )
                    }
                }
            }
        }
    }
}


fun LazyStaggeredGridScope.photoListLayout(
    itemClick: (String) -> Unit,
    photos: LazyPagingItems<Photo>
) {
    item(
        span = StaggeredGridItemSpan.FullLine
    ) {
        ItemTitleLayout(
            text = "최신 이미지",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(top = 10.dp, bottom = 21.dp, start = 4.dp, end = 4.dp)
        )
    }

    items(
        count = photos.itemCount,
        key = photos.itemKey()
    ) {
        PhotoCardView(
            text = photos[it]?.title ?: "",
            modifier = Modifier
                .padding(bottom = 10.dp)
                .nonReplyClick { photos[it]?.let { itemClick(it.id) } }
        ) {
            AsyncImage(
                model = photos[it]?.url?.thumb,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                placeholder = previewPlaceholder(id = com.agvber.designsystem.R.drawable.photo_test_item),
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PROGRAPHY_ANDROID_Theme {
        HomeScreen(
            navigationItemOnChange = { },
            itemClick = { _, _ -> },
            bookmarkUiState = BookmarkUiState.Success(FakeModel.photos),
            photos = flowOf(PagingData.from(FakeModel.photos)).collectAsLazyPagingItems()
        )
    }
}