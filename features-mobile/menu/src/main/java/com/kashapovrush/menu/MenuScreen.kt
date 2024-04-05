package com.kashapovrush.menu

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import com.kashapovrush.common.state.MenuState
import com.kashapovrush.common.viewmodel.MenuViewModel
import com.kashapovrush.database.ProductDao
import com.kashapovrush.navigation.NavigationState
import com.kashapovrush.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MenuScreen(
    viewModel: MenuViewModel,
    owner: LifecycleOwner,
    navigationState: NavigationState
) {

    Log.d("MainActivityTest", "Recomposition menu screen")

    CoroutineScope(Dispatchers.IO).launch {
        viewModel.getCategories()
        viewModel.getProducts()
    }


    val state = viewModel.state.observeAsState()
    val currentState = state.value

    val categoryState = remember {
        mutableStateOf("Горячие блюда")
    }

    val enabledCategory = remember {
        mutableIntStateOf(8)
    }


    when (currentState) {
        is MenuState.ResultCategories -> {
            Scaffold(Modifier.fillMaxSize()) { paddingValues ->
                Column {
                    Column(modifier = Modifier.weight(1f)) {
                        TopLine(paddingValues) {
                            navigationState.navigateTo(Screen.CartScreen.route)
                        }
                        LazyRow(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .fillMaxWidth()
                                .height(40.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(items = currentState.listCategories, key = { category ->
                                category.id
                            }) { category ->


                                ItemCategory(category, enabledCategory) {
                                    enabledCategory.intValue = category.id
                                    categoryState.value = category.name
                                }
                            }
                        }
                        val product = viewModel.products.observeAsState(mutableListOf())


                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            items(product.value.filter { product ->
                                product.categoryId == mapCategoryStringToCategoryInt(
                                    categoryState.value
                                )
                            }) { product ->
                                ItemProduct(product = product, viewModel = viewModel) {
                                    navigationState.navigateToItemCardScreen(product)
                                }


                            }
                        }

                        viewModel.error.observe(owner) {
                            Log.d("MainActivityTest", "error $it")
                        }

                    }


                    if (false) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(72.dp)
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
                                    text = "₽₽₽",
                                    fontSize = 16.sp,
                                    color = Color.White
                                )
                            }

                        }

                    }
                }

            }
        }

        is MenuState.Error -> {

        }

        is MenuState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Color.Black)
            }

        }

        null -> {

        }
    }

    BackHandler {

    }
}

fun mapCategoryIntToCategoryString(category: Int): String {
    return when (category) {
        676168 -> "Горячие блюда"
        676154 -> "Суши"
        676155 -> "Соусы"
        676161 -> "Детское меню"
        676172 -> "Подарочные сертификаты"
        676159 -> "Напитки"
        676153 -> "Горячие закуски"
        676164 -> "Готовим дома"
        676162 -> "Средства индивидуальной защиты"
        676173 -> "Салаты"
        676156 -> "Супы"
        676165 -> "Десерты"
        676166 -> "Вок"
        676151 -> "Бургеры"
        676167 -> "Роллы"
        676169 -> "Наборы"
        676170 -> "Сашими"
        676171 -> "Половинки роллов"
        676157 -> "Сувениры"
        676163 -> "Бизнес ланчи"
        676160 -> "Фестиваль гёдза"
        676158 -> "Мероприятия"
        else -> ""
    }
}

fun mapCategoryStringToCategoryInt(category: String): Int {
    return when (category) {
        "Горячие блюда" -> 676168
        "Суши" -> 676154
        "Соусы" -> 676155
        "Детское меню" -> 676161
        "Подарочные сертификаты" -> 676172
        "Напитки" -> 676159
        "Горячие закуски" -> 676153
        "Готовим дома" -> 676164
        "Средства индивидуальной защиты" -> 676162
        "Салаты" -> 676173
        "Супы" -> 676156
        "Десерты" -> 676165
        "Вок" -> 676166
        "Бургеры" -> 676151
        "Роллы" -> 676167
        "Наборы" -> 676169
        "Сашими" -> 676170
        "Половинки роллов" -> 676171
        "Сувениры" -> 676157
        "Бизнес ланчи" -> 676163
        "Фестиваль гёдза" -> 676160
        "Мероприятия" -> 676158
        else -> 0
    }
}



