package com.olashiku.kmmtemplate.di

import com.olashiku.kmmtemplate.storage_engine.DatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { DatabaseDriverFactory(get()).createDriver() }
}
