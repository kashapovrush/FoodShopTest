package com.kashapovrush.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kashapovrush.common.model.Category

@Composable
fun ItemCategory(category: Category, state: State<Int>, onChangedCategory: () -> Unit) {


    val modifier = if (state.value == category.id) {
        Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .padding(start = 12.dp, end = 12.dp)
            .wrapContentWidth()
            .height(40.dp)
    } else {
        Modifier
            .padding(start = 12.dp, end = 12.dp)
            .wrapContentWidth()
            .height(40.dp)
    }
    Box(
        modifier = modifier
            .clickable { onChangedCategory() },
        contentAlignment = Alignment.Center
    ) {
        val colorText = if (state.value == category.id) Color.White else Color.Black
        Text(text = category.name, fontSize = 16.sp, color = colorText)
    }
}
