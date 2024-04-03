package com.kashapovrush.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kashapovrush.palette.R

@Composable
fun TopLine(paddingValues: PaddingValues) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(paddingValues),
        verticalAlignment = Alignment.Bottom
    ) {
        Box(
            modifier = Modifier
                .height(44.dp)
                .width(44.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                imageVector = Icons.Filled.Menu,
                contentDescription = null,
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .height(44.dp)
        ) {
            AsyncImage(
                model = R.drawable.logo_orange,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )

        }

        Box(
            modifier = Modifier
                .height(44.dp)
                .width(44.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
            )

        }
    }
}
