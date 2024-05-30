package com.example.colorconquest

fun StartCase(){
    for(i in 0..((grid*grid)-1)){
        if(selecteditems.contains(i)){
            if(score1==0 && score2==0){
                values[i]=3
                score1=3
                Player1Boxes.add(i)
                Boxes[i]=1
                PlayerTurn=2
            }
            else if(i !in Player1Boxes){
                values[i]=3
                score2=3
                Player2Boxes.add(i)
                Boxes[i]=2
                PlayerTurn=1
                s=2
            }
        }
    }
}