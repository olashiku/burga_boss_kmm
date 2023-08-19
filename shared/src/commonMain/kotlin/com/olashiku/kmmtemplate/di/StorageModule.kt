package com.olashiku.kmmtemplate.di


import com.olashiku.kmmtemplate.storage_engine.ProductCategoryDatabase
import org.koin.dsl.module

val storageModule = module {
    single{ ProductCategoryDatabase(get()) }
}