package com.olashiku.kmmtemplate.repository.user

import com.olashiku.kmmtemplate.model.request.profile.GetUserProfileRequest
import com.olashiku.kmmtemplate.model.response.profile.GetUserProfileResponse
import com.olashiku.kmmtemplate.network.EndPoints
import com.olashiku.kmmtemplate.network_engine.BaseNetworkRepository
import com.olashiku.kmmtemplate.network_engine.NetworkResult

class UserRepositoryImplementation(): BaseNetworkRepository(),UserRepository {
    override suspend fun getUserProfile(request: GetUserProfileRequest): NetworkResult<GetUserProfileResponse> {
        return  makeNetworkCallAndRetrieveData(request, EndPoints.GET_USER_PROFILE){it.responsecode.equals("00")}
    }
}