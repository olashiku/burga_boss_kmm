package com.olashiku.kmmtemplate.di

import com.olashiku.kmmtemplate.viewModel.AuthenticationViewModel
import com.olashiku.kmmtemplate.viewModel.ProductsViewModel
import com.olashiku.kmmtemplate.viewModel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

 val viewModelModule = module {
     viewModel { AuthenticationViewModel( get(),it.get()) }
     viewModel{UserViewModel(get(),it.get())}
     viewModel{ProductsViewModel(get(),it.get())}
 }