package com.olashiku.kmmtemplate.repository.user

import com.olashiku.kmmtemplate.model.request.profile.GetUserProfileRequest
import com.olashiku.kmmtemplate.model.response.profile.GetUserProfileResponse
import com.olashiku.kmmtemplate.network_engine.NetworkResult

interface UserRepository {
  suspend  fun getUserProfile(request: GetUserProfileRequest):NetworkResult<GetUserProfileResponse>
}