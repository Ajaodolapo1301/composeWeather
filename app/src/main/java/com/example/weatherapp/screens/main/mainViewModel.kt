package com.example.weatherapp.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.repository.WeatherRepository
import com.example.weatherapp.data.DataOrException
import com.example.weatherapp.model.WeatherModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository) :  ViewModel(){


    suspend fun getWeatherData(city: String):DataOrException<WeatherModel, Boolean, Exception>{
        return weatherRepository.getWeatherData(query= city)
    }

}