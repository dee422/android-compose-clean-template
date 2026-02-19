package com.dee.android.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    protected fun <T> launchWithUiState(
        state: MutableStateFlow<UiState<T>>,
        block: suspend () -> T
    ) {
        viewModelScope.launch {
            state.value = UiState.Loading

            try {
                val result = block()

                if (result == null) {
                    state.value = UiState.Empty
                } else {
                    state.value = UiState.Success(result)
                }

            } catch (e: Exception) {
                state.value = UiState.Error(e.message)
            }
        }
    }

}

