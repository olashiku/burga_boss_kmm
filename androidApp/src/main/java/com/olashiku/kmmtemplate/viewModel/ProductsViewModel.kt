package com.olashiku.kmmtemplate.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.olashiku.kmmtemplate.android.resource.Strings
import com.olashiku.kmmtemplate.base.BaseViewModel
import com.olashiku.kmmtemplate.model.ProductDetails
import com.olashiku.kmmtemplate.model.response.products.Details
import com.olashiku.kmmtemplate.model.response.products.Product
import com.olashiku.kmmtemplate.model.response.products.ProductResponse
import com.olashiku.kmmtemplate.model.response.register.RegisterResponse
import com.olashiku.kmmtemplate.repository.products.ProductsRepository
import com.olashiku.kmmtemplate.utils.fromJson
import com.olashiku.kmmtemplate.utils.toJson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProductsViewModel(
    val productsRepository: ProductsRepository,
    savedStateHandle: SavedStateHandle
) : BaseViewModel(savedStateHandle) {

    val burgerData = MutableStateFlow(listOf<Details>())

    private val registerResponse =
        savedStateHandle.getStateFlow("productResponse", ProductResponse.toJson())
    val productState = registerActiveState(registerResponse)


    init {
        makeGetRequest(productsRepository::getProducts)
    }

    fun getProducts(category: String) {
        viewModelScope.launch {
        val result = productsRepository.getSavedProduct().filter {
                it.category.equals(category, ignoreCase = true)
            }
            println(result)
        }
    }

}