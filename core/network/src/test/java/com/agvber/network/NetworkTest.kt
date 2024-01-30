package com.agvber.network

import com.agvber.network.di.NetworkModule.providesOkhttpCallFactory
import com.agvber.network.retrofit.RetrofitService
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkTest {

    private val networkDataSource: NetworkDataSource = RetrofitService(providesOkhttpCallFactory())

    private val testDispatcher = StandardTestDispatcher()
    @Test
    fun getPhotos() = runTest(testDispatcher) {
        printPrettyJson(networkDataSource.getPhotos())
    }

}