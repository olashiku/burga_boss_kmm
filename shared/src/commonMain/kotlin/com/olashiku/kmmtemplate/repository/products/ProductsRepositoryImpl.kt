package com.olashiku.kmmtemplate.repository.products

import com.olashiku.kmmtemplate.data_source.product.ProductDataSource
import com.olashiku.kmmtemplate.model.response.products.Product
import com.olashiku.kmmtemplate.model.response.products.ProductResponse
import com.olashiku.kmmtemplate.network.EndPoints
import com.olashiku.kmmtemplate.network_engine.BaseNetworkRepository
import com.olashiku.kmmtemplate.network_engine.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class ProductsRepositoryImpl(val productDataSource: ProductDataSource) : BaseNetworkRepository(),
    ProductsRepository {

    override suspend fun getProducts(): NetworkResult<ProductResponse> {
        return runGetRequestWithData(
            EndPoints.GET_PRODUCTS,
            { it.responsecode == "00" },
            ::saveProducts
        )
    }

    override suspend fun getSavedProduct(): List<Product> {
        return withContext(Dispatchers.Unconfined) {
            productDataSource.getAllProduct()
        }
    }

    fun saveProducts(response: ProductResponse) {

        runBlocking(Dispatchers.Default) {
            productDataSource.createProducts(response.details)
        }

    }
}