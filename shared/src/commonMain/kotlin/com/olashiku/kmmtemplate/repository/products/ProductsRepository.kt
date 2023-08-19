package com.olashiku.kmmtemplate.repository.products

import com.olashiku.kmmtemplate.model.response.products.ProductResponse
import com.olashiku.kmmtemplate.network_engine.NetworkResult

interface ProductsRepository {
    suspend fun getProducts(): NetworkResult<ProductResponse>
}