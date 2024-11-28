package com.example.myestate.detail

import com.example.myestate.R
import com.example.myestate.ui.screens.detail.AdvertDetailService
import com.example.myestate.ui.screens.detail.AdvertDetailViewModel
import com.example.myestate.ui.screens.detail.AdvertDetailViewModelInterface
import com.example.myestate.utils.getStringRes
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class AdvertDetailViewModelTest {
    private lateinit var viewModel: AdvertDetailViewModelInterface
    private lateinit var service : AdvertDetailService

    @Before
    fun setup() {
        viewModel = AdvertDetailViewModel(service)
    }

    @Test
    fun `when open splash screen ,return text of titles and buttons `() {
        val state = viewModel.state.value

        //Titles
        assertEquals(R.string.advertInfo, state.advertInfoTitle)
        assertEquals(R.string.description, state.descriptionTitle)
        assertEquals(R.string.price, state.price)
        assertEquals(R.string.advertId, state.advertId)
        assertEquals(R.string.estateType, state.estateType)
        assertEquals(R.string.advertDate, state.advertDate)
        assertEquals(R.string.age, state.age)
        assertEquals(R.string.Floors, state.floors)
        
    }
}