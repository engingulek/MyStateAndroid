package com.example.myestate.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.myestate.R

object CoilImage {
    @Composable
    fun loadImageCoil(url: String) : AsyncImagePainter {
        val painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current).data(data = url)
                .apply(block = fun ImageRequest.Builder.() {
                    placeholder(R.drawable.placeholder_image)
                }).build()
        )
        return painter
    }
}