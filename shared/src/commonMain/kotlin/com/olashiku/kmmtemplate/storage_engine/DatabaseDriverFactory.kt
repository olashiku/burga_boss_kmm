package com.olashiku.kmmtemplate.storage_engine

import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory{
     fun createDriver(): SqlDriver
}