package com.kashapovrush.menu

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kashapovrush.common.model.Product
import com.kashapovrush.common.model.ProductInCart
import com.kashapovrush.common.viewmodel.MenuViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun StateButton(
    product: Product,
    viewModel: MenuViewModel
) {


    val stateCounter = remember {
        mutableIntStateOf(0)
    }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {

//        if (item.count == 0) {
            Button(
                shape = RoundedCornerShape(8.dp),
                onClick = {

                    viewModel.addPaymentItem(ProductInCart(
                        id = product.id,
                        name = product.name,
                        priceCurrent = product.priceCurrent,
                        count = 1,
                        priceOld = product.priceOld
                    ))
                },
                modifier = Modifier
                    .width(144.dp)
                    .height(40.dp),
                border = BorderStroke(0.dp, Color.White),
                colors = ButtonDefaults.outlinedButtonColors(Color.White)
            ) {

                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (product.priceOld != 0) {
                        Text(
                            text = "${product.priceCurrent / 100} ₽",
                            fontSize = 16.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "${product.priceOld / 100} ₽",
                            color = Color.LightGray,
                            textDecoration = TextDecoration.LineThrough,
                            textAlign = TextAlign.Center
                        )
                    } else {
                        Text(
                            text = "${product.priceCurrent / 100} ₽",
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                }
            }


//
//        } else {
//            Row(
//                modifier = Modifier
//                    .width(144.dp)
//                    .height(40.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Image(
//                    painter = painterResource(id = com.kashapovrush.palette.R.drawable.minus),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(40.dp)
//                        .clickable {
//                            if (stateCounter.intValue != 1) {
//                                viewModel.addPaymentItem(ProductInCart(
//                                    id = product.id,
//                                    name = product.name,
//                                    priceCurrent = product.priceCurrent,
//                                    priceOld = product.priceOld,
//                                    count = stateCounter.intValue
//                                ))
//                            } else {
//                                stateCounter.intValue = 0
//                            }
//
//                        }
//                )
//                Text(text = "${stateCounter.intValue}", modifier = Modifier
//                    .height(30.dp)
//                    .weight(1f), textAlign = TextAlign.Center, fontSize = 16.sp, color = Color.Black)
//                Image(
//                    painter = painterResource(id = com.kashapovrush.palette.R.drawable.plus),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(40.dp)
//                        .clickable {
//                            stateCounter.intValue += 1
//
//                            viewModel.addPaymentItem(ProductInCart(
//                                id = product.id,
//                                name = product.name,
//                                priceCurrent = product.priceCurrent,
//                                priceOld = product.priceOld,
//                                count = stateCounter.intValue
//                            ))
//                        }
//                )
//
//            }
//        }
    }
}