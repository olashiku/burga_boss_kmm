package com.olashiku.kmmtemplate.di

import com.olashiku.kmmtemplate.network_engine.NetworkConfiguration
import org.koin.dsl.module

val networkModule = module {
 single { NetworkConfiguration() }
}