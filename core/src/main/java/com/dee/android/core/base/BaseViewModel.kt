package com.dee.android.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dee.android.core.network.NetworkResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    protected fun <T> launchWithState(
        state: MutableStateFlow<NetworkResult<T>>,
        block: suspend () -> T
    ) {
        viewModelScope.launch {
            state.value = NetworkResult.Loading

            try {
                val result = block()
                state.value = NetworkResult.Success(result)
            } catch (e: Exception) {
                state.value = NetworkResult.Error(e.message ?: "Unknown error")
            }
        }
    }
}

