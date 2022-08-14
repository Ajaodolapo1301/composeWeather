
package com.example.notes.shared

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherapp.navigation.AppScreens


@Composable
fun CustomAppbar(
    title:String?,
    elevation: Dp = 0.dp,
    backgroundColor: Color =  Color.Transparent,
    icon : ImageVector? = null,
    navController: NavController,
    isMainScreen : Boolean = false,
    onMoreClicked:  @Composable  () -> Unit = {},
    onButtonClick: ()-> Unit = {}



) {


    TopAppBar(title = {
        Text(text = title ?: "")
    },
        actions = {
                    if(isMainScreen){
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search icon",
                            modifier = Modifier.clickable {

                            }
                                .padding(horizontal = 8.dp)

                        )


                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More icon",
                            modifier = Modifier.clickable {
                                    onMoreClicked
                            }
                                .padding(horizontal = 8.dp)
                        )
                    }

    },

    backgroundColor = backgroundColor,
        navigationIcon = {
            if(icon != null){
                    Icon(imageVector = icon, contentDescription = icon.toString(),
                        modifier = Modifier.clickable {
                                navController.popBackStack()
                        }

                    )
//
        }
        },
        elevation = elevation

    )
//    TopAppBar(
//        elevation = elevation,
//
//
//        backgroundColor =  backgroundColor,
//
//
//
//    ) {
//            Row(
//               modifier = Modifier
//                   .fillMaxWidth()
//                   .padding(4.dp)
//                ,
//                horizontalArrangement = Arrangement.SpaceBetween) {
//                if (showbackButton){
//                    Icon(
//
//
//                        imageVector = Icons.Default.ArrowBack, contentDescription = "back button", modifier = Modifier.clickable {
//                            backButton()
//                        })
//                }
//
//                Text(text = title ?: "")
//
//                if(action != null){
//                    Icon(imageVector = action, contentDescription = action.toString())
//                }
//
//            }
//    }
}