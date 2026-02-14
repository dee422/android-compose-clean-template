package com.dee.android.feature_home.ui

import androidx.lifecycle.viewModelScope
import com.dee.android.core.base.BaseViewModel
import com.dee.android.core.network.NetworkResult
import com.dee.android.feature_home.data.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class HomeViewModel : BaseViewModel() {

    private val repository = HomeRepository()

    private val _uiState =
        MutableStateFlow<NetworkResult<String>>(NetworkResult.Loading)

    val uiState: StateFlow<NetworkResult<String>> = _uiState


    fun loadData() {
        launchWithState(_uiState) {
            repository.loadData()
        }
    }

}

