package com.olashiku.kmmtemplate.repository.auth

import com.olashiku.kmmtemplate.model.request.register.RegisterRequest
import com.olashiku.kmmtemplate.model.request.validate_user.ValidateUserRequest
import com.olashiku.kmmtemplate.model.response.register.RegisterResponse
import com.olashiku.kmmtemplate.model.response.validate_user.ValidateUserResponse
import com.olashiku.kmmtemplate.network_engine.NetworkResult

interface AuthenticationRepository {
    suspend fun register(registerRequest: RegisterRequest): NetworkResult<RegisterResponse>
    suspend fun validateUser(validateUserRequest: ValidateUserRequest): NetworkResult<ValidateUserResponse>
}