package com.veera.systemtaskcompose

import com.veera.systemtaskcompose.character.data.network.CharacterApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductsAPITest {

    lateinit var mockWebServer: MockWebServer
    lateinit var productsAPI: CharacterApi

    @Before
    fun setup(){
        mockWebServer = MockWebServer()
        productsAPI = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CharacterApi::class.java)
    }

    @Test
    fun testGetProducts() = runTest{
        val mockResponse = MockResponse()
        mockResponse.setBody("[]")
        mockWebServer.enqueue(mockResponse)

        val response = productsAPI.getCharacter()
        mockWebServer.takeRequest()

        Assert.assertEquals(0, response.size)
    }

    @Test
    fun testGetProducts_returnProducts() = runTest{
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(200)
        mockWebServer.enqueue(mockResponse)

        val response = productsAPI.getCharacter()
        mockWebServer.takeRequest()
        Assert.assertEquals(0, response.size)
    }

    @Test
    fun testGetProducts_returnError() = runTest{
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(404)
        mockResponse.setBody("Something went wrong")
        mockWebServer.enqueue(mockResponse)

        val response = productsAPI.getCharacter()
        mockWebServer.takeRequest()
    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }
}












