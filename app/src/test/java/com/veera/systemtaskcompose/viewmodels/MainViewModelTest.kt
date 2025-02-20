package com.veera.SystemTask.viewmodels

import com.veera.systemtaskcompose.character.data.repository.CharacterRepo
import com.veera.systemtaskcompose.character.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.*

import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest {
    private val testDispatcher = StandardTestDispatcher()
    @Mock
    lateinit var repository: CharacterRepo

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun test_GetProducts() = runTest{
        Mockito.`when`(repository.getCharacters()).thenReturn(emptyList())

        val sut = HomeViewModel(repository)
        sut.state
        testDispatcher.scheduler.advanceUntilIdle()
        val result = sut.state.value
        Assert.assertEquals(0, result.size)
    }

    @Test
    fun test_GetProduct_expectedError() = runTest{
        Mockito.`when`(repository.getCharacters()).thenReturn(emptyList())
        val sut = HomeViewModel(repository)
        sut.state
        testDispatcher.scheduler.advanceUntilIdle()
        val result = sut.state.value
        Assert.assertEquals(0, result.size)
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}












