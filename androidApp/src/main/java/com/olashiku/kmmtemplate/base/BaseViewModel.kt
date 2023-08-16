package com.olashiku.kmmtemplate.base

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olashiku.kmmtemplate.model.State
import com.olashiku.kmmtemplate.network_engine.NetworkResult
import com.olashiku.kmmtemplate.utils.toJson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


open class BaseViewModel( val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val loader = savedStateHandle.getStateFlow("isLoading", false)
    private val error = savedStateHandle.getStateFlow("errorMessage", "")

    fun <T:Any>registerActiveState( response: StateFlow<T>): StateFlow<State> {
       return   combine(response, error, loader) { response, error, loader ->
            State(
                response = response,
                errorMessage = error,
                loadingState = loader
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), State())
    }


    fun <R : Any, T : Any> makePostRequest(
        request: R,
        apiCall: suspend (request: R) -> NetworkResult<T>,
        getError: (response: T) -> Unit, response:(T)->Unit, getException:(String)->Unit,
        isLoading: (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                isLoading(true)
                apiCall(request)
            }
            isLoading(false)
            when (result) {
                is NetworkResult.Success<*> -> {
                    response(result.data as T)
                }
                is NetworkResult.Errror -> {
                    getException(result.exception.message.toString())
                }
                is NetworkResult.Failed<*> -> {
                    getError(result.message as T)
                }
                else -> {}
            }
        }
    }

    fun <R : Any, T : Any> makePostRequest(
        request: R,
        apiCall: suspend (request: R) -> NetworkResult<T>) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                savedStateHandle["isLoading"] = true
                apiCall(request)
            }
            savedStateHandle["isLoading"] = false
            when (result) {
                is NetworkResult.Success<*> -> {
                    savedStateHandle["response"] = result.data.toJson()
                }
                is NetworkResult.Errror -> {
                    savedStateHandle["errorMessage"] = result.exception.message.toString()
                }
                is NetworkResult.Failed<*> -> {
                    savedStateHandle["errorMessage"] = result.message
                }
                else -> {}
            }
        }
    }


    fun <T : Any> makeGetRequest(
        apiCall: suspend () -> NetworkResult<T>,
        getError: (response: T) -> Unit,
        response:(T)->Unit,
        getException:(String)->Unit,
        isLoading: (Boolean) -> Unit

    ) {
        runBlocking {
            val result = withContext(Dispatchers.IO) {
                isLoading(true)
                apiCall()
            }
            isLoading(false)
            when (result) {
                is NetworkResult.Success<*> -> {
                    response(result.data as T)
                }
                is NetworkResult.Errror -> {
                    getException(result.exception.message.toString())
                }
                is NetworkResult.Failed<*> -> {
                    getError(result.message as T)
                }
                else -> {}
            }
        }
    }


}