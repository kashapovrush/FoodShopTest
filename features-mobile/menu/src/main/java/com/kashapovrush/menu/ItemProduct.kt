package com.kashapovrush.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kashapovrush.common.model.Product
import com.kashapovrush.common.viewmodel.MenuViewModel
import com.kashapovrush.palette.R

@Composable
fun ItemProduct(
    product: Product,
    viewModel: MenuViewModel,
    onClickToItemCard: () -> Unit
) {

    Card(
        modifier = Modifier
            .width(165.dp)
            .height(290.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.onSecondary)
            .clickable {
                onClickToItemCard()
            },
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
            ) {
                AsyncImage(
                    model = R.drawable.image_product,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(108.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier.width(144.dp),
                    verticalArrangement = Arrangement.Top
                ) {
                    Box(
                        modifier = Modifier
                            .width(144.dp)
                            .height(44.dp)
                    ) {
                        Column(modifier = Modifier.fillMaxSize()) {
                            Box(
                                modifier = Modifier.height(20.dp),
                                contentAlignment = Alignment.TopStart
                            ) {
                                Text(text = product.name, fontSize = 14.sp, color = Color.Black)
                            }

                            Box(
                                modifier = Modifier.height(20.dp),
                                contentAlignment = Alignment.BottomStart
                            ) {
                                Text(
                                    text = "${product.measure} ${product.measureUnit}",
                                    fontSize = 14.sp,
                                    color = Color.DarkGray
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    StateButton(
                        product = product,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}
