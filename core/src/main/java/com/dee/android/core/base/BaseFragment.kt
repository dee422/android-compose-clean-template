package com.dee.android.core.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment<VM : BaseViewModel, T>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    protected abstract val viewModel: VM

    protected fun observeState(state: StateFlow<UiState<T>>) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                state.collect { result ->
                    when (result) {
                        is UiState.Loading -> onLoading()
                        is UiState.Success -> onSuccess(result.data)
                        is UiState.Error -> onError(result.message)
                        is UiState.Empty -> onEmpty()
                    }
                }
            }
        }
    }

    open fun onLoading() {}
    open fun onSuccess(data: T?) {}
    open fun onError(message: String?) {}
    open fun onEmpty() {}
}
