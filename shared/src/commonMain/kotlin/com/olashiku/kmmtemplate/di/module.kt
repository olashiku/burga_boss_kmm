package com.olashiku.kmmtemplate.di

import org.koin.core.module.Module


expect fun platformModule(): Module
fun appModule() = listOf(networkModule, repositoryModule, dataSourceModule,platformModule())
