package com.olashiku.kmmtemplate.model.response.register

import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponse(
    val responsecode:String,
    val responsemessage:String,
    val uniqueref:String
)