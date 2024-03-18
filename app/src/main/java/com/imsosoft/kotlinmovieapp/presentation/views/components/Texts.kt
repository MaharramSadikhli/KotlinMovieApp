package com.imsosoft.kotlinmovieapp.presentation.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ErrorText(text: String) {

    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = text,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 36.sp,
            lineHeight = 44.sp,
            letterSpacing = 0.7.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
                .align(Alignment.Center)
        )
    }

}

@Composable
fun TitleText(text: String) {
    Text(
        text = text,
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        letterSpacing = 0.7.sp,
        lineHeight = 44.sp,
        textAlign = TextAlign.Center,
        color = Color.White,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun YearText(text: String) {
    Text(
        text = text,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        lineHeight = 38.sp,
        textAlign = TextAlign.Center,
        color = Color.White,
        overflow = TextOverflow.Ellipsis,
    )
}