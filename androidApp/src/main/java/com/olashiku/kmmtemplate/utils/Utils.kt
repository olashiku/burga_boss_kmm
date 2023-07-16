package com.olashiku.kmmtemplate.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay


object Utils {
    @Composable
    fun WaitFor(waitingTime: Long = 3000, action: () -> Unit) {
        LaunchedEffect(Unit) {
         delay(waitingTime)
            action.invoke()
        }

    }
}