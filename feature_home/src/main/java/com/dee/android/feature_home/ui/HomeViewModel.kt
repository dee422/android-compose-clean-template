package com.dee.android.feature_home.ui

import com.dee.android.core.base.BaseViewModel
import com.dee.android.core.base.UiState
import com.dee.android.feature_home.data.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class HomeViewModel : BaseViewModel() {

    private val repository = HomeRepository()

    private val _uiState =
        MutableStateFlow<UiState<String>>(UiState.Loading)

    val uiState: StateFlow<UiState<String>> = _uiState

    fun loadData() {
        launchWithUiState(_uiState) {
            repository.loadData()
        }
    }
}

