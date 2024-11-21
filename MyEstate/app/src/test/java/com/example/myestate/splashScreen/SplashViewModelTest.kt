package com.example.myestate.splashScreen

import com.example.myestate.R
import com.example.myestate.ui.screens.SplashViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class SplashViewModelTest {

    private lateinit var viewModel:SplashViewModel

    @Before
    fun setup(){
        viewModel = SplashViewModel()
    }

    @Test
    fun `when open splash screen ,return text of titles and buttons `(){
        val state = viewModel.state.value

        //Titles
        assertEquals(R.string.appName,state.appTitle)
        assertEquals(R.string.defaultSlogan,state.subTitle)

        //Buttons
        /// Email Button
        assertEquals(R.string.email,state.emailButtonType.text)
        assertEquals( 0xFF000000,state.emailButtonType.backColor)
        assertEquals( 0xFFFFFFFF,state.emailButtonType.textColor)

        /// Google Button
        assertEquals(R.string.google,state.googleButtonType.text)
        assertEquals(0xFFFF0000,state.googleButtonType.backColor)
        assertEquals(0xFFFFFFFF,state.googleButtonType.textColor)

    }
}