package com.example.weatherapp.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherapp.screens.main.MainViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.notes.shared.CustomAppbar
import com.example.notes.shared.utils.formatDate
import com.example.notes.shared.utils.formatDecimal
import com.example.weatherapp.R
import com.example.weatherapp.data.DataOrException
import com.example.weatherapp.model.WeatherModel
import com.example.weatherapp.screens.main.widget.RowWidget
import com.example.weatherapp.screens.main.widget.SunsetSunriseWidget
import com.example.weatherapp.screens.main.widget.YellowCircle

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel = hiltViewModel()) {
    val  weatherModel = produceState<DataOrException<WeatherModel, Boolean, Exception>>(initialValue = DataOrException(isLoading = true)) {
        value = viewModel.getWeatherData("Lagos")
    }.value

    if(weatherModel.isLoading == true){
        CircularProgressIndicator()
    }  else if(weatherModel.data != null){

        ShowData(weatherModel.data!!, navController)
    }else{
        Text("An error occured")
    }


}


@Composable
fun ShowData(weatherModel: WeatherModel, navController: NavController){

        Scaffold (
            topBar = {
                CustomAppbar(
                    title = weatherModel.city.name, backgroundColor = Color.White, elevation = 3.dp,
                    navController = navController,
                        isMainScreen = true,
                    onMoreClicked = {
                            Pop()
                    }

                ){

                }
            }
                ){

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 10.dp, horizontal = 20.dp)

                    ){
                        Text(
                            formatDate(weatherModel.list[0].dt), style = TextStyle(
                            fontWeight = FontWeight.Bold
                        ))
                            Spacer(modifier = Modifier.height(10.dp))
                        YellowCircle(weatherModel)
                        Spacer(modifier = Modifier.height(15.dp))
                        RowList(weatherModel)
                        Divider()
                        Spacer(modifier = Modifier.height(15.dp))
                        SunList(weatherModel)

                        Text("This week")




        }
}


}






@Preview
@Composable
fun WeeklyReport(){
//    val imageUrl = "https://openweathermap.org/img/wn/${weatherModel.list[0].weather[0].icon}.png"
    val imageUrl = "https://openweathermap.org/img/wn/09d.png"
    Card(
        modifier = Modifier
            .height(height = 80.dp)
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 10.dp)

            .clip(shape = RoundedCornerShape(topEnd = 20.dp, bottomStart = 20.dp, topStart = 20.dp, bottomEnd = 20.dp)),

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
//                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
           Text(text = "Thur",
               style = MaterialTheme.typography.h6,
               fontSize = 16.sp
           )

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


            Surface(
                color = Color(0xFFF1C950),

                    modifier = Modifier.padding(5.dp)
                        .clip(shape= RoundedCornerShape(size = 10.dp))
            ) {
                Text("Light Rain",
                    style = MaterialTheme.typography.body2.copy(fontSize = 10.sp),
                    modifier = Modifier
                        .padding(4.dp)
                )
            }


            Row(){
                Text("45",
                    style = MaterialTheme.typography.h6,
                    color = Color(0xffFF6200EE)
                )
                Spacer(modifier = Modifier.width(7.dp))
                Text("43",
                    style = MaterialTheme.typography.h6,
                    color = Color.LightGray
                    )
            }

        }

    }

}



@Composable
fun  SunList(weatherModel: WeatherModel){
    val weatherItem = weatherModel.list[0]
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        SunsetSunriseWidget(image = R.drawable.sunrise, text = formatDate(weatherItem.sunrise), isSunset = false)
        SunsetSunriseWidget(image = R.drawable.sunset, text = formatDate(weatherItem.sunset), isSunset = true)

    }
}



@Composable
fun RowList(weatherModel: WeatherModel){
    val weatherItem = weatherModel.list[0]
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        RowWidget(image = R.drawable.humidity, text = "${weatherItem.humidity}%")
        RowWidget(image = R.drawable.pressure, text = "${weatherItem.pressure} psi")
        RowWidget(image = R.drawable.wind, text = "Humidity")

    }
}

@Composable
fun Pop() {

    val expanded = remember {
        mutableStateOf(false)
    }
    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false }
    ) {
        DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
            Text("Refresh")
        }
        DropdownMenuItem(onClick = { /* Handle settings! */ }) {
            Text("Settings")
        }
        Divider()
        DropdownMenuItem(onClick = { /* Handle send feedback! */ }) {
            Text("Send Feedback")
        }
    }
}