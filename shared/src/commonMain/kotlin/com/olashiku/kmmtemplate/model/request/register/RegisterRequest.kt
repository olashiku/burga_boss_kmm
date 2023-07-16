package com.olashiku.kmmtemplate.model.request.register

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    val firstName:String,
    val lastName:String,
    val email:String,
    val phone:String,
    val password:String,
    val deviceId:String
)