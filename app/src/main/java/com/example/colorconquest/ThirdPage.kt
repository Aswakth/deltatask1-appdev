package com.example.colorconquest

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.colorconquest.ui.theme.ColorConquestTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

var count1=0
var count2=0

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirdPage(navController: NavController){
    ColorConquestTheme(theme) {
        val painter3= painterResource(id = R.drawable.rediconframe)
        val painter4= painterResource(id = R.drawable.blueiconframe)
        val timerfont= Font(R.font.timerfont)
        val painter8= painterResource(id = R.drawable.stopwatch)
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.lottie))
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    if (PlayerTurn == 1) {
                        Color(0xffff5f57)
                    } else {
                        Color(0xff2fb6f0)
                    }
                )
        )
        Box(contentAlignment = Alignment.TopStart) {
            Row {
                Card(
                    modifier = Modifier
                        .offset(x = 0.dp, y = 60.dp)
                        .border(
                            width = 5.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(topEnd = 30.dp, bottomEnd = 30.dp)
                        )
                        .shadow(
                            elevation = 5.dp,
                            shape = RoundedCornerShape(topEnd = 30.dp, bottomEnd = 30.dp)
                        ),
                    shape= RoundedCornerShape(topEnd = 30.dp, bottomEnd = 30.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xff2f323b),
                    ),
                ) {
                    Text(text = "$score2",
                        modifier = Modifier
                            .padding(40.dp, 11.dp, 30.dp, 11.dp)
                            .rotate(180f),
                        fontSize = 26.sp, fontWeight = FontWeight.Bold,color = Color(0xff2fb6f0)
                    )
                }
                Spacer(modifier = Modifier.padding(horizontal = 6.dp))
                Card(
                    modifier = Modifier
                        .offset(x = 0.dp, y = 60.dp)
                        .clip(CutCornerShape(topStart = 50.dp, bottomStart = 50.dp))
                        .border(
                            width = 3.dp,
                            color = Color.Black,
                            shape = CutCornerShape(
                                topStart = 50.dp,
                                bottomStart = 50.dp,
                                topEnd = 6.dp,
                                bottomEnd = 6.dp
                            )
                        )
                        .shadow(
                            elevation = 5.dp, shape = CutCornerShape(
                                topStart = 50.dp,
                                bottomStart = 50.dp,
                                topEnd = 6.dp,
                                bottomEnd = 6.dp
                            )
                        ),
                    shape = RoundedCornerShape(7.dp),
                    colors = CardDefaults.cardColors(
                        containerColor =Color(0xff2f323b)
                    )
                ) {
                    Text(text = player1.uppercase(),
                        modifier = Modifier
                            .rotate(180f)
                            .padding(25.dp, 11.dp, 40.dp, 11.dp),
                        style = TextStyle(
                            fontSize = 26.sp,
                            color = Color(0xff2fb6f0)
                        ),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
        if(choice==1){
            if(previousLoser==1){
                if (power2==0){
                    if(ad!=7){
                        Box(contentAlignment = Alignment.TopEnd) {
                            Button(onClick = {power2=1},
                                modifier= Modifier
                                    .padding(20.dp)
                                    .offset(y = 110.dp)
                                    .shadow(8.dp, RoundedCornerShape(100.dp)),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xffffd5b7)
                                )) {
                                Text(text = "Expansion Power Up", color = MaterialTheme.colorScheme.onPrimary, fontWeight = FontWeight.Bold, modifier = Modifier.alpha(0.8f))
                            }
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .offset(x = -(18).dp, y = 15.dp), contentAlignment = Alignment.TopEnd) {
            Button(
                onClick = {
                    ad=11
                },
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .shadow(elevation = 8.dp, shape = CircleShape),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(text = "X", fontSize = 23.sp, fontWeight = FontWeight.Bold, color = Color.Gray, modifier = Modifier.offset(x=-(6).dp))
            }
        }
        if(choice==2){
            Row(modifier = Modifier.offset(x=10.dp,y=160.dp)){

                val barProgress1 by animateFloatAsState(targetValue = timerProgress1, animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec)
                val totalDuration=30
                LaunchedEffect(key1 = timeLeft1,key2 = timerProgress1, key3 = PlayerTurn) {
                    while(timeLeft1>0 && PlayerTurn==2 && timerProgress1<=1f){
                        delay(1000L)
                        if (previousLoser==1) timerProgress1-=0.025f else timerProgress1-=0.0333f
                        timeLeft1--
                    }
                }
                if (timeLeft1==0 && series!=1){
                    winnerList.add(player2.uppercase())
                    if (player2.uppercase() !in originalWinnerList) {
                        originalWinnerList.add(player2.uppercase())
                        wins.add(1)
                    }else if (player2.uppercase() in originalWinnerList){
                        for (i in 0..((originalWinnerList.size)-1)){
                            if (originalWinnerList[i]== player2.uppercase()){
                                wins[i]+=1
                            }
                        }
                    }
                    previousLoser=1
                    if (choice==2){
                        if(score1> highScore){
                            highScore= score1
                            cwinner= player2.uppercase()
                            fastTime= timeLeft2
                        }else if (score1== highScore){
                            if((timeLeft2> fastTime)&& (r1!=r2) ){
                                highScore=score1
                                fastTime= timeLeft2
                                cwinner= player2.uppercase()
                            }
                        }
                    }
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
                    for(i in 0..((grid*grid)-1)){
                        values[i]=0
                        Boxes[i]=0
                    }
                    if (choice==2){
                        choice=2
                        stopTimer=false
                        timeLeft2=30
                        timeLeft1=30
                        timerProgress1=1f
                        timerProgress2=1f
                    }
                    series-=1
                    if(previousLoser==1){
                        timeLeft1=40
                    }
                    l1=0
                    animatedList.clear()
                    l2=0
                }
                if(timeLeft1==0 && series==1){
                    if (player2.uppercase() !in originalWinnerList) {
                        originalWinnerList.add(player2.uppercase())
                        wins.add(1)
                    }else if (player2.uppercase() in originalWinnerList){
                        for (i in 0..((originalWinnerList.size)-1)){
                            if (originalWinnerList[i]== player2.uppercase()){
                                wins[i]+=1
                            }
                        }
                    }
                    if (choice==2){
                        if(score1> highScore){
                            highScore= score1
                            cwinner= player2.uppercase()
                            fastTime= timeLeft2
                        }else if (score1== highScore){
                            if((timeLeft2> fastTime)&& (r1!=r2) ){
                                highScore=score1
                                fastTime= timeLeft2
                                cwinner= player2.uppercase()
                            }
                        }
                    }
                    winnerList.add(player2.uppercase())
                    for (i in winnerList){
                        if(i== player2.uppercase()){count2+=1}
                        else if(i== player1.uppercase()){count1+=1}
                    }
                    if(count1> count2){winner= player1.uppercase()}
                    else if(count2> count1){winner= player2.uppercase()}
                    else if(count1==0 && count2==0){
                        if(score1==0){
                            winner=player1.uppercase()
                        }else if(score2==0){
                            winner=player2.uppercase()
                        }
                    }
                    series-=1
                    timeLeft1=-1
                    stopTimer=true
                    ad=7
                }
                if (!stopTimer){
                    LinearProgressIndicator(progress = barProgress1, color = Color.Green, modifier = Modifier
                        .height(15.dp)
                        .rotate(180f)
                        .offset(y = (15.dp)))
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Text(text = "$timeLeft1", fontSize = 26.sp, fontFamily = FontFamily(timerfont), fontWeight = FontWeight.Bold,modifier= Modifier
                        .offset(y = -(21).dp)
                        .rotate(180f), color = MaterialTheme.colorScheme.onPrimary)
                    Icon(painter = painter8, contentDescription =null, modifier = Modifier
                        .size(20.dp)
                        .rotate(180f)
                        .offset(x = -(8.dp), y = 18.dp))
                }
            }
            Row(modifier = Modifier.offset(x=10.dp,y=670.dp)){

                val barProgress2 by animateFloatAsState(targetValue = timerProgress2, animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec)
                val totalDuration=30
                LaunchedEffect(key1 = timeLeft2,key2 = timerProgress2, key3 = PlayerTurn) {
                    while(timeLeft2>0 && PlayerTurn==1 && timerProgress2<=1f){
                        delay(1000L)
                        if (previousLoser==2) timerProgress2-=0.025f else timerProgress2-=0.0333f
                        timeLeft2--
                    }
                }
                if (timeLeft2==0 && series!=1){
                    if (player1.uppercase() !in originalWinnerList) {
                        originalWinnerList.add(player1.uppercase())
                        wins.add(1)
                    }else if (player1.uppercase() in originalWinnerList){
                        for (i in 0..((originalWinnerList.size)-1)){
                            if (originalWinnerList[i]== player1.uppercase()){
                                wins[i]+=1
                            }
                        }
                    }
                    previousLoser=2
                    winnerList.add(player1.uppercase())
                    if (choice==2){
                        if(score2> highScore){
                            highScore= score2
                            cwinner= player1.uppercase()
                            fastTime= timeLeft1
                        }else if (score2== highScore){
                            if((timeLeft1> fastTime)&& (r1!=r2) ){
                                highScore=score2
                                fastTime= timeLeft1
                                cwinner= player1.uppercase()
                            }
                        }
                    }
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
                    for(i in 0..((grid*grid)-1)){
                        values[i]=0
                        Boxes[i]=0
                    }
                    if (choice==2){
                        choice=2
                        stopTimer=false
                        timeLeft2=30
                        timeLeft1=30
                        timerProgress2=1f
                        timerProgress1=1f
                    }
                    series-=1
                    if(previousLoser==2){
                        timeLeft2=40
                    }
                    l1=0
                    animatedList.clear()
                    l2=0
                }
                if(timeLeft2==0 && series==1){
                    winnerList.add(player1.uppercase())
                    if (player1.uppercase() !in originalWinnerList) {
                        originalWinnerList.add(player1.uppercase())
                        wins.add(1)
                    }else if (player1.uppercase() in originalWinnerList){
                        for (i in 0..((originalWinnerList.size)-1)){
                            if (originalWinnerList[i]== player1.uppercase()){
                                wins[i]+=1
                            }
                        }
                    }
                    if (choice==2){
                        if(score2> highScore){
                            highScore= score2
                            cwinner= player1.uppercase()
                            fastTime= timeLeft1
                        }else if (score2== highScore){
                            if((timeLeft1> fastTime)&& (r1!=r2) ){
                                highScore=score2
                                fastTime= timeLeft1
                                cwinner= player1.uppercase()
                            }
                        }
                    }
                    for (i in winnerList){
                        if(i== player2.uppercase()){count2+=1}
                        else if(i== player1.uppercase()){count1+=1}
                    }
                    if(count1> count2){winner= player1.uppercase()}
                    else if(count2> count1){winner= player2.uppercase()}
                    else if(count1==0 && count2==0){
                        if(score1==0){
                            winner=player1.uppercase()
                        }else if(score2==0){
                            winner=player2.uppercase()
                        }
                    }
                    series-=1
                    timeLeft2=-1
                    stopTimer=true
                    ad=7
                }
                if (!stopTimer){
                    Icon(painter = painter8, contentDescription =null, modifier = Modifier
                        .size(20.dp)
                        .offset(x = 84.dp, y = 12.dp))
                    Text(text = "$timeLeft2", fontSize = 26.sp,fontFamily = FontFamily(timerfont), fontWeight = FontWeight.Bold,modifier=Modifier.offset(x=93.dp,y=9.dp), color = MaterialTheme.colorScheme.onPrimary)
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    LinearProgressIndicator(progress = barProgress2, color = Color.Green, modifier = Modifier
                        .height(15.dp)
                        .offset(x = 95.dp, y = 15.dp))
                }
            }
        }
        if(ad!=7){
            val fontFamily= FontFamily(Font(R.font.typewriter))
            Text(text = "GAME ${((selectedSeries.toInt()+1)- series)}", fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier
                .offset(x = 152.dp, y = 187.dp)
                .alpha(0.8f), fontFamily = fontFamily, color = MaterialTheme.colorScheme.onPrimary)
            Text(text = "GAME ${((selectedSeries.toInt()+1)- series)}", fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier
                .rotate(180f)
                .offset(x = 152.dp, y = 189.dp)
                .alpha(0.8f),fontFamily=fontFamily, color = MaterialTheme.colorScheme.onPrimary)
        }
        if(selectedSeries.toInt()== series && t==1 && !end){
            if (choice==2){
                timeLeft1=-1
                timeLeft2=-1
                stopTimer=true
            }
            end=true
            ad=10
        }
        val items=List(grid*grid){it}
        Box(
            modifier = Modifier
                .padding(25.dp)
                .offset(y = 215.dp)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(grid),
                content = {
                    items(grid*grid) {
                        val animatedProgress by animateFloatAsState(
                            targetValue = if (selecteditems.contains(it)) 1f else 0.5f,
                            animationSpec = tween(durationMillis = 100)
                        )
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.alpha(animatedProgress)){
                            Button(
                                onClick ={
                                    if( it !in selecteditems){
                                        selecteditems.add(it)
                                    }
                                    if(s==1){
                                        StartCase()
                                    }
                                    else if(Boxes[it]==1 || Boxes[it]==2){
                                        if(it in Player1Boxes && PlayerTurn==1){
                                            values[it]+=1
                                            PlayerTurn=2
                                        }else if(it in Player2Boxes && PlayerTurn==2){
                                            values[it]+=1
                                            PlayerTurn=1
                                        }
                                        if(values[it]==4){
                                            Expansion(index=it)
                                        }
                                        score1=0
                                        score2=0
                                        for(i in 0..((grid*grid)-1)){
                                            if(Boxes[i]==1){
                                                score1+=values[i]
                                            }else if(Boxes[i]==2){
                                                score2+=values[i]
                                            }
                                        }
                                        if(s==2 && (score1==0||score2==0) && series!=1){
                                            if(score1==0){
                                                winnerList.add(player1.uppercase())
                                                if (player1.uppercase() !in originalWinnerList) {
                                                    originalWinnerList.add(player1.uppercase())
                                                    wins.add(1)
                                                }else if (player1.uppercase() in originalWinnerList){
                                                    for (i in 0..((originalWinnerList.size)-1)){
                                                        if (originalWinnerList[i]== player1.uppercase()){
                                                            wins[i]+=1
                                                        }
                                                    }
                                                }
                                                previousLoser=2
                                                losersList.add(player2.uppercase())
                                                if (choice==2){
                                                    if(score2> highScore){
                                                        highScore= score2
                                                        cwinner= player1.uppercase()
                                                        fastTime= timeLeft1
                                                    }else if (score2== highScore){
                                                        if((timeLeft1> fastTime)&& (r1!=r2) ){
                                                            highScore=score2
                                                            fastTime= timeLeft1
                                                            cwinner= player1.uppercase()
                                                        }
                                                    }
                                                }
                                            }else if(score2==0){
                                                winnerList.add(player2.uppercase())
                                                if (player2.uppercase() !in originalWinnerList) {
                                                    originalWinnerList.add(player2.uppercase())
                                                    wins.add(1)
                                                }else if (player2.uppercase() in originalWinnerList){
                                                    for (i in 0..((originalWinnerList.size)-1)){
                                                        if (originalWinnerList[i]== player2.uppercase()){
                                                            wins[i]+=1
                                                        }
                                                    }
                                                }
                                                previousLoser=1
                                                losersList.add(player1.uppercase())
                                                if (choice==2){
                                                    if(score1> highScore){
                                                        highScore= score1
                                                        cwinner= player2.uppercase()
                                                        fastTime= timeLeft2
                                                    }else if (score1== highScore){
                                                        if((timeLeft2> fastTime)&& (r1!=r2) ){
                                                            highScore=score1
                                                            fastTime= timeLeft2
                                                            cwinner= player2.uppercase()
                                                        }
                                                    }
                                                }
                                            }
                                            if (choice==2){
                                                timeLeft1=-1
                                                timeLeft2=-1
                                                stopTimer=true
                                            }
                                            ad=10
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
                                            for(i in 0..((grid*grid)-1)){
                                                values[i]=0
                                                Boxes[i]=0
                                            }
                                            series-=1
                                            for (i in losersList){
                                                if(i== player2.uppercase()){l2+=1}
                                                else if(i== player1.uppercase()){l1+=1}
                                            }
                                            r1=l1
                                            r2=l2
                                            power1=0
                                            power2=0
                                            l1=0
                                            l2=0
                                            animatedList.clear()
                                        }
                                        if (s==2 && (score1==0||score2==0) && series==1){
                                            if(score1==0){
                                                winnerList.add(player1.uppercase())
                                                if (player1.uppercase() !in originalWinnerList) {
                                                    originalWinnerList.add(player1.uppercase())
                                                    wins.add(1)
                                                }else if (player1.uppercase() in originalWinnerList){
                                                    for (i in 0..((originalWinnerList.size)-1)){
                                                        if (originalWinnerList[i]== player1.uppercase()){
                                                            wins[i]+=1
                                                        }
                                                    }
                                                }
                                                if (choice==2){
                                                    if(score2> highScore){
                                                        highScore= score2
                                                        cwinner= player1.uppercase()
                                                        fastTime= timeLeft1
                                                    }else if (score2== highScore){
                                                        if((timeLeft1> fastTime)&& (r1!=r2) ){
                                                            highScore=score2
                                                            fastTime= timeLeft1
                                                            cwinner= player1.uppercase()
                                                        }
                                                    }
                                                }
                                            }else if(score2==0){
                                                winnerList.add(player2.uppercase())
                                                if (player2.uppercase() !in originalWinnerList) {
                                                    originalWinnerList.add(player2.uppercase())
                                                    wins.add(1)
                                                }else if (player2.uppercase() in originalWinnerList){
                                                    for (i in 0..((originalWinnerList.size)-1)){
                                                        if (originalWinnerList[i]== player2.uppercase()){
                                                            wins[i]+=1
                                                        }
                                                    }
                                                }
                                                if (choice==2){
                                                    if(score1> highScore){
                                                        highScore= score1
                                                        cwinner= player2.uppercase()
                                                        fastTime= timeLeft2
                                                    }else if (score1== highScore){
                                                        if((timeLeft2> fastTime)&& (r1!=r2) ){
                                                            highScore=score1
                                                            fastTime= timeLeft2
                                                            cwinner= player2.uppercase()
                                                        }
                                                    }
                                                }
                                            }
                                            for (i in winnerList){
                                                if(i== player2.uppercase()){count2+=1}
                                                else if(i== player1.uppercase()){count1+=1}
                                            }
                                            if(count1> count2){winner= player1.uppercase()}
                                            else if(count2> count1){winner= player2.uppercase()}
                                            else if(count1==0 && count2==0){
                                                if(score1==0){
                                                    winner=player1.uppercase()
                                                }else if(score2==0){
                                                    winner=player2.uppercase()
                                                }
                                            }
                                            series-=1
                                            timeLeft1=-1
                                            timeLeft2=-1
                                            power1=0
                                            power2=0
                                            stopTimer=true
                                            end=true
                                            ad=7
                                            g+=1
                                        }
                                    }
                                },
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .padding(5.dp)
                                    .size(5.dp)
                                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(9.dp)),
                                shape = RoundedCornerShape(9.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xfff5e5ce)
                                )
                            ){}
                            if (selecteditems.contains(it)){
                                if(values[it]!=0){
                                    if(Boxes[it]==1){
                                        Icon(painter = painter3, contentDescription = null, modifier = Modifier.fillMaxSize(0.68f), tint = Color.Unspecified)
                                        Text(
                                            text = "${values[it]}",
                                            fontSize = 26.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onPrimary
                                        )
                                    }else if(Boxes[it]==2){
                                        Icon(painter = painter4, contentDescription = null, modifier = Modifier.fillMaxSize(0.68f), tint = Color.Unspecified)
                                        Text(
                                            text = "${values[it]}",
                                            fontSize = 26.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onPrimary
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            )
        }
        if(winner== player1.uppercase() && ad==7){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
                LottieAnimation(composition = composition, modifier = Modifier.size(500.dp).offset(x=-(110).dp,y=-(190).dp), iterations = LottieConstants.IterateForever)
            }
        }else if(winner== player2.uppercase() && ad==7){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                LottieAnimation(composition = composition, modifier = Modifier.size(500.dp).offset(x=110.dp,y=150.dp), iterations = LottieConstants.IterateForever)
            }
        }
        if(choice==1){
            if(previousLoser==2){
                if (power1==0){
                    if(ad!=7){
                        Box(contentAlignment = Alignment.BottomStart) {
                            Button(onClick = {power1=1},
                                modifier= Modifier
                                    .padding(20.dp)
                                    .offset(y = -(110).dp)
                                    .shadow(8.dp, RoundedCornerShape(100.dp)),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xffffd5b7)
                                )) {
                                Text(text = "Expansion Power Up", color = MaterialTheme.colorScheme.onPrimary, fontWeight = FontWeight.Bold, modifier = Modifier.alpha(0.8f))
                            }
                        }
                    }
                }
            }
        }
        Box(contentAlignment = Alignment.BottomEnd) {
            Row {
                Card(
                    modifier = Modifier
                        .offset(x = 0.dp, y = -(60).dp)
                        .clip(CutCornerShape(topEnd = 50.dp, bottomEnd = 50.dp))
                        .border(
                            width = 3.dp,
                            color = Color.Black,
                            shape = CutCornerShape(
                                topEnd = 50.dp,
                                bottomEnd = 50.dp,
                                topStart = 6.dp,
                                bottomStart = 6.dp
                            )
                        )
                        .shadow(
                            elevation = 5.dp, shape = CutCornerShape(
                                topEnd = 50.dp,
                                bottomEnd = 50.dp,
                                topStart = 6.dp,
                                bottomStart = 6.dp
                            )
                        ),
                    shape = RoundedCornerShape(7.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xff2f323b)
                    )
                ) {
                    Text(
                        text = player2.uppercase(),
                        style = TextStyle(
                            fontSize = 26.sp,
                            color = Color(0xffff5f57)
                        ),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(25.dp, 11.dp, 40.dp, 11.dp),
                    )
                }
                Spacer(modifier = Modifier.padding(horizontal = 6.dp))
                Card(
                    modifier = Modifier
                        .offset(x = 0.dp, y = -(60).dp)
                        .border(
                            width = 5.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(
                                topStart = 30.dp,
                                bottomStart = 30.dp
                            )
                        )
                        .shadow(
                            elevation = 5.dp,
                            shape = RoundedCornerShape(
                                topStart = 30.dp,
                                bottomStart = 30.dp
                            )
                        ),
                    shape = RoundedCornerShape(
                        topEnd = 0.dp,
                        topStart = 30.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 30.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xff2f323b)
                    ),
                ) {
                    Text(
                        text = "$score1",
                        modifier = Modifier.padding(30.dp, 11.dp, 40.dp, 11.dp),
                        fontSize = 26.sp, fontWeight = FontWeight.Bold, color = Color(0xffff5f57)
                    )
                }
            }
        }
    }
    }
