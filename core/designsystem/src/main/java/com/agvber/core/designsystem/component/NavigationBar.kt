package com.agvber.core.designsystem.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.agvber.core.designsystem.nonReplyClick
import com.agvber.core.designsystem.theme.Black90
import com.agvber.core.designsystem.theme.PROGRAPHY_ANDROID_Theme
import com.agvber.core.designsystem.R

@Composable
fun PrographyNavigationBar(
    itemOnClick: (PrographyNavigationItem) -> Unit,
    state: PrographyNavigationItem,
    modifier: Modifier = Modifier,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,
) {
    Surface(color = Black90) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .windowInsetsPadding(windowInsets)
                .height(NavigationBarHeight)
                .padding(horizontal = 94.dp)
                .selectableGroup(),
            horizontalArrangement = Arrangement.spacedBy(
                NavigationBarItemHorizontalPadding,
                Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .nonReplyClick {
                        itemOnClick(PrographyNavigationItem.HOME)
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_house_white),
                    contentDescription = null,
                    tint = animateNavigationButtonColor(
                        state == PrographyNavigationItem.HOME
                    )
                )
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .nonReplyClick {
                        itemOnClick(PrographyNavigationItem.RANDOM_PHOTO)
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_card_white),
                    contentDescription = null,
                    tint = animateNavigationButtonColor(
                        state == PrographyNavigationItem.RANDOM_PHOTO
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun CustomNavigationBarPreview() {
    PROGRAPHY_ANDROID_Theme {
        var state by remember { mutableStateOf(PrographyNavigationItem.HOME) }
        PrographyNavigationBar(
            itemOnClick = { state = it },
            state = state
        )
    }
}

@Composable
private fun animateNavigationButtonColor(enable: Boolean) =
    animateColorAsState(
        targetValue = if (enable) {
            Color(0xFFFFFFFF)
        } else {
            Color(0xFF646464)
        }
    ).value

private val NavigationBarHeight: Dp = 52.dp
private val NavigationBarItemHorizontalPadding: Dp = 83.dp

enum class PrographyNavigationItem {
    HOME, RANDOM_PHOTO
}