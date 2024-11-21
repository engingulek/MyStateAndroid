package com.example.myestate.ui.components

import android.accounts.Account
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object ButtonComponents {
    @Composable
    fun AccountButton(title:String,
                      backColor:Color,
                      textColor:Color
                      ) {
        Button(
            onClick = {println("Button clicked!")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = backColor,
                contentColor = textColor
            )
        ) {
            Text(text = title)
        }
    }
}