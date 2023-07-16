package com.olashiku.kmmtemplate.model.request.validate_user

import kotlinx.serialization.Serializable

@Serializable
data class ValidateUserRequest(
   val token:String,
   val uniqueRef:String,
   val deviceId:String
)
