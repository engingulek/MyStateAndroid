package com.example.myestate.utils

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.withContext
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun Context.getStringResource(resId: Int): String {
    return this.getString(resId)
}

@Composable
fun getStringRes(resId: Int): String {
    val context = LocalContext.current
    return context.getStringResource(resId)
}


fun Long.toFormatPrice() : String {
    val symbols = DecimalFormatSymbols(Locale.getDefault())
    symbols.groupingSeparator = '.'
    val format = DecimalFormat("#,###", symbols)
    val formatedValue = format.format(this)
    return formatedValue
}