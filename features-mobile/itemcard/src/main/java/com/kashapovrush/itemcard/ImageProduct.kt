package com.kashapovrush.itemcard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kashapovrush.palette.R

@Composable
fun ImageProduct(popBackStack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(375.dp)
    ) {
        ButtonBack(popBackStack)
        Image(
            painter = painterResource(id = R.drawable.image_product),
            contentDescription = null
        )
    }
}