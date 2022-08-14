package com.example.notes.shared.utils

import android.annotation.SuppressLint
import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*


class UUIDConverter{


    @TypeConverter
        fun fromUUid(uuid: UUID) :String{
            return uuid.toString()
        }

    @TypeConverter
    fun uuidFromString(string: String): UUID? {
        return UUID.fromString(string)
    }
}


fun formatDate(timeStamp: Int) : String{
    val sdf = SimpleDateFormat("EEE, MMM d")

    var date = java.util.Date(timeStamp.toLong() * 1000)
    return  sdf.format(date)
}


fun formatDecimal(item: Double): String {
    return  " %.0f".format(item)
}



@SuppressLint("SimpleDateFormat")
fun formatTime(timeStamp: Int) : String{
    val sdf = SimpleDateFormat("hh:mm:aa")

    var date = java.util.Date(timeStamp.toLong() * 1000)
    return  sdf.format(date)
}