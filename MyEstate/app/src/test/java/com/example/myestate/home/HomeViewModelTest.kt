package com.example.myestate.home

import com.example.myestate.ui.screens.home.HomeViewModel
import com.example.myestate.ui.screens.home.HomeViewModelInterface
import org.junit.Before
import org.junit.Test
import junit.framework.TestCase.assertEquals
import com.example.myestate.R

class HomeViewModelTest {
    private lateinit var viewModel: HomeViewModelInterface

    @Before
    fun setup(){
        viewModel = HomeViewModel()
    }

    @Test
    fun `when open home screen ,return text of titles and buttons `(){
        val state = viewModel.state.value

        //Titles
        assertEquals(R.string.categories,state.categoryTitle)
    }
}