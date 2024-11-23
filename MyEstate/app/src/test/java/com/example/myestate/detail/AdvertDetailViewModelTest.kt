package com.example.myestate.detail

import com.example.myestate.R
import com.example.myestate.ui.screens.detail.AdvertDetailViewModel
import com.example.myestate.ui.screens.detail.AdvertDetailViewModelInterface
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class AdvertDetailViewModelTest {
    private lateinit var viewModel : AdvertDetailViewModelInterface

    @Before
    fun setup(){
        viewModel = AdvertDetailViewModel()
    }

    @Test
    fun `when open splash screen ,return text of titles and buttons `(){
        val state = viewModel.state.value
        
        //Titles
        assertEquals(R.string.advertInfo,state.advertInfoTitle)
        assertEquals(R.string.description,state.descriptionTitle)
    }


}