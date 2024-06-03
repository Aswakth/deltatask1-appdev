@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.colorconquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.colorconquest.datastore.StoreWins
import com.example.colorconquest.ui.theme.ColorConquestTheme
import kotlinx.coroutines.launch

var player1 by mutableStateOf("ash")

var player2 by mutableStateOf("bal")

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
var g=1
var animatedList = mutableListOf(-1)
var t by mutableStateOf(1)
var end by mutableStateOf(false)
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
                        t
                        end
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
                                                    containerColor = Color(0xff01c1f0)
                                                )
                                            ) {
                                                Text(text = "OK", fontWeight = FontWeight.Bold)
                                            }
                            },
                            title = { Text(text = "Help", fontWeight = FontWeight.Bold)},
                            text={ Text(text = "The game offers two modes: Normal and Timer. In Normal mode, no time limits apply, while in Timer mode, players have 30 seconds to finish the match. Players choose mode, grid size, and matches at the start.\n" +
                                    "\n" +
                                    "During the first turn, players assign their color to a tile, gaining 3 points. Subsequent turns involve adding 1 point to tiles of the player's color. When a tile hits 4 points, it spreads to adjacent tiles(up,down,left,right), gaining 1 point each. If a neighboring tile has the opponent's color, it's conquered.\n" +
                                    "\n" +
                                    "Objective is to Erase all opponent's tiles. Losers receive power-ups; in Normal mode, an Expansion Power Up allows tiles to expand to 8 points rather than 4 (2 points on each neighbouring tile), which will be available once during the match. In Timer mode, players can gain 10 extra seconds. If a player receives a power up his score wont be considered for the high score.\n")}
                        )
                    }else if(ad==-1){
                        AlertDialog(
                            text =  {Text(text = "SELECT A MODE TO PLAY", fontSize = 20.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)},
                            containerColor = Color(0xff3b4276),
                            onDismissRequest = { ad=0 },
                            confirmButton = {},
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
                            title={(Text(text = "PREVIOUS WINS", fontWeight = FontWeight.Bold))},
                            text = {
                                   Column {
                                       for(i in 0..((originalWinnerList.size)-1)){
                                           if(wins[i]!=-1){
                                               if ("${originalWinnerList[i]}  -  ${wins[i]}"=="     "){
                                                   Text(text = "---")
                                               } else {
                                                   Text(text = "${originalWinnerList[i]}  -  ${wins[i]}", fontSize = 20.sp)
                                               }
                                           }
                                       }
                                   }
                            },
                            containerColor = MaterialTheme.colorScheme.onPrimary,
                            onDismissRequest = { ad=0 },
                            confirmButton = {}
                        )
                    }else if (ad==9){
                        AlertDialog(
                            text =  {Text(text = "ENTER NAMES TO PLAY", fontSize = 20.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)},
                            containerColor = Color(0xff3b4276),
                            onDismissRequest = { ad=0 },
                            confirmButton = {}
                        )
                    }else if (ad==10){
                        val game=((selectedSeries.toInt())+1)- series
                        AlertDialog(
                            onDismissRequest =
                            {
                                t+=1
                                ad=0
                                if (choice==2){
                                    choice=2
                                    stopTimer=false
                                    timeLeft2=30
                                    timeLeft1=30
                                    timerProgress2=1f
                                    timerProgress1=1f
                                    if(previousLoser==1) timeLeft1=40 else if(previousLoser==2) timeLeft2=40
                                }
                            },
                            confirmButton = {},
                            title = {Text(text = "GAME ${game}")},
                            text = {
                                if (game!=1 && choice==1) Text(text = "POWER UP will be available for the loser, enabling them to expand their tile into 8 points once")
                                else if (game!=1 &&choice==2) Text(text = "Extra 10 seconds will be added to the loser's timer as a POWER UP")
                            }
                        )
                    }else if(ad==11){
                        val reset= painterResource(id = R.drawable.reset)
                        val home= painterResource(id = R.drawable.home)
                        val play= painterResource(id = R.drawable.play)
                        AlertDialog(
                            onDismissRequest = { ad=0 },
                            modifier = Modifier.offset(x=30.dp)
                        ) {
                            Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.fillMaxSize()) {
                                Card(
                                    shape = CircleShape, modifier = Modifier
                                        .size(250.dp)
                                        .padding(20.dp)
                                        .alpha(0.7f),
                                    colors = CardDefaults.cardColors(containerColor = Color.White),
                                ) {
                                    Box(modifier = Modifier.offset(x=72.dp, y = 12.dp)){
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
                                                    if(previousLoser==2) timeLeft2=40 else if(previousLoser==1) timeLeft1=40
                                                }
                                                if(choice==1){
                                                    if (previousLoser==1)power2=0 else if(previousLoser==2) power1=0
                                                }
                                                ad=0
                                            },
                                            shape = CircleShape,
                                            modifier = Modifier.size(66.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Red
                                            )
                                        ) {
                                        }
                                        Image(painter = reset, contentDescription = null, modifier = Modifier.size(40.dp).offset(x=14.dp,y=13.dp))
                                    }
                                    Box(modifier = Modifier.offset(x=20.dp,y=35.dp)){
                                        Button(
                                            onClick = { ad=0 },
                                            shape = CircleShape,
                                            modifier = Modifier.size(66.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Cyan
                                            )
                                        ) {
                                        }
                                        Image(painter = play, contentDescription = null, modifier = Modifier.size(35.dp).offset(x=18.dp,y=15.dp))
                                    }
                                    Box(modifier = Modifier.offset(x=125.dp,y=-(32).dp)){
                                        Button(
                                            onClick = {
                                                choice = 0
                                                stopTimer = false
                                                timeLeft2 = 30
                                                timeLeft1 = 30
                                                timerProgress2 = 1f
                                                timerProgress1 = 1f
                                                ad=0
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
                                                player1=""
                                                player2=""
                                                t=1
                                            },
                                            shape = CircleShape,
                                            modifier = Modifier.size(66.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Yellow
                                            )
                                        ) {
                                        }
                                        Image(painter = home, contentDescription = null, modifier = Modifier.size(40.dp).offset(x=13.dp,y=11.dp))
                                    }
                                }
                            }
                        }
                    }
                    else if (ad==7){
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
                                                    t=1
                                                    power1 = 0
                                                    power2 = 0
                                                    previousLoser=0
                                                    end=false
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
                                                    player1=""
                                                    player2=""
                                                    t=1
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

