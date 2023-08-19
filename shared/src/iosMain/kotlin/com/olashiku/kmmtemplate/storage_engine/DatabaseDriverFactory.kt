package com.olashiku.kmmtemplate.storage_engine

import com.olashiku.kmmtemplate.shared.cache.BurgaBossDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver():SqlDriver{
        return  NativeSqliteDriver(BurgaBossDatabase.Schema,"burgaboss.db")
    }
}