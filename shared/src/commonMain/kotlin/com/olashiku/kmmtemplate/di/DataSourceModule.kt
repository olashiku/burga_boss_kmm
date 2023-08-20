package com.olashiku.kmmtemplate.di


import com.olashiku.kmmtemplate.data_source.product.ProductDataSource
import com.olashiku.kmmtemplate.data_source.product.ProductDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<ProductDataSource> { ProductDataSourceImpl(get()) }
}