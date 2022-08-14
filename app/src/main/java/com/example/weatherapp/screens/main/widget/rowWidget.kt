package com.example.weatherapp.screens.main.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R

@Composable
fun RowWidget(image: Int = R.drawable.humidity, text:String = "humidity"){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image( painter = painterResource(image), contentDescription = image.toString(),
            modifier = Modifier.size(15.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(text =text,
            style = MaterialTheme.typography.caption,
            fontSize = 15.sp
        )
    }
}