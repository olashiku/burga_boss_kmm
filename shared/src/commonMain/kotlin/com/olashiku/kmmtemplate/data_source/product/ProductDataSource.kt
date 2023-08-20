package com.olashiku.kmmtemplate.data_source.product

import com.olashiku.kmmtemplate.model.response.products.Details
import com.olashiku.kmmtemplate.model.response.products.Product

interface ProductDataSource {
  suspend  fun createProducts(products:List<Details>)
  suspend  fun deleteProduct()
   suspend fun getAllProduct(): List<Product>
}