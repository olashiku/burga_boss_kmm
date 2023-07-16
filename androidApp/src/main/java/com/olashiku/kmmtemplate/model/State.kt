package com.olashiku.kmmtemplate.model

import kotlinx.serialization.Serializable

data class State(
    val loadingState: Boolean = false,
    val response: Any? = null,
    val errorMessage: String = ""
)




