package com.example.weatherapp.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherapp.R
import com.example.weatherapp.navigation.AppScreens
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
        val scale = remember {
                androidx.compose.animation.core.Animatable(0f)
        }

        LaunchedEffect(key1 = true, block = {
                scale.animateTo(targetValue = 0.9f,
                animationSpec = tween(durationMillis = 800, easing = {
                        OvershootInterpolator(8f)
                                .getInterpolation(it)
                } )
                        )

                delay(1000L)
                        navController.navigate(AppScreens.MainScreen.name)
        }

        )

        Column(
                modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
                Surface(

                        modifier = Modifier
                                .size(300.dp)
                                .scale(scale.value),
                        shape = CircleShape,
                        border = BorderStroke(width = 1.dp, color = Color.Gray),

                        ) {
                        Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                                Image(painter = painterResource(R.drawable.sun), contentDescription = "Sunset", modifier = Modifier.size(95.dp))
                                Text("Find the Sunset", style = MaterialTheme.typography.h5, color = Color.LightGray)
                        }
                }
        }
}