package com.veera.SystemTask.repository

import com.veera.systemtaskcompose.character.data.api.CharacterApi
import com.veera.systemtaskcompose.character.data.api.model.Character
import com.veera.systemtaskcompose.character.data.repository.CharacterRepo
import kotlinx.coroutines.test.runTest
import org.junit.Assert

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ProductRepositoryTest {

    @Mock
    lateinit var productsAPI: CharacterApi

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testGetProducts_EmptyList() = runTest {
        Mockito.`when`(productsAPI.getCharacter()).thenReturn(emptyList())
        val sut = CharacterRepo(productsAPI)
        val result = sut.getCharacters()
        Assert.assertEquals(0, result.size)
    }

    @Test
    fun testGetProducts_expectedProductList() = runTest {
        val productList = listOf<Character>(
            Character("Prod 1", true, "", "", "", "","","",""),
            Character("Prod 2", true, "", "", "", "","","",""),
        )
        Mockito.`when`(productsAPI.getCharacter()).thenReturn(productList)

        val sut = CharacterRepo(productsAPI)
        val result = sut.getCharacters()
        Assert.assertEquals(0, result.size)
        Assert.assertEquals("Prod 1", result[0].actor)
    }

}