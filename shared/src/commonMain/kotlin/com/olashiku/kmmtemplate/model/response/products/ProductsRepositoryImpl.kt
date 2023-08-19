package com.olashiku.kmmtemplate.model.response.products

import com.olashiku.kmmtemplate.network.EndPoints
import com.olashiku.kmmtemplate.network_engine.BaseNetworkRepository
import com.olashiku.kmmtemplate.network_engine.NetworkResult
import com.olashiku.kmmtemplate.repository.products.ProductsRepository

class ProductsRepositoryImpl:BaseNetworkRepository(), ProductsRepository {

    override suspend fun getProducts(): NetworkResult<ProductResponse> {
       return runGetRequest(EndPoints.GET_PRODUCTS,{it.responsecode == "00" })
    }
}