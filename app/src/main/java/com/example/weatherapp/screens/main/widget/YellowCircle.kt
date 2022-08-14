package com.example.weatherapp.screens.main.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.notes.shared.utils.formatDecimal
import com.example.weatherapp.model.WeatherModel

@Composable
fun YellowCircle(weatherModel: WeatherModel){
    val imageUrl = "https://openweathermap.org/img/wn/${weatherModel.list[0].weather[0].icon}.png"
    val weatherItem = weatherModel.list[0]

    Surface(
        modifier = Modifier
            .size(200.dp),

        shape = CircleShape,
        color = Color(0xFFF1C950)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "List of movie images",

                contentScale = ContentScale.Fit,

                modifier = Modifier

                    .size(80.dp)
                    .padding(10.dp)


            )
            Text( formatDecimal(weatherItem.temp.day) + "º" , style = MaterialTheme.typography.h5, fontWeight = FontWeight.Bold)
            Text(weatherItem.weather[0].main, style = MaterialTheme.typography.h6, fontSize = 15.sp)
        }
    }
}