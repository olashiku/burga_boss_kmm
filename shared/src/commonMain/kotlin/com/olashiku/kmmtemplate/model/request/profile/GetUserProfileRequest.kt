package com.olashiku.kmmtemplate.model.request.profile

import kotlinx.serialization.Serializable

@Serializable
data class GetUserProfileRequest(
    val deviceId:String
)