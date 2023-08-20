package com.olashiku.kmmtemplate.storage_engine

import com.olashiku.kmmtemplate.shared.cache.BurgaBossDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.squareup.sqldelight.logs.LogSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver():SqlDriver{
     return   LogSqliteDriver(sqlDriver= NativeSqliteDriver(BurgaBossDatabase.Schema, "burgaboss.db")) {log ->
         println(log)
        }
    }
}