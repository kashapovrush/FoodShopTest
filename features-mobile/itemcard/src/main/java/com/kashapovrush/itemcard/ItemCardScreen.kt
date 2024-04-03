package com.kashapovrush.itemcard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kashapovrush.common.model.Product
import com.kashapovrush.navigation.NavigationState

@Composable
fun ItemCardScreen(product: Product, navigationState: NavigationState) {

    val scrollState = rememberScrollState()

    Column(modifier = Modifier.background(Color.White)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .verticalScroll(scrollState)
        ) {

            ImageProduct {
                navigationState.popBackStack()
            }
            Spacer(modifier = Modifier.height(24.dp))
            TitleWithDescription(product)
            Spacer(modifier = Modifier.height(24.dp))

            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = Color.LightGray,
                thickness = 1.dp
            )

            ItemNutritionalValue(title = "Вес", value = "${product.measure} ${product.measureUnit}")
            ItemNutritionalValue(title = "Энерг. ценность", value = "${product.carbohydrates} ккал. ")
            ItemNutritionalValue(title = "Белки", value = "${product.proteins} г")
            ItemNutritionalValue(title = "Жиры", value = "${product.fats} г")
            ItemNutritionalValue(title = "Углеводы", value = "${product.energy} г")
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp, vertical = 1.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.primary)

        ) {
            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .height(48.dp)
                    .width(343.dp)
            ) {
                Text(
                    text = "В корзину за ${(product.priceCurrent) / 100} ₽",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

        }
    }
}






