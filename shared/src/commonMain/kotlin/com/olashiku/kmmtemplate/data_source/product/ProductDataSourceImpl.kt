package com.olashiku.kmmtemplate.data_source.product

import com.olashiku.kmmtemplate.model.response.products.Details
import com.olashiku.kmmtemplate.model.response.products.Product
import com.olashiku.kmmtemplate.model.response.products.toProducts
import com.olashiku.kmmtemplate.shared.cache.BurgaBossDatabase
import com.olashiku.kmmtemplate.storage_engine.DatabaseDriverFactory

class ProductDataSourceImpl(databaseDriverFactory: DatabaseDriverFactory) : ProductDataSource {

    val database = BurgaBossDatabase(databaseDriverFactory.createDriver())
    val query = database.burgaBossDatabaseQueries


    override suspend fun createProducts(products: List<Details>) {
        deleteProduct()
        database.transaction {
            afterRollback { println("_______products no product was inserted") }
            afterCommit { println("_______products ${products.size} players were inserted.") }

            products.forEach {
                query.insertProduct(
                  it.id,
                    it.category,
                    it.name,
                    it.description,
                   it.amount
                )
            }
        }


    }

    override suspend fun deleteProduct() {
        query.deleteProducts()
    }

    override suspend fun getAllProduct(): List<Product> {
        return query.getAllProducts().executeAsList().map { it.toProducts() }
    }
}