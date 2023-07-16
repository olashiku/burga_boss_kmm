package com.olashiku.kmmtemplate.viewModel

import androidx.lifecycle.SavedStateHandle
import com.olashiku.kmmtemplate.base.BaseViewModel
import com.olashiku.kmmtemplate.model.request.profile.GetUserProfileRequest
import com.olashiku.kmmtemplate.model.response.profile.GetUserProfileResponse
import com.olashiku.kmmtemplate.repository.user.UserRepository

class UserViewModel(
    private val userRepository: UserRepository, private val saveStateHandle: SavedStateHandle
) : BaseViewModel(saveStateHandle) {

    /** response */
    private val getUserProfileResponse = saveStateHandle.getStateFlow("getUserProfileResponse", GetUserProfileResponse)

    /** state */
    val registerUserState = registerActiveState(getUserProfileResponse)


    fun registerUser(deviceId:String) {
        val request = GetUserProfileRequest(deviceId)
        makePostRequest(request, userRepository::getUserProfile)
    }


}