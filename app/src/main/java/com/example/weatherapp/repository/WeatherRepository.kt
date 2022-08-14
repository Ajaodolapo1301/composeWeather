package com.example.quiz.repository

import android.util.Log
import com.example.weatherapp.data.DataOrException
import com.example.weatherapp.model.WeatherModel
import com.example.weatherapp.network.WeatherApi
import retrofit2.http.Query

import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api : WeatherApi,) {


    suspend fun getWeatherData(query: String):DataOrException<WeatherModel, Boolean, Exception> {
        val response =  try {
                    api.getWeatherData(query = query)


                }catch (e: Exception) {
            Log.d("TAG", "getWeatherData: $e")
                 return   DataOrException(exception = e)

                }
        Log.d("TAG", "getWeatherData: $response")
       return DataOrException(data = response )
    }

}