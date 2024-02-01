package com.agvber.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.agvber.designsystem.component.PhotoCardView
import com.agvber.designsystem.shimmerLoadingAnimation
import com.agvber.designsystem.theme.PROGRAPHY_ANDROID_Theme

@Composable
fun SkeletonLoadingLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp, start = 16.dp)
        ) {
            val width = listOf<Dp>(
                160.dp, 100.dp, 146.dp
            )
            width.forEach {
                PhotoCardView {
                    Box(
                        modifier = Modifier
                            .size(width = it, height = 128.dp)
                            .shimmerLoadingAnimation()
                    )
                }
            }
        }
        val height = listOf<Dp>(
            172.dp, 246.dp, 200.dp, 268.dp, 168.dp, 248.dp, 100.dp
        )
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(top = 80.dp, start = 16.dp, end = 16.dp),
            verticalItemSpacing = 10.dp,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            userScrollEnabled = false
        ) {
            items(items = height) {
                PhotoCardView {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(it)
                        .shimmerLoadingAnimation()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SkeletonLoadingLayoutPreview() {
    PROGRAPHY_ANDROID_Theme {
        SkeletonLoadingLayout()
    }
}