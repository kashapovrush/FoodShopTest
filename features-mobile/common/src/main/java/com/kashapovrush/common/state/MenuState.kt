package com.kashapovrush.common.state

import com.kashapovrush.common.model.Category
import com.kashapovrush.common.model.Product

sealed class MenuState() {


    object Loading : MenuState()

    data class ResultCategories(
        val listCategories: List<Category>
    ) : MenuState()

    data class Error(val message: String) : MenuState()
}
