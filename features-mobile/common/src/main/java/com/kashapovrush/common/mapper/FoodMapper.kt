package com.kashapovrush.common.mapper

import com.kashapovrush.common.model.Category
import com.kashapovrush.common.model.Product
import com.kashapovrush.common.model.ProductInCart
import com.kashapovrush.database.ProductInCartDb
import com.kashapovrush.network.modelDto.CategoryDto
import com.kashapovrush.network.modelDto.ProductDto
import javax.inject.Inject

class FoodMapper @Inject constructor() {

    fun mapCategoryDtoToCategory(dto: CategoryDto): Category {
        return Category(
            id = dto.id,
            name = dto.name
        )
    }

    fun mapCategoryDtoListToCategoryList(list: List<CategoryDto>): List<Category> {
        return list.map {
            mapCategoryDtoToCategory(it)
        }
    }

    fun mapProductDtoToProduct(dto: ProductDto): Product {
        return Product(
            id = dto.id,
            name = dto.name,
            description = dto.description,
            categoryId = dto.categoryId,
            image = dto.image,
            energy = dto.energy,
            fats = dto.fats,
            priceCurrent = dto.priceCurrent,
            priceOld = dto.priceOld,
            proteins = dto.proteins,
            carbohydrates = dto.carbohydrates,
            measure = dto.measure,
            measureUnit = dto.measureUnit
//            tags = dto.tags
        )
    }

    fun mapProductDtoListToProductList(list: List<ProductDto>): List<Product> {
        return list.map {
            mapProductDtoToProduct(it)
        }
    }

    fun mapProductInCartDbToProductInCart(db: ProductInCartDb): ProductInCart {
        return ProductInCart(
            id = db.id,
            name = db.name,
            count = db.count,
            priceCurrent = db.priceCurrent,
            priceOld = db.priceOld
        )
    }

    fun mapProductInCartToProductInCartDb(product: ProductInCart): ProductInCartDb {
        return ProductInCartDb(
            id = product.id,
            name = product.name,
            count = product.count,
            priceCurrent = product.priceCurrent,
            priceOld = product.priceOld
        )
    }

    fun mapProductInCartDbListToProductInCartList(
        list: List<ProductInCartDb>
    ): List<ProductInCart> {
        return list.map {
            mapProductInCartDbToProductInCart(it)
        }
    }
}