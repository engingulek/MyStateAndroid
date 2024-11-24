package com.example.myestate.home

import com.example.myestate.ui.screens.home.HomeViewModel
import com.example.myestate.ui.screens.home.HomeViewModelInterface
import org.junit.Before
import org.junit.Test
import com.example.myestate.ui.screens.home.HomeServiceInterface
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.myestate.R
import com.example.myestate.ui.screens.home.HomeContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.launch


import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After

import org.junit.Rule
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    var instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()



    private lateinit var viewModel: HomeViewModelInterface
    private lateinit var service: HomeServiceInterface

    @Before
    fun setup(){
        Dispatchers.setMain(Dispatchers.Unconfined)
        service = MockHomeService()
        viewModel = HomeViewModel(service)

    }

    @After
    fun tearDown() {

    }


    @Test
    fun `when open home screen ,return estaTypeUi `() = runTest{
        val state = viewModel.estateTypeUi.value

        assertEquals(state.title,R.string.estateType)

        state.list.forEach { estateType ->
            if (estateType.id == 1){
                assertEquals(estateType.backColor,0xFF0000FF)
                assertEquals(estateType.textColor,0xFFFFFFFF)
            }else{
                assertEquals(estateType.backColor,0xFFFFFFFF)
                assertEquals(estateType.textColor,0xFF52607D)
            }
        }


    }


    @Test
    fun `when click estateType ,return estaTypeUi `() = runTest{

        viewModel.onAction(HomeContract.UiAction.clickedEstateType(2))
        val state = viewModel.estateTypeUi.value


        state.list.forEach { estateType ->
            if (estateType.id == 2){
                assertEquals(estateType.backColor,0xFF0000FF)
                assertEquals(estateType.textColor,0xFFFFFFFF)
            }else{
                assertEquals(estateType.backColor,0xFFFFFFFF)
                assertEquals(estateType.textColor,0xFF52607D)
            }
        }

    }
}