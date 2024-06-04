package com.example.colorconquest

import androidx.compose.runtime.mutableStateListOf

fun Expansion(index: Int){
    val a= mutableStateListOf(grid,grid*2,grid*3,grid*4,grid*5)
    val b= mutableStateListOf(((grid*2)-1),((grid*3)-1),((grid*4)-1),((grid*5)-1),((grid*6)-1))
    val c= mutableStateListOf(1,2,3,4,5)
    val d= mutableStateListOf(((grid*(grid-1))+1),((grid*(grid-1))+2),((grid*(grid-1))+3),((grid*(grid-1))+4),((grid*(grid-1))+5))
    if(grid !=7){
        for(i in 1..(7-grid)){
            a.removeLast()
            b.removeLast()
            c.removeLast()
            d.removeLast()
        }
    }
    if(selecteditems.contains(index)){
        if(Player1Boxes.contains(index)){
            if(a.contains(index)){
                values[index-grid]+=1
                values[index+1]+=1
                values[index+grid]+=1
                if(power1==1){
                    values[index-grid]+=1
                    values[index+1]+=1
                    values[index+grid]+=1
                    power1=-1
                }
                Boxes[index-grid]=1
                Boxes[index+1]=1
                Boxes[index+grid]=1
                Player1Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=2
                values[index]=0
                Boxes[index]=0
                if((index-grid) !in selecteditems){
                    selecteditems.add(index-grid)
                    Player1Boxes.add(index-grid)
                }
                if((index+1) !in selecteditems){
                    selecteditems.add(index+1)
                    Player1Boxes.add(index+1)
                }
                if((index+grid) !in selecteditems){
                    selecteditems.add(index+grid)
                    Player1Boxes.add(index+grid)
                }
                if(Player2Boxes.contains(index-grid)){
                    Player2Boxes.remove(index-grid)
                    Player1Boxes.add(index-grid)
                }
                if(Player2Boxes.contains(index+1)){
                    Player2Boxes.remove(index+1)
                    Player1Boxes.add(index+1)
                }
                if(Player2Boxes.contains(index+grid)){
                    Player2Boxes.remove(index+grid)
                    Player1Boxes.add(index+grid)
                }
                if(values[index-grid]==4 || values[index-grid]==5){
                    Expansion(index-grid)
                }
                if(values[index+1]==4 || values[index+1]==5){
                    Expansion(index+1)
                }
                if(values[index+grid]==4 || values[index+grid]==5){
                    Expansion(index+grid)
                }
            }
            else if(b.contains(index)){
                values[index-grid]+=1
                values[index-1]+=1
                values[index+grid]+=1
                if(power1==1){
                    values[index-grid]+=1
                    values[index-1]+=1
                    values[index+grid]+=1
                    power1=-1
                }
                Boxes[index-grid]=1
                Boxes[index-1]=1
                Boxes[index+grid]=1
                Player1Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=2
                values[index]=0
                Boxes[index]=0
                if((index-grid) !in selecteditems){
                    selecteditems.add(index-grid)
                    Player1Boxes.add(index-grid)
                }
                if((index-1) !in selecteditems){
                    selecteditems.add(index-1)
                    Player1Boxes.add(index-1)
                }
                if((index+grid) !in selecteditems){
                    selecteditems.add(index+grid)
                    Player1Boxes.add(index+grid)
                }
                if(Player2Boxes.contains(index-grid)){
                    Player2Boxes.remove(index-grid)
                    Player1Boxes.add(index-grid)
                }
                if(Player2Boxes.contains(index-1)){
                    Player2Boxes.remove(index-1)
                    Player1Boxes.add(index-1)
                }
                if(Player2Boxes.contains(index+grid)){
                    Player2Boxes.remove(index+grid)
                    Player1Boxes.add(index+grid)
                }
                if(values[index-grid]==4 || values[index-grid]==5){
                    Expansion(index-grid)
                }
                if(values[index-1]==4 || values[index-1]==5){
                    Expansion(index-1)
                }
                if(values[index+grid]==4 || values[index+grid]==5){
                    Expansion(index+grid)
                }
            }
            else if(c.contains(index)){
                values[index-1]+=1
                values[index+1]+=1
                values[index+grid]+=1
                if(power1==1){
                    values[index-1]+=1
                    values[index+1]+=1
                    values[index+grid]+=1
                    power1=-1
                }
                Boxes[index-1]=1
                Boxes[index+1]=1
                Boxes[index+grid]=1
                Player1Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=2
                values[index]=0
                Boxes[index]=0
                if((index-1) !in selecteditems){
                    selecteditems.add(index-1)
                    Player1Boxes.add(index-1)
                }
                if((index+1) !in selecteditems){
                    selecteditems.add(index+1)
                    Player1Boxes.add(index+1)
                }
                if((index+grid) !in selecteditems){
                    selecteditems.add(index+grid)
                    Player1Boxes.add(index+grid)
                }
                if(Player2Boxes.contains(index-1)){
                    Player2Boxes.remove(index-1)
                    Player1Boxes.add(index-1)
                }
                if(Player2Boxes.contains(index+1)){
                    Player2Boxes.remove(index+1)
                    Player1Boxes.add(index+1)
                }
                if(Player2Boxes.contains(index+grid)){
                    Player2Boxes.remove(index+grid)
                    Player1Boxes.add(index+grid)
                }
                if(values[index-1]==4 || values[index-1]==5){
                    Expansion(index-1)
                }
                if(values[index+1]==4 || values[index+1]==5){
                    Expansion(index+1)
                }
                if(values[index+grid]==4 || values[index+grid]==5){
                    Expansion(index+grid)
                }
            }
            else if(d.contains(index)){
                values[index-grid]+=1
                values[index+1]+=1
                values[index-1]+=1
                if(power1==1){
                    values[index-grid]+=1
                    values[index+1]+=1
                    values[index-1]+=1
                    power1=-1
                }
                Boxes[index-grid]=1
                Boxes[index+1]=1
                Boxes[index-1]=1
                Player1Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=2
                values[index]=0
                Boxes[index]=0
                if((index-grid) !in selecteditems){
                    selecteditems.add(index-grid)
                    Player1Boxes.add(index-grid)
                }
                if((index+1) !in selecteditems){
                    selecteditems.add(index+1)
                    Player1Boxes.add(index+1)
                }
                if((index-1) !in selecteditems){
                    selecteditems.add(index-1)
                    Player1Boxes.add(index-1)
                }
                if(Player2Boxes.contains(index-grid)){
                    Player2Boxes.remove(index-grid)
                    Player1Boxes.add(index-grid)
                }
                if(Player2Boxes.contains(index+1)){
                    Player2Boxes.remove(index+1)
                    Player1Boxes.add(index+1)
                }
                if(Player2Boxes.contains(index-1)){
                    Player2Boxes.remove(index-1)
                    Player1Boxes.add(index-1)
                }
                if(values[index-grid]==4 || values[index-grid]==5){
                    Expansion(index-grid)
                }
                if(values[index+1]==4 || values[index+1]==5){
                    Expansion(index+1)
                }
                if(values[index-1]==4 || values[index-1]==5){
                    Expansion(index-1)
                }
            }
            else if(index==0){
                values[index+1]+=1
                values[index+grid]+=1
                if(power1==1){
                    values[index+1]+=1
                    values[index+grid]+=1
                    power1=-1
                }
                Boxes[index+1]=1
                Boxes[index+grid]=1
                Player1Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=2
                values[index]=0
                Boxes[index]=0
                if((index+1) !in selecteditems){
                    selecteditems.add(index+1)
                    Player1Boxes.add(index+1)
                }
                if((index+grid) !in selecteditems){
                    selecteditems.add(index+grid)
                    Player1Boxes.add(index+grid)
                }
                if(Player2Boxes.contains(index+1)){
                    Player2Boxes.remove(index+1)
                    Player1Boxes.add(index+1)
                }
                if(Player2Boxes.contains(index+grid)){
                    Player2Boxes.remove(index+grid)
                    Player1Boxes.add(index+grid)
                }
                if(values[index+1]==4 || values[index+1]==5){
                    Expansion(index+1)
                }
                if(values[index+grid]==4 || values[index+grid]==5){
                    Expansion(index+grid)
                }
            }
            else if(index==(grid*(grid-1))){
                values[index-grid]+=1
                values[index+1]+=1
                if(power1==1){
                    values[index-grid]+=1
                    values[index+1]+=1
                    power1=-1
                }
                Boxes[index-grid]=1
                Boxes[index+1]=1
                Player1Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=2
                values[index]=0
                Boxes[index]=0
                if((index-grid) !in selecteditems){
                    selecteditems.add(index-grid)
                    Player1Boxes.add(index-grid)
                }
                if((index+1) !in selecteditems){
                    selecteditems.add(index+1)
                    Player1Boxes.add(index+1)
                }
                if(Player2Boxes.contains(index-grid)){
                    Player2Boxes.remove(index-grid)
                    Player1Boxes.add(index-grid)
                }
                if(Player2Boxes.contains(index+1)){
                    Player2Boxes.remove(index+1)
                    Player1Boxes.add(index+1)
                }
                if(values[index-grid]==4 || values[index-grid]==5){
                    Expansion(index-grid)
                }
                if(values[index+1]==4 || values[index+1]==5){
                    Expansion(index+1)
                }
            }
            else if(index==(grid-1)){
                values[index-1]+=1
                values[index+grid]+=1
                if(power1==1){
                    values[index-1]+=1
                    values[index+grid]+=1
                    power1=-1
                }
                Boxes[index-1]=1
                Boxes[index+grid]=1
                Player1Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=2
                values[index]=0
                Boxes[index]=0
                if((index-1) !in selecteditems){
                    selecteditems.add(index-1)
                    Player1Boxes.add(index-1)
                }
                if((index+grid) !in selecteditems){
                    selecteditems.add(index+grid)
                    Player1Boxes.add(index+grid)
                }
                if(Player2Boxes.contains(index-1)){
                    Player2Boxes.remove(index-1)
                    Player1Boxes.add(index-1)
                }
                if(Player2Boxes.contains(index+grid)){
                    Player2Boxes.remove(index+grid)
                    Player1Boxes.add(index+grid)
                }
                if(values[index-1]==4 || values[index-1]==5){
                    Expansion(index-1)
                }
                if(values[index+grid]==4 || values[index+grid]==5){
                    Expansion(index+grid)
                }
            }
            else if(index==(grid*grid)-1){
                values[index-grid]+=1
                values[index-1]+=1
                if(power1==1){
                    values[index-grid]+=1
                    values[index-1]+=1
                    power1=-1
                }
                Boxes[index-grid]=1
                Boxes[index-1]=1
                Player1Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=2
                values[index]=0
                Boxes[index]=0
                if((index-grid) !in selecteditems){
                    selecteditems.add(index-grid)
                    Player1Boxes.add(index-grid)
                }
                if((index-1) !in selecteditems){
                    selecteditems.add(index-1)
                    Player1Boxes.add(index-1)
                }
                if(Player2Boxes.contains(index-grid)){
                    Player2Boxes.remove(index-grid)
                    Player1Boxes.add(index-grid)
                }
                if(Player2Boxes.contains(index-1)){
                    Player2Boxes.remove(index-1)
                    Player1Boxes.add(index-1)
                }
                if(values[index-grid]==4 || values[index-grid]==5){
                    Expansion(index-grid)
                }
                if(values[index-1]==4 || values[index-1]==5){
                    Expansion(index-1)
                }
            }
            else{
                values[index-grid]+=1
                values[index+1]+=1
                values[index+grid]+=1
                values[index-1]+=1
                if(power1==1){
                    values[index-grid]+=1
                    values[index+1]+=1
                    values[index+grid]+=1
                    values[index-1]+=1
                    power1=-1
                }
                Boxes[index-grid]=1
                Boxes[index+1]=1
                Boxes[index+grid]=1
                Boxes[index-1]=1
                Player1Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=2
                values[index]=0
                Boxes[index]=0
                if((index-grid) !in selecteditems){
                    selecteditems.add(index-grid)
                    Player1Boxes.add(index-grid)
                }
                if((index+1) !in selecteditems){
                    selecteditems.add(index+1)
                    Player1Boxes.add(index+1)
                }
                if((index+grid) !in selecteditems){
                    selecteditems.add(index+grid)
                    Player1Boxes.add(index+grid)
                }
                if((index-1) !in selecteditems){
                    selecteditems.add(index-1)
                    Player1Boxes.add(index-1)
                }
                if(Player2Boxes.contains(index-grid)){
                    Player2Boxes.remove(index-grid)
                    Player1Boxes.add(index-grid)
                }
                if(Player2Boxes.contains(index+1)){
                    Player2Boxes.remove(index+1)
                    Player1Boxes.add(index+1)
                }
                if(Player2Boxes.contains(index+grid)){
                    Player2Boxes.remove(index+grid)
                    Player1Boxes.add(index+grid)
                }
                if(Player2Boxes.contains(index-1)){
                    Player2Boxes.remove(index-1)
                    Player1Boxes.add(index-1)
                }
                if(values[index-grid]==4 || values[index-grid]==5){
                    Expansion(index-grid)
                }
                if(values[index+1]==4 || values[index+1]==5){
                    Expansion(index+1)
                }
                if(values[index+grid]==4 || values[index+grid]==5){
                    Expansion(index+grid)
                }
                if(values[index-1]==4 || values[index-1]==5){
                    Expansion(index-1)
                }
            }
        }
        if(Player2Boxes.contains(index)) {
            if (a.contains(index)) {
                values[index - grid] += 1
                values[index + 1] += 1
                values[index + grid] += 1
                if(power2==1){
                    values[index - grid] += 1
                    values[index + 1] += 1
                    values[index + grid] += 1
                    power2=-1
                }
                Boxes[index - grid] = 2
                Boxes[index + 1] = 2
                Boxes[index + grid] = 2
                Player2Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=1
                values[index] = 0
                Boxes[index] = 0
                if ((index - grid) !in selecteditems) {
                    selecteditems.add(index - grid)
                    Player2Boxes.add(index - grid)
                }
                if ((index + 1) !in selecteditems) {
                    selecteditems.add(index + 1)
                    Player2Boxes.add(index + 1)
                }
                if ((index + grid) !in selecteditems) {
                    selecteditems.add(index + grid)
                    Player2Boxes.add(index + grid)
                }
                if (Player1Boxes.contains(index - grid)) {
                    Player1Boxes.remove(index - grid)
                    Player2Boxes.add(index - grid)
                }
                if (Player1Boxes.contains(index + 1)) {
                    Player1Boxes.remove(index + 1)
                    Player2Boxes.add(index + 1)
                }
                if (Player1Boxes.contains(index + grid)) {
                    Player1Boxes.remove(index + grid)
                    Player2Boxes.add(index + grid)
                }
                if (values[index - grid] == 4 || values[index - grid] == 5) {
                    Expansion(index - grid)
                }
                if (values[index + 1]== 4 || values[index + 1]== 5) {
                    Expansion(index + 1)
                }
                if (values[index + grid]== 4 || values[index + grid]== 5) {
                    Expansion(index + grid)
                }
            }
            else if (b.contains(index)) {
                values[index - grid] += 1
                values[index - 1] += 1
                values[index + grid] += 1
                if(power2==1){
                    values[index - grid] += 1
                    values[index - 1] += 1
                    values[index + grid] += 1
                    power2=-1
                }
                Boxes[index - grid] = 2
                Boxes[index - 1] = 2
                Boxes[index + grid] = 2
                Player2Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=1
                values[index] = 0
                Boxes[index] = 0
                if ((index - grid) !in selecteditems) {
                    selecteditems.add(index - grid)
                    Player2Boxes.add(index - grid)
                }
                if ((index - 1) !in selecteditems) {
                    selecteditems.add(index - 1)
                    Player2Boxes.add(index - 1)
                }
                if ((index + grid) !in selecteditems) {
                    selecteditems.add(index + grid)
                    Player2Boxes.add(index + grid)
                }
                if (Player1Boxes.contains(index - grid)) {
                    Player1Boxes.remove(index - grid)
                    Player2Boxes.add(index - grid)
                }
                if (Player1Boxes.contains(index - 1)) {
                    Player1Boxes.remove(index - 1)
                    Player2Boxes.add(index - 1)
                }
                if (Player1Boxes.contains(index + grid)) {
                    Player1Boxes.remove(index + grid)
                    Player2Boxes.add(index + grid)
                }
                if (values[index - grid]== 4 || values[index - grid]== 5) {
                    Expansion(index - grid)
                }
                if (values[index - 1] == 4 || values[index - 1] == 5) {
                    Expansion(index - 1)
                }
                if (values[index + grid] == 4 || values[index + grid] == 5) {
                    Expansion(index + grid)
                }
            }
            else if(c.contains(index)) {
                values[index - 1] += 1
                values[index + 1] += 1
                values[index + grid] += 1
                if(power2==1){
                    values[index - 1] += 1
                    values[index + 1] += 1
                    values[index + grid] += 1
                    power2=-1
                }
                Boxes[index - 1] = 2
                Boxes[index + 1] = 2
                Boxes[index + grid] = 2
                Player2Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=1
                values[index] = 0
                Boxes[index] = 0
                if ((index - 1) !in selecteditems) {
                    selecteditems.add(index - 1)
                    Player2Boxes.add(index - 1)
                }
                if ((index + 1) !in selecteditems) {
                    selecteditems.add(index + 1)
                    Player2Boxes.add(index + 1)
                }
                if ((index + grid) !in selecteditems) {
                    selecteditems.add(index + grid)
                    Player2Boxes.add(index + grid)
                }
                if (Player1Boxes.contains(index - 1)) {
                    Player1Boxes.remove(index - 1)
                    Player2Boxes.add(index - 1)
                }
                if (Player1Boxes.contains(index + 1)) {
                    Player1Boxes.remove(index + 1)
                    Player2Boxes.add(index + 1)
                }
                if (Player1Boxes.contains(index + grid)) {
                    Player1Boxes.remove(index + grid)
                    Player2Boxes.add(index + grid)
                }
                if (values[index - 1] == 4 || values[index - 1] == 5) {
                    Expansion(index - 1)
                }
                if (values[index + 1] == 4 || values[index + 1] == 5) {
                    Expansion(index + 1)
                }
                if (values[index + grid] == 4 || values[index + grid] == 5) {
                    Expansion(index + grid)
                }
            }
            else if(d.contains(index)) {
                values[index - grid] += 1
                values[index + 1] += 1
                values[index -1] += 1
                if(power2==1){
                    values[index - grid] += 1
                    values[index + 1] += 1
                    values[index -1] += 1
                    power2=-1
                }
                Boxes[index - grid] = 2
                Boxes[index + 1] = 2
                Boxes[index -1] = 2
                Player2Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=1
                values[index] = 0
                Boxes[index] = 0
                if ((index - grid) !in selecteditems) {
                    selecteditems.add(index - grid)
                    Player2Boxes.add(index - grid)
                }
                if ((index + 1) !in selecteditems) {
                    selecteditems.add(index + 1)
                    Player2Boxes.add(index + 1)
                }
                if ((index -1) !in selecteditems) {
                    selecteditems.add(index -1)
                    Player2Boxes.add(index -1)
                }
                if (Player1Boxes.contains(index - grid)) {
                    Player1Boxes.remove(index - grid)
                    Player2Boxes.add(index - grid)
                }
                if (Player1Boxes.contains(index + 1)) {
                    Player1Boxes.remove(index + 1)
                    Player2Boxes.add(index + 1)
                }
                if (Player1Boxes.contains(index-1)) {
                    Player1Boxes.remove(index-1)
                    Player2Boxes.add(index-1)
                }
                if (values[index - grid] == 4 || values[index - grid] == 5) {
                    Expansion(index - grid)
                }
                if (values[index + 1] == 4 || values[index + 1] == 5) {
                    Expansion(index + 1)
                }
                if (values[index -1] == 4 || values[index -1] == 5) {
                    Expansion(index-1)
                }
            }
            else if(index==0){
                values[index + 1] += 1
                values[index + grid] += 1
                if(power2==1){
                    values[index + 1] += 1
                    values[index + grid] += 1
                    power2=-1
                }
                Boxes[index + 1] = 2
                Boxes[index + grid] = 2
                Player2Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=1
                values[index] = 0
                Boxes[index] = 0
                if ((index + 1) !in selecteditems) {
                    selecteditems.add(index + 1)
                    Player2Boxes.add(index + 1)
                }
                if ((index + grid) !in selecteditems) {
                    selecteditems.add(index + grid)
                    Player2Boxes.add(index + grid)
                }
                if (Player1Boxes.contains(index + 1)) {
                    Player1Boxes.remove(index + 1)
                    Player2Boxes.add(index + 1)
                }
                if (Player1Boxes.contains(index + grid)) {
                    Player1Boxes.remove(index + grid)
                    Player2Boxes.add(index + grid)
                }
                if (values[index + 1] == 4 || values[index + 1] == 5) {
                    Expansion(index + 1)
                }
                if (values[index + grid] == 4 || values[index + grid] == 5) {
                    Expansion(index + grid)
                }
            }
            else if(index==(grid*(grid-1))){
                values[index - grid] += 1
                values[index + 1] += 1
                if(power2==1){
                    values[index - grid] += 1
                    values[index + 1] += 1
                    power2=-1
                }
                Boxes[index - grid] = 2
                Boxes[index + 1] = 2
                Player2Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=1
                values[index] = 0
                Boxes[index] = 0
                if ((index - grid) !in selecteditems) {
                    selecteditems.add(index - grid)
                    Player2Boxes.add(index - grid)
                }
                if ((index + 1) !in selecteditems) {
                    selecteditems.add(index + 1)
                    Player2Boxes.add(index + 1)
                }
                if (Player1Boxes.contains(index - grid)) {
                    Player1Boxes.remove(index - grid)
                    Player2Boxes.add(index - grid)
                }
                if (Player1Boxes.contains(index + 1)) {
                    Player1Boxes.remove(index + 1)
                    Player2Boxes.add(index + 1)
                }
                if (values[index - grid] == 4 || values[index - grid] == 5) {
                    Expansion(index - grid)
                }
                if (values[index + 1] == 4 || values[index + 1] == 5) {
                    Expansion(index + 1)
                }
            }
            else if(index==(grid-1)){
                values[index - 1] += 1
                values[index + grid] += 1
                if(power2==1){
                    values[index - 1] += 1
                    values[index + grid] += 1
                    power2=-1
                }
                Boxes[index - 1] = 2
                Boxes[index + grid] = 2
                Player2Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=1
                values[index] = 0
                Boxes[index] = 0
                if ((index - 1) !in selecteditems) {
                    selecteditems.add(index - 1)
                    Player2Boxes.add(index - 1)
                }
                if ((index + grid) !in selecteditems) {
                    selecteditems.add(index + grid)
                    Player2Boxes.add(index + grid)
                }
                if (Player1Boxes.contains(index - 1)) {
                    Player1Boxes.remove(index - 1)
                    Player2Boxes.add(index - 1)
                }
                if (Player1Boxes.contains(index + grid)) {
                    Player1Boxes.remove(index + grid)
                    Player2Boxes.add(index + grid)
                }
                if (values[index - 1] == 4 || values[index - 1] == 5) {
                    Expansion(index - 1)
                }
                if (values[index + grid] == 4 ||values[index + grid] == 5) {
                    Expansion(index + grid)
                }
            }
            else if(index==(grid*grid)-1){
                values[index - grid] += 1
                values[index - 1] += 1
                if(power2==1){
                    values[index - grid] += 1
                    values[index - 1] += 1
                    power2=-1
                }
                Boxes[index - grid] = 2
                Boxes[index - 1] = 2
                Player2Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=1
                values[index] = 0
                Boxes[index] = 0
                if ((index - grid) !in selecteditems) {
                    selecteditems.add(index - grid)
                    Player2Boxes.add(index - grid)
                }
                if ((index - 1) !in selecteditems) {
                    selecteditems.add(index - 1)
                    Player2Boxes.add(index - 1)
                }
                if (Player1Boxes.contains(index - grid)) {
                    Player1Boxes.remove(index - grid)
                    Player2Boxes.add(index - grid)
                }
                if (Player1Boxes.contains(index - 1)) {
                    Player1Boxes.remove(index - 1)
                    Player2Boxes.add(index - 1)
                }
                if (values[index - grid] == 4 || values[index - grid] == 5) {
                    Expansion(index - grid)
                }
                if (values[index - 1] == 4 || values[index - 1] == 5) {
                    Expansion(index - 1)
                }
            }
            else {
                values[index - grid] += 1
                values[index + 1] += 1
                values[index + grid] += 1
                values[index - 1] += 1
                if(power2==1){
                    values[index - grid] += 1
                    values[index + 1] += 1
                    values[index + grid] += 1
                    values[index - 1] += 1
                    power2=-1
                }
                Boxes[index - grid] = 2
                Boxes[index + 1] = 2
                Boxes[index + grid] = 2
                Boxes[index - 1] = 2
                Player2Boxes.remove(index)
                selecteditems.remove(index)
                PlayerTurn=1
                values[index] = 0
                Boxes[index] = 0
                if ((index - grid) !in selecteditems) {
                    selecteditems.add(index - grid)
                    Player2Boxes.add(index - grid)
                }
                if ((index + 1) !in selecteditems) {
                    selecteditems.add(index + 1)
                    Player2Boxes.add(index + 1)
                }
                if ((index + grid) !in selecteditems) {
                    selecteditems.add(index + grid)
                    Player2Boxes.add(index + grid)
                }
                if ((index - 1) !in selecteditems) {
                    selecteditems.add(index - 1)
                    Player2Boxes.add(index - 1)
                }
                if (Player1Boxes.contains(index - grid)) {
                    Player1Boxes.remove(index - grid)
                    Player2Boxes.add(index - grid)
                }
                if (Player1Boxes.contains(index + 1)) {
                    Player1Boxes.remove(index + 1)
                    Player2Boxes.add(index + 1)
                }
                if (Player1Boxes.contains(index + grid)) {
                    Player1Boxes.remove(index + grid)
                    Player2Boxes.add(index + grid)
                }
                if (Player1Boxes.contains(index - 1)) {
                    Player1Boxes.remove(index - 1)
                    Player2Boxes.add(index - 1)
                }
                if (values[index - grid] == 4 || values[index - grid] == 5) {
                    Expansion(index - grid)
                }
                if (values[index + 1] == 4 || values[index + 1] == 5) {
                    Expansion(index + 1)
                }
                if (values[index + grid] == 4 || values[index + grid] == 5) {
                    Expansion(index + grid)
                }
                if (values[index - 1] == 4 || values[index - 1] == 5) {
                    Expansion(index - 1)
                }
            }
        }
    }
}
