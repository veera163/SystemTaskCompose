package com.veera.SystemTask.repository

import com.veera.systemtaskcompose.character.data.network.CharacterApi
import com.veera.systemtaskcompose.character.data.repository.CharacterRepo
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert

import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductAPITest {

    lateinit var mockWebServer: MockWebServer
    lateinit var apiService: CharacterApi


    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CharacterApi::class.java)
    }

    @Test
    fun testGetProducts_EmptyList() = runTest {
        val mockResponse = MockResponse()
        mockWebServer.enqueue(
            mockResponse
                .setResponseCode(404)
        )
        val sut = CharacterRepo(apiService)
        val result = sut.getCharacters()
        val request = mockWebServer.takeRequest()
        Assert.assertEquals(0, result.size)
    }

}