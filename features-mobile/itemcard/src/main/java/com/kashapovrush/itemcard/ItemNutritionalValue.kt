package com.kashapovrush.itemcard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemNutritionalValue(title: String, value: String) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title, modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(), fontSize = 16.sp,
                color = Color.DarkGray
            )
            Text(text = value, fontSize = 16.sp)


        }
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray, thickness = 1.dp)

    }

}
