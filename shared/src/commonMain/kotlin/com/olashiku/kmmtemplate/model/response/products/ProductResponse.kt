package com.olashiku.kmmtemplate.model.response.products

import database.Products
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val responsecode: String,
    val responsemessage: String,
    val details: List<Details>
)

@Serializable
data class Details(
    val id: Long,
    val category: String,
    val name: String,
    val description: String,
    val amount: Double,
    val ingredient: List<String>
)

data class Product(
    val category: String,
    val name: String,
    val description: String,
    val amount: Double
)

fun Products.toProducts(): Product {
    return Product(
        category = this.category,
        name = this.name,
        description = this.description,
        amount = this.amount
    )
}