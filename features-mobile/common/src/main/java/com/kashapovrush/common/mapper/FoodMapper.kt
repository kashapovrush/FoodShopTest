package com.kashapovrush.common.mapper

import com.kashapovrush.common.model.Category
import com.kashapovrush.common.model.Product
import com.kashapovrush.network.modelDto.CategoryDto
import com.kashapovrush.network.modelDto.ProductDto
import javax.inject.Inject

class FoodMapper @Inject constructor(){

    fun mapCategoryDtoToCategory(dto: CategoryDto): Category {
        return Category(
            id = dto.id,
            name = dto.name
        )
    }

    fun mapCategoryToCategoryDto(category: Category): CategoryDto {
        return CategoryDto(
            id = category.id,
            name = category.name
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
}