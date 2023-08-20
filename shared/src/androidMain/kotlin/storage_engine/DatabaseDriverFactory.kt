package com.olashiku.kmmtemplate.storage_engine

import android.content.Context
import com.olashiku.kmmtemplate.shared.cache.BurgaBossDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.logs.LogSqliteDriver

actual class DatabaseDriverFactory(private val context:Context) {
    actual fun createDriver():SqlDriver{
        return AndroidSqliteDriver(BurgaBossDatabase.Schema, context, "burgaboss.db")
    }
}