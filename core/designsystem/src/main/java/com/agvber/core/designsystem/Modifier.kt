package com.agvber.core.designsystem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.layout
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.offset

fun Modifier.nonReplyClick(
    enabled: Boolean = true,
    role: Role? = null,
    onClick: () -> Unit,
) = composed {
    this.clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = null,
        enabled = enabled,
        role = role,
        onClick = onClick
    )
}

fun Modifier.ignoreParentPadding(offsetPx: Int): Modifier =
    layout { measurable, constraints ->
        val looseConstraints = constraints.offset(offsetPx * 2, 0)
        val placeable = measurable.measure(looseConstraints)
        layout(placeable.width, placeable.height) {
            placeable.placeRelative(0, 0)
        }
    }