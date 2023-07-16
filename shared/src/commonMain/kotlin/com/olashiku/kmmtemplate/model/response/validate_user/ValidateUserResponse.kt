package com.olashiku.kmmtemplate.model.response.validate_user

import kotlinx.serialization.Serializable

@Serializable
data class ValidateUserResponse(
    val responsecode:String,
    val responsemessage:String
)