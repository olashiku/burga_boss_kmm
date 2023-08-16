package com.olashiku.kmmtemplate.viewModel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.SavedStateHandle
import com.olashiku.kmmtemplate.android.resource.Strings
import com.olashiku.kmmtemplate.base.BaseViewModel
import com.olashiku.kmmtemplate.model.ProductDetails
import com.olashiku.kmmtemplate.model.request.profile.GetUserProfileRequest
import com.olashiku.kmmtemplate.model.response.profile.GetUserProfileResponse
import com.olashiku.kmmtemplate.repository.user.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow

class UserViewModel(
    private val userRepository: UserRepository, private val saveStateHandle: SavedStateHandle
) : BaseViewModel(saveStateHandle) {

    val burgerData = MutableStateFlow(listOf<ProductDetails>())


init {
        getProductByCategory()
}
    fun registerUser(deviceId: String) {
        val request = GetUserProfileRequest(deviceId)
        makePostRequest(request, userRepository::getUserProfile)
    }

     fun getProductByCategory(productCategory:String = Strings.burger) {
     val data =    ProductDetails().getProducts().filter { it.category.equals(productCategory) }
         burgerData.value = data
     }

}