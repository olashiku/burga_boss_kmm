package com.olashiku.kmmtemplate.viewModel

import androidx.lifecycle.SavedStateHandle
import com.olashiku.kmmtemplate.base.BaseViewModel
import com.olashiku.kmmtemplate.model.request.register.RegisterRequest
import com.olashiku.kmmtemplate.model.request.validate_user.ValidateUserRequest
import com.olashiku.kmmtemplate.model.response.register.RegisterResponse
import com.olashiku.kmmtemplate.model.response.validate_user.ValidateUserResponse
import com.olashiku.kmmtemplate.repository.auth.AuthenticationRepository
import com.olashiku.kmmtemplate.utils.toJson

class AuthenticationViewModel(
    private val authenticationRepository: AuthenticationRepository,
    private val saveStateHandle: SavedStateHandle) : BaseViewModel(saveStateHandle) {

    /** response */
    private val registerResponse = saveStateHandle.getStateFlow("registerResponse", RegisterResponse.toJson())
    private val validateCustomerResponse = saveStateHandle.getStateFlow("validateCustomerResponse", ValidateUserResponse.toJson())

    /** states */
    val registerUserState =  registerActiveState(registerResponse)
    val validateUserState = registerActiveState(validateCustomerResponse)


    fun registerUser(){
        val request = RegisterRequest("", "","","","","")
       makePostRequest(request, authenticationRepository::register)
    }

     fun validateUser(){
         val request = ValidateUserRequest("","","")
         makePostRequest(request, authenticationRepository::validateUser)
     }

}