package com.waether.app.features.randomizer

import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test



class RandomizerViewModelTest{

    @JvmField
    @Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `init then update numberLiveData value to DEFAULT_VALUE`(){

        // Arrange
        // Act
        val viewModel = RandomizerViewModel()


        // Assert
        val result = viewModel.numberLiveData.value
        Assert.assertTrue(result == DEFAULT_VALUE)

    }

    @Test
    fun `incrementNumber when numberLiveData value is zero then update numberLiveData value to one`(){

        // Arrange
        val viewModel = RandomizerViewModel()
        viewModel.numberLiveData.value = 0

        // Act
        viewModel.incrementNumber()

        // Assert
        val result = viewModel.numberLiveData.value
        Assert.assertTrue(result == 1)
    }


}