package com.example.myestate.utils

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.withContext

fun Context.getStringResource(resId: Int): String {
    return this.getString(resId)
}

@Composable
fun getStringRes(resId: Int): String {
    val context = LocalContext.current
    return context.getStringResource(resId)
}