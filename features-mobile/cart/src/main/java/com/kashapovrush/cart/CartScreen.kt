package com.kashapovrush.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CartScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .width(343.dp)
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = com.kashapovrush.palette.R.drawable.arrowback),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(24.dp))

                Text(
                    text = "Корзина",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            LazyColumn {
                items(20) {
                    ItemProductInCart()
                }
            }


        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp, vertical = 1.dp)
        ) {
            Button(
                onClick = {

                }, modifier = Modifier
                    .height(48.dp)
                    .width(343.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
            ) {
                Text(
                    text = "В корзину за ₽",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

        }
    }

}

@Composable
fun ItemProductInCart() {
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .height(130.dp)
            .padding(17.dp)
    ) {

        Image(
            modifier = Modifier.size(96.dp),
            painter = painterResource(id = com.kashapovrush.palette.R.drawable.image_product),
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(24.dp))

        Column(modifier = Modifier.fillMaxSize()) {

            Text(text = "Том Ям", fontSize = 14.sp, modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = com.kashapovrush.palette.R.drawable.minus),
                    contentDescription = null,
                    modifier = Modifier.size(46.dp)
                )

                Text(
                    text = "1",
                    modifier = Modifier.width(40.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )

                Image(
                    painter = painterResource(id = com.kashapovrush.palette.R.drawable.plus),
                    contentDescription = null,
                    modifier = Modifier.size(46.dp)
                )

                Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
                    Text(
                        text = "100 ₽",
                        fontSize = 16.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "200 ₽",
                        color = Color.LightGray,
                        textDecoration = TextDecoration.LineThrough,
                        textAlign = TextAlign.Center
                    )
                }
            }

        }
    }
}