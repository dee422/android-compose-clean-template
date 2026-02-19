package com.dee.android.feature_home.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dee.android.core.base.BaseFragment
import com.dee.android.feature_home.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment :
    BaseFragment<HomeViewModel, String>(R.layout.fragment_home) {

    override val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeState(viewModel.uiState)
        viewModel.loadData()
    }

    override fun onLoading() {
        Log.d("HomeFragment", "Loading...")
    }

    override fun onSuccess(data: String?) {
        Log.d("HomeFragment", "Success: $data")
    }

    override fun onError(message: String?) {
        Log.e("HomeFragment", "Error: $message")
    }
}
