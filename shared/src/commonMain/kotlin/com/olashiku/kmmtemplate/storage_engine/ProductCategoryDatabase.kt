package com.olashiku.kmmtemplate.storage_engine

import com.olashiku.kmmtemplate.shared.cache.BurgaBossDatabase
import com.squareup.sqldelight.db.SqlDriver
import database.Products


class ProductCategoryDatabase(sqlDriver: SqlDriver) {
    private val database = BurgaBossDatabase(sqlDriver)
    private val dbQuery = database.burgaBossDatabaseQueries


    fun clearProductsDatabase() {
        dbQuery.transaction {
            dbQuery.deleteProducts()
        }
    }

    fun getAllProducts(): List<Products> {
        return dbQuery.getAllProducts().executeAsList()
    }


    fun insertProducts(
        product_id: Long, category: String, name: String,
        description: String, amount: Long
    ) {
        dbQuery.insertProducts(product_id, category, name, description, amount)
    }
}