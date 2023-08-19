package com.olashiku.kmmtemplate.model.response.products

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val responsecode: String,
    val responsemessage: String,
    val details: List<Details>
)

@Serializable
data class Details(
    val id: Int,
    val category: String,
    val name:String,
    val description:String,
    val amount:String,
    val ingredient:List<String>
)