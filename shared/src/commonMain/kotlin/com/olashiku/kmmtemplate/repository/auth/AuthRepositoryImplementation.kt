package com.olashiku.kmmtemplate.repository.auth

import com.olashiku.kmmtemplate.model.request.register.RegisterRequest
import com.olashiku.kmmtemplate.model.request.validate_user.ValidateUserRequest
import com.olashiku.kmmtemplate.model.response.register.RegisterResponse
import com.olashiku.kmmtemplate.model.response.validate_user.ValidateUserResponse
import com.olashiku.kmmtemplate.network_engine.BaseNetworkRepository
import com.olashiku.kmmtemplate.network.EndPoints
import com.olashiku.kmmtemplate.network_engine.NetworkResult

class AuthRepositoryImplementation:BaseNetworkRepository(),AuthenticationRepository {

    override suspend fun register(registerRequest: RegisterRequest): NetworkResult<RegisterResponse> {
      return  makeNetworkCallAndRetrieveData(registerRequest, EndPoints.REGISTER_USER){it.responsecode.equals("00")}
    }

    override suspend fun validateUser(validateUserRequest: ValidateUserRequest): NetworkResult<ValidateUserResponse> {
        return  makeNetworkCallAndRetrieveData(validateUserRequest, EndPoints.VALIDATE_USER){it.responsecode.equals("00")}
    }

}