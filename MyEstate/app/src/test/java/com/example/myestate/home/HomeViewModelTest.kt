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
    private lateinit var service: MockHomeService

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
    fun `when open home screen ,return estaTypeUi not error `() = runTest{
        val state = viewModel.estateTypeUi.value
        assertEquals(state.error.second,false)
        assertEquals(state.error.first,R.string.empty)
    }

    @Test
    fun `when open home screen ,return categoryUi not error `() = runTest{
        val state = viewModel.categoryUi.value
        assertEquals(state.error.second,false)
        assertEquals(state.error.first,R.string.empty)
    }

    @Test
    fun `when open home screen ,return estaTypeUi error `() {
        service.estateTypeError = true
        val state = viewModel.estateTypeUi.value

        assertEquals(state.error.second,true)
        assertEquals(state.error.first,R.string.errorMessage)
    }

    @Test
    fun `when open home screen ,return categoryUi error `() {
        service.categoryError = true
        val state = viewModel.categoryUi.value


        assertEquals(state.error.second,true)
        assertEquals(state.error.first,R.string.errorMessage)
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
    fun `when open home screen ,return categoryUi `() = runTest{
        val state = viewModel.categoryUi.value

        assertEquals(state.title,R.string.categories)

        state.list.forEach { category ->
            if (category.id == 1){
                assertEquals(category.backColor,0xFF0000FF)
                assertEquals(category.textColor,0xFFFFFFFF)
            }else{
                assertEquals(category.backColor,0xFFFFFFFF)
                assertEquals(category.textColor,0xFF52607D)
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

    @Test
    fun `when click category ,return estaTypeUi `() = runTest{

        viewModel.onAction(HomeContract.UiAction.clickedCategory(3))
        val state = viewModel.categoryUi.value
        
        state.list.forEach { category ->
            if (category.id == 3){
                assertEquals(category.backColor,0xFF0000FF)
                assertEquals(category.textColor,0xFFFFFFFF)
            }else{
                assertEquals(category.backColor,0xFFFFFFFF)
                assertEquals(category.textColor,0xFF52607D)
            }
        }
    }
}