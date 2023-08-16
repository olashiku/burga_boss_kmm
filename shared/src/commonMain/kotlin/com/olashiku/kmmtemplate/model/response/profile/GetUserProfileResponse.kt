package com.olashiku.kmmtemplate.model.response.profile

import kotlinx.serialization.Serializable

@Serializable
data class GetUserProfileResponse(
    val responsecode: String = "",
    val responsemessage: String = "",
    val address: List<Address> = emptyList(),
    val recepient: List<Receipient> = emptyList()
)

@Serializable
data class Address(
    val device_id: String = "",
    val house_number: String = "",
    val street: String = "",
    val area: String = "",
    val state: String = "",
    val land_mark: String = ""
)

@Serializable
data class Receipient(
    val customer_name: String,
    val email: String,
    val phone: String,
    val device_id: String
)
