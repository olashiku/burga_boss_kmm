package com.olashiku.kmmtemplate.repository.products

import com.olashiku.kmmtemplate.model.response.products.Product
import com.olashiku.kmmtemplate.model.response.products.ProductResponse
import com.olashiku.kmmtemplate.network_engine.NetworkResult
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProducts(): NetworkResult<ProductResponse>
   suspend fun getSavedProduct(): List<Product>
}