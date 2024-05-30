package com.example.colorconquest

import android.widget.CheckBox
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.colorconquest.ui.theme.ColorConquestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondPage(navController: NavController){
    ColorConquestTheme(theme) {
        val painter1= painterResource(id = R.drawable.secondpageicon)
        val painter2= painterResource(id = R.drawable.secondpageplayericon)
        Box(modifier= Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    listOf(Color(255, 194, 113, 255), Color(255, 96, 109, 255))
                )
            )
        )
        Box(contentAlignment = Alignment.TopCenter){
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier= Modifier
                    .width(340.dp)
                    .height(60.dp)
                    .offset(x = (-3).dp, y = 55.dp)
                    .shadow(10.dp, CutCornerShape(26.dp))
                    .clip(CutCornerShape(26.dp))
                    .border(
                        width = 3.dp,
                        color = Color(0xffcdb6b6),
                        shape = CutCornerShape(26.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffffd5b7)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 4.dp
                )
            ) {
                Text(text = "PLAYER INFORMATION",
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
        Image(painter = painter2, contentDescription = "",modifier= Modifier.offset(y=(-100).dp))

        Column {
            TextField(
                value = player1.uppercase(),
                onValueChange = {
                    player1=it
                },
                singleLine = true,
                placeholder = {
                    Text(text = "Enter Player-1 Name", fontSize = 10.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
                },
                modifier = Modifier
                    .width(144.dp)
                    .height(46.dp)
                    .offset(x = 225.dp, y = 251.dp),
                textStyle = TextStyle(fontSize = 10.sp, color = Color.Gray, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent
                )
            )
            TextField(
                value = player2.uppercase(),
                onValueChange = {
                    player2=it
                },
                singleLine = true,
                placeholder = {
                    Text(text = "Enter Player-2 Name", fontSize = 10.sp,color = Color.Gray, fontWeight = FontWeight.Bold)
                },
                modifier = Modifier
                    .width(144.dp)
                    .height(46.dp)
                    .offset(x = 225.dp, y = 337.dp),
                textStyle = TextStyle(fontSize = 10.sp,color = Color.Gray, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent
                )
            )
        }

        Row(modifier = Modifier.offset(x=62.dp,y=510.dp)) {
            var isExpanded1 by remember {
                mutableStateOf(false)
            }
            Column() {
                ExposedDropdownMenuBox(
                    expanded = isExpanded1,
                    onExpandedChange = {isExpanded1=!isExpanded1}
                ) {
                    TextField(
                        modifier= Modifier
                            .menuAnchor()
                            .fillMaxWidth(0.3f)
                            .alpha(0.8f),
                        label = {Text(text = "Enter Grid", fontSize = 11.sp)},
                        value = selectedGrid,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded1)}
                    )
                    ExposedDropdownMenu(expanded = isExpanded1, onDismissRequest = { isExpanded1=false })
                    {
                        list1.forEachIndexed { index, text ->
                            DropdownMenuItem(
                                text = { Text(text = text)},
                                onClick = {
                                    selectedGrid=list1[index]
                                    isExpanded1=false
                                    grid=list1[index].toInt()
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                            )
                        }
                    }
                }
                Text(text = "Selected Grid:$selectedGrid", fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.onPrimary)
            }

            Spacer(modifier = Modifier.padding(horizontal = 20.dp))

            var isExpanded2 by remember {
                mutableStateOf(false)
            }
            Column() {
                ExposedDropdownMenuBox(
                    expanded = isExpanded2,
                    onExpandedChange = {isExpanded2=!isExpanded2}
                ) {
                    TextField(
                        modifier= Modifier
                            .menuAnchor()
                            .fillMaxWidth(0.55f)
                            .alpha(0.8f),
                        label = {Text(text = "Enter Series", fontSize = 11.sp)},
                        value = selectedSeries,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded2)}
                    )
                    ExposedDropdownMenu(expanded = isExpanded2, onDismissRequest = { isExpanded2=false })
                    {
                        list2.forEachIndexed { index, text ->
                            DropdownMenuItem(
                                text = { Text(text = text)},
                                onClick = {
                                    selectedSeries=list2[index]
                                    series= list2[index].toInt()
                                    isExpanded2=false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                            )
                        }
                    }
                }
                Text(text = "Selected Series:$selectedSeries", fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.onPrimary)
            }
        }
        Row(modifier = Modifier.offset(x=23.dp,y=640.dp)) {
            Button(
                onClick = {
                    choice=1
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(choice==1) Color.LightGray else Color.DarkGray
                )
            ) {
                Text(text = "NORMAL MODE", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
            Spacer(modifier = Modifier.padding(horizontal = 15.dp))
            Button(
                onClick = {
                    choice=2
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(choice==2) Color.LightGray else Color.DarkGray
                )
            ) {
                Text(text = "TIMED MODE", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .padding(bottom = 58.dp)
                .offset(x = (-3).dp)
        ) {
            Button(
                onClick = {
                    if(choice==1 || choice==2){navController.navigate("third_page")}
                    else{
                        ad=-1
                    }
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
                Text(text = "START", fontSize = 35.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSecondary)
            }
        }
    }
    }

