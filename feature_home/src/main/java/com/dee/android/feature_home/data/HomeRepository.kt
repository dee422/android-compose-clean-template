package com.dee.android.feature_home.data

import com.dee.android.core.network.RetrofitClient

class HomeRepository {

    suspend fun loadData(): String {

        val response = RetrofitClient.api.test()

        if (response.code == 200) {
            return response.data ?: throw RuntimeException("data is null")
        } else {
            throw RuntimeException(response.message)
        }
    }

}
