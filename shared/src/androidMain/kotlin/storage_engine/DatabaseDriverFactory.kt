package com.olashiku.kmmtemplate.storage_engine

import android.content.Context
import android.database.DatabaseUtils
import com.olashiku.kmmtemplate.shared.cache.BurgaBossDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context:Context) {
    actual fun createDriver():SqlDriver{
        return AndroidSqliteDriver(BurgaBossDatabase.Schema, context, "test.db")
    }
}