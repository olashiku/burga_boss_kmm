package com.olashiku.kmmtemplate.di

import com.olashiku.kmmtemplate.model.response.products.ProductsRepositoryImpl
import com.olashiku.kmmtemplate.repository.auth.AuthRepositoryImplementation
import com.olashiku.kmmtemplate.repository.auth.AuthenticationRepository
import com.olashiku.kmmtemplate.repository.products.ProductsRepository
import com.olashiku.kmmtemplate.repository.user.UserRepository
import com.olashiku.kmmtemplate.repository.user.UserRepositoryImplementation
import org.koin.dsl.module

val repositoryModule = module {
    single <AuthenticationRepository> { AuthRepositoryImplementation() }
    single <UserRepository>{ UserRepositoryImplementation() }
    single <ProductsRepository>{ProductsRepositoryImpl()  }
}