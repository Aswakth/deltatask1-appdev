@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.colorconquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.colorconquest.datastore.StorePref
import com.example.colorconquest.datastore.StoreWins
import com.example.colorconquest.ui.theme.ColorConquestTheme
import kotlinx.coroutines.launch
import android.content.Context as Context1

var player1 by mutableStateOf("aswakth")

var player2 by mutableStateOf("balaji")

var score1 by mutableStateOf(0)

var score2 by mutableStateOf(0)

var values = mutableStateListOf(0)

var selecteditems = mutableStateListOf(-1)
var Player1Boxes = mutableStateListOf(-1)
var Player2Boxes = mutableStateListOf(-1)
var grid=5
var PlayerTurn by mutableStateOf(1)
var Boxes = mutableStateListOf(0)
var s=1
var winnerList = mutableStateListOf("")
var ad by mutableStateOf(0)
var l1=0
var l2=0
var choice by  mutableStateOf(0)
var timeLeft1 by mutableStateOf(30)
var timeLeft2 by mutableStateOf(30)
var stopTimer by mutableStateOf(false)
val list2= listOf("1","3","5","7")
var selectedSeries by  mutableStateOf(list2[1])
val list1= listOf("3","4","5","6","7")
var selectedGrid by mutableStateOf(list1[2])
var winner by mutableStateOf("")
var series=3
var timerProgress1 by mutableStateOf(1f)
var timerProgress2 by mutableStateOf(1f)
var losersList = mutableStateListOf("")
var theme by mutableStateOf(false)
var r1=0
var r2=0
var power1 by mutableStateOf(0)
var power2 by mutableStateOf(0)
var p1 by mutableStateOf(0)
var p2 by mutableStateOf(0)
var fastTime by mutableStateOf(-1)
var cwinner by mutableStateOf("")
var highScore by mutableStateOf(0)
var originalWinnerList = mutableListOf<String>("")
var wins = mutableListOf<Int>(-1)
var previousLoser by mutableStateOf(0)
var animatedList = mutableListOf(-1)
    class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorConquestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    remember {
                        player1
                        player2
                        score1
                        score2
                        values
                        selecteditems
                        Player2Boxes
                        Player1Boxes
                        PlayerTurn
                        winnerList
                        ad
                        choice
                        timeLeft1
                        timeLeft2
                        stopTimer
                        selectedSeries
                        winner
                        series
                        timerProgress2
                        timerProgress1
                        theme
                        losersList
                        power1
                        power2
                        p1
                        p2
                        fastTime
                        cwinner
                        highScore
                        originalWinnerList
                        wins
                        selectedGrid
                        previousLoser
                        animatedList
                    }
                    val context= LocalContext.current
                    val scope= rememberCoroutineScope()
                    val dataStore=StoreWins(context)
                    val savedWins=dataStore.getWins.collectAsState(initial = "")
                    val navController= rememberNavController()
                    for(i in 1..((grid*grid)-1)){
                        values.add(0)
                        Boxes.add(0)
                    }
                    NavHost(navController = navController, startDestination = "main_page") {
                        composable(
                            "main_page",
                            enterTransition = {
                                slideIntoContainer(
                                    AnimatedContentTransitionScope.SlideDirection.Left ,
                                    animationSpec = tween(700)
                                )
                            },
                            exitTransition = {
                                slideOutOfContainer(
                                    AnimatedContentTransitionScope.SlideDirection.Left,
                                    animationSpec = tween(700)
                                )
                            }
                        ){
                            MainPage(navController)
                        }
                        composable(
                            "second_page",
                            enterTransition = {
                                slideIntoContainer(
                                    AnimatedContentTransitionScope.SlideDirection.Left,
                                    animationSpec = tween(700)
                                )
                            },
                            exitTransition = {
                                slideOutOfContainer(
                                    AnimatedContentTransitionScope.SlideDirection.Left,
                                    animationSpec = tween(700)
                                )
                            }
                        ){
                            SecondPage(navController)
                        }
                        composable(
                            "third_page",
                            enterTransition = {
                                slideIntoContainer(
                                    AnimatedContentTransitionScope.SlideDirection.Left,
                                    animationSpec = tween(700)
                                )
                            },
                            exitTransition = {
                                slideOutOfContainer(
                                    AnimatedContentTransitionScope.SlideDirection.Left,
                                    animationSpec = tween(700)
                                )
                            }
                        ){
                            ThirdPage(navController)
                        }
                    }
                    if (ad==1){
                        AlertDialog(
                            onDismissRequest = {
                                ad=0
                            },
                            containerColor = MaterialTheme.colorScheme.onPrimary,
                            confirmButton = {
                                            Button(
                                                onClick = {
                                                          ad=0
                                                },
                                                colors = ButtonDefaults.buttonColors(
                                                    containerColor = Color(0xff3b4276)
                                                )
                                            ) {
                                                Text(text = "OK", fontWeight = FontWeight.Bold)
                                            }
                            },
                            title = { Text(text = "Help", fontWeight = FontWeight.Bold)},
                            text={ Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")}
                        )
                    }else if(ad==2){
                        AlertDialog(
                            title={(Text(text = "Are You Sure", fontWeight = FontWeight.Bold))},
                            text={ Text(text = "Do you want to reset the grid?")},
                            containerColor = MaterialTheme.colorScheme.onPrimary,
                            onDismissRequest = { ad=0 },
                            confirmButton = {
                                Button(
                                    onClick = {
                                        s=1
                                        score1=0
                                        score2=0
                                        selecteditems.clear()
                                        Player1Boxes.clear()
                                        Player2Boxes.clear()
                                        selecteditems.add(-1)
                                        Player1Boxes.add(-1)
                                        Player2Boxes.add(-1)
                                        PlayerTurn=1
                                        animatedList.clear()
                                        for(i in 0..((grid*grid)-1)){
                                            values[i]=0
                                            Boxes[i]=0
                                        }
                                        ad=0
                                        if (choice==2){
                                            choice=2
                                            timeLeft2=30
                                            timeLeft1=30
                                            timerProgress2=1f
                                            timerProgress1=1f
                                            if(r1!=r2){
                                                if(r2>r1){
                                                    timeLeft2=40
                                                }else{
                                                    timeLeft1=40
                                                }
                                            }
                                        }
                                        if(choice==1){
                                            if(r1!=r2){
                                                if(r2>r1){
                                                    power1=0
                                                }else{
                                                    power2=0
                                                }
                                            }
                                        }
                                        navController.navigate("third_page")
                                    }
                                ) {
                                    Text(text = "OK", fontWeight = FontWeight.Bold)
                                }
                            }
                        )
                    }else if(ad==-1){
                        AlertDialog(
                            text =  {Text(text = "Select a mode to play", fontSize = 20.sp)},
                            containerColor = MaterialTheme.colorScheme.onPrimary,
                            onDismissRequest = { ad=0 },
                            confirmButton = {
                                Button(onClick = { ad =0 }) {
                                    Text(text = "OK", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                }
                            }
                        )
                    }else if(ad==6){
                        LaunchedEffect(key1 = null) {
                            scope.launch {
                                for(i in 0..((originalWinnerList.size)-1)){
                                    dataStore.saveWins("{$originalWinnerList[i]}  -  ${wins[i]}")
                                }
                            }
                        }
                        AlertDialog(
                            text = {
                                   Column {
                                       for(i in 0..((originalWinnerList.size)-1)){
                                           if(wins[i]!=-1){
                                               Text(text = "${originalWinnerList[i]}  -  ${wins[i]}", fontSize = 20.sp)
                                           }
                                       }
                                   }
                            },
                            containerColor = MaterialTheme.colorScheme.onPrimary,
                            onDismissRequest = { ad=0 },
                            confirmButton = {
                                Button(onClick = { ad =0 }) {
                                    Text(text = "OK", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                }
                            }
                        )
                    }else if (ad==7){
                        ColorConquestTheme(com.example.colorconquest.theme) {
                            val painter5 = painterResource(id = R.drawable.dialogicon)
                            Box {
                                AlertDialog(
                                    modifier = Modifier
                                        .size(width = 250.dp, height = 280.dp),
                                    containerColor = Color(0xff3d4175),
                                    onDismissRequest = { /*TODO*/ },
                                    confirmButton = {
                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Bottom
                                        ) {
                                            Card(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .offset(y = -(7).dp),
                                                colors = CardDefaults.cardColors(
                                                    containerColor = MaterialTheme.colorScheme.onPrimary
                                                ),
                                                shape = RoundedCornerShape(100f),
                                            ) {
                                                Text(
                                                    text = "$winner", fontSize = 22.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = if (com.example.colorconquest.theme) Color.White else Color.Black,
                                                    modifier = Modifier
                                                        .padding(vertical = 6.dp)
                                                        .align(Alignment.CenterHorizontally)
                                                )
                                            }
                                            Image(
                                                painter = painter5,
                                                contentDescription = null,
                                                modifier = Modifier.offset(y = -(2).dp)
                                            )
                                            Button(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(2.dp),
                                                onClick = {
                                                    s = 1
                                                    score1 = 0
                                                    score2 = 0
                                                    animatedList.clear()
                                                    selecteditems.clear()
                                                    Player1Boxes.clear()
                                                    Player2Boxes.clear()
                                                    selecteditems.add(-1)
                                                    Player1Boxes.add(-1)
                                                    Player2Boxes.add(-1)
                                                    PlayerTurn = 1
                                                    for (i in 0..((grid * grid) - 1)) {
                                                        values[i] = 0
                                                        Boxes[i] = 0
                                                    }
                                                    ad = 0
                                                    if (choice == 2) {
                                                        choice = 2
                                                        stopTimer = false
                                                        timeLeft2 = 30
                                                        timeLeft1 = 30
                                                        timerProgress2 = 1f
                                                        timerProgress1 = 1f
                                                    }
                                                    series = selectedSeries.toInt()
                                                    count2 = 0
                                                    count1 = 0
                                                    l1 = 0
                                                    l2 = 0
                                                    losersList.clear()
                                                    winnerList.clear()
                                                    r1 = 0
                                                    r2 = 0
                                                    power1 = 0
                                                    power2 = 0
                                                    previousLoser=0
                                                    navController.navigate("third_page")
                                                },
                                                colors = ButtonDefaults.buttonColors(
                                                    containerColor = Color(0xff01c1f0)
                                                ),
                                            ) {
                                                Text(
                                                    text = "Play Again",
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    fontSize = 20.sp,
                                                    fontWeight = FontWeight.Bold,
                                                )
                                            }
                                            Button(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(2.dp),
                                                onClick = {
                                                    choice = 0
                                                    stopTimer = false
                                                    timeLeft2 = 30
                                                    timeLeft1 = 30
                                                    timerProgress2 = 1f
                                                    timerProgress1 = 1f
                                                    navController.navigate("main_page")
                                                    s = 1
                                                    score1 = 0
                                                    score2 = 0
                                                    selecteditems.clear()
                                                    Player1Boxes.clear()
                                                    Player2Boxes.clear()
                                                    selecteditems.add(-1)
                                                    Player1Boxes.add(-1)
                                                    Player2Boxes.add(-1)
                                                    PlayerTurn = 1
                                                    for (i in 0..((grid * grid) - 1)) {
                                                        values[i] = 0
                                                        Boxes[i] = 0
                                                    }
                                                    series = selectedSeries.toInt()
                                                    count2 = 0
                                                    count1 = 0
                                                    winnerList.clear()
                                                    l1 = 0
                                                    l2 = 0
                                                    losersList.clear()
                                                    r1 = 0
                                                    r2 = 0
                                                    series = 3
                                                    grid = 5
                                                    selectedSeries = list2[1]
                                                    selectedGrid = list1[2]
                                                    power1 = 0
                                                    power2 = 0
                                                    animatedList.clear()
                                                    previousLoser=0
                                                    ad=0
                                                },
                                                colors = ButtonDefaults.buttonColors(
                                                    containerColor = Color(0xffff5f57)
                                                )
                                            ) {
                                                Text(
                                                    text = "Home",
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    fontSize = 20.sp,
                                                    fontWeight = FontWeight.Bold,
                                                )
                                            }
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

