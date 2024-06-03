package com.example.colorconquest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.colorconquest.datastore.HighScore
import com.example.colorconquest.ui.theme.ColorConquestTheme

@Composable
fun MainPage(navController: NavController){
    val painter6= painterResource(id = R.drawable.winner)
    val painter7= painterResource(id = R.drawable.glass)
    val context= LocalContext.current
    val preferencesManager = remember { HighScore(context) }
    val data = remember { mutableStateOf(preferencesManager.getData("myKey", "")) }
    ColorConquestTheme(theme) {
        val fontFamily= FontFamily(
            Font(R.font.leckerlione_regular, FontWeight.Bold)
        )
        val painter= painterResource(id = R.drawable.mainpageicon)
        Box(modifier= Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    listOf(Color(255, 194, 113, 255), Color(255, 96, 109, 255))
                )
            )
        )
        Column() {
            Spacer(modifier = Modifier.padding(vertical = 50.dp))
            Text(
                text = "COLOR",
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontSize = 70.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = fontFamily,
                    brush = Brush.verticalGradient(
                        listOf(Color(0, 0, 0, 240), Color(0, 0, 0, 180))
                    )
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(vertical= 13.dp))
            Text(
                text = "CONQUEST",
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-25).dp),
                style = TextStyle(
                    fontSize = 70.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = fontFamily,
                    brush = Brush.verticalGradient(
                        listOf(Color(0, 0, 0, 200), Color(0, 0, 0, 5))
                    )
                ),
                textAlign = TextAlign.Center
            )
        }
        Box(contentAlignment = Alignment.TopEnd) {
            Column {
                Switch(checked = theme, onCheckedChange = {theme=!theme}, colors = SwitchDefaults.colors(
                    uncheckedThumbColor = Color.LightGray,
                    uncheckedTrackColor = Color.White,
                    checkedThumbColor = Color.Black,
                    checkedTrackColor = Color.DarkGray,
                ), modifier = Modifier.padding(20.dp)
                )
            }
        }
        Box(contentAlignment = Alignment.TopStart, modifier = Modifier.padding(20.dp)){
            Button(
                onClick = { ad=6 },
                shape = CircleShape,
                modifier= Modifier
                    .shadow(8.dp, CircleShape)
                    .size(75.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff2A0547)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 4.dp
                )
            ) {}
            Image(painter = painter6, contentDescription = null,modifier= Modifier
                .size(60.dp)
                .offset(x = 8.dp, y = 9.dp))
        }
        val highscore = remember { "$cwinner        $highScore                $fastTime" }
        if (fastTime != -1) {
            preferencesManager.saveData("myKey", highscore)
            data.value = highscore
        }

        val savedHighScore = if (fastTime != -1) {
            preferencesManager.getData("myKey", highscore)
        } else {
            ""
        }
        Box(modifier = Modifier.alpha(0.7f)){
            if (fastTime!==(-1)){
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(255, 194, 113, 255)
                    ),
                    modifier = Modifier
                        .size(width = 373.dp, height = 75.dp)
                        .offset(x = 15.dp, y = 587.dp)
                        .alpha(0.6f)
                ){}
                Column(modifier = Modifier
                    .fillMaxSize()
                    .offset(y = 600.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "NAME   HIGH SCORE   FASTEST TIME", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color.Black)
                    Text(text = savedHighScore, fontSize = 20.sp, modifier = Modifier.offset(x=-(29).dp), color = Color.Black)
                }
            }
        }

        Image(painter = painter, contentDescription = "", modifier = Modifier.offset(y=78.dp))

        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .padding(bottom = 58.dp)
                .offset(x = (-15).dp)
        ) {
            Button(
                onClick = {
                    navController.navigate("second_page")
                },
                modifier= Modifier
                    .height(77.dp)
                    .width(213.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff2fb6f0)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 4.dp
                )
            ) {
                Text(text = "PLAY", fontSize = 35.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSecondary)
            }
        }
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.padding(bottom = 58.dp)
        ) {
            Button(
                onClick = {
                    ad=1
                },
                shape = CircleShape,
                modifier = Modifier
                    .size(66.dp)
                    .offset(x = 155.dp, y = (-4).dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff3b4276)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 4.dp
                )
            ) {
                Text(text = "?", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onPrimary)
            }
        }
    }
    }