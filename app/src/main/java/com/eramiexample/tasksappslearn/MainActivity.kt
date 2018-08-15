package com.eramiexample.tasksappslearn

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.nio.file.Files.size



class MainActivity : AppCompatActivity() {

    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var ActivePlayer=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        // Get the widgets
//        val button1 = findViewById<Button>(R.id.bt1);
//        val button2 = findViewById<Button>(R.id.bt2);
//        val button3 = findViewById<Button>(R.id.bt3);
//        val button4 =  <Button>(R.id.bt4);
//        val button5 = findViewById<Button>(R.id.bt5);
//        val button6 = findViewById<Button>(R.id.bt6);
//        val button7 = findViewById<Button>(R.id.bt7);
//        val button8 = findViewById<Button>(R.id.bt8);
//        val button9 = findViewById<Button>(R.id.bt9);
//
//        button1.setOnClickListener {
//
//        }
//        button2.setOnClickListener {
//
//        }
//        button3.setOnClickListener {
//
//        }
//        button4.setOnClickListener {
//
//        }
//        button5.setOnClickListener {
//
//        }
//        button6.setOnClickListener {
//
//        }
//        button7.setOnClickListener {
//
//        }
//        button8.setOnClickListener {
//
//        }
//        button9.setOnClickListener {
//
//        }


    }
   protected fun onButtomClick (view :View){
       val butSelected = view as Button
       var cellId= 0
       when(butSelected.id){
           R.id.bt1 -> cellId =1
           R.id.bt2 -> cellId =2
           R.id.bt3 -> cellId =3
           R.id.bt4 -> cellId =4
           R.id.bt5 -> cellId =5
           R.id.bt6 -> cellId =6
           R.id.bt7 -> cellId =7
           R.id.bt8 -> cellId =8
           R.id.bt9 -> cellId =9
       }
       PlayGme(cellId,butSelected)



//       Toast.makeText(this@MainActivity,""+cellId ,Toast.LENGTH_LONG).show()
    }
    fun PlayGme(cellId:Int ,buttonSelected:Button){
        if(ActivePlayer==1){
            buttonSelected.text="X"
            buttonSelected.setBackgroundColor(Color.MAGENTA)
            player1.add(cellId)
            ActivePlayer=2

            AutoPlay()


        }else{
            buttonSelected.text="O"
            buttonSelected.setBackgroundColor(Color.CYAN)
            player2.add(cellId)
            ActivePlayer=1

        }
        buttonSelected.isEnabled=false
        CheckWinner()


    }
    fun CheckWinner(){
        var winnr=-1
//        row 1
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            winnr =1
        }
        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winnr =1
        }
//        row 2
        if(player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winnr =2
        }
        if(player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            winnr =2
        }
        //        row 3
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winnr =1
        }
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winnr =2
        }

        //        clo 1
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winnr =1
        }
        if(player2.contains(1)&&player2.contains(1)&&player2.contains(7)){
            winnr =2
        }
        //        clo 2
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winnr =1
        }
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winnr =2
        }

        //        clo 1
        if(player1.contains(3)&&player1.contains(5)&&player1.contains(9)){
            winnr =1
        }
        if(player2.contains(3)&&player2.contains(5)&&player2.contains(9)){
            winnr =2
        }
            if(winnr!=-1){
                if(winnr==1){
                    Toast.makeText(this@MainActivity,"Congratulations .... Player 1" , Toast.LENGTH_LONG).show()
                 }else{
                    Toast.makeText(this@MainActivity,"Congratulations .... Player 2" , Toast.LENGTH_LONG).show()



                }

            }


    }
    fun AutoPlay(){
        var counntuNsELECTED=ArrayList<Int>()
        for(ceLLId in 1..9){
            if(!player1.contains(ceLLId)||!player2.contains(ceLLId)){
                counntuNsELECTED.add(ceLLId)

            }
        }
        val r =Random()
        val randomNumber =r.nextInt(counntuNsELECTED.size-0)+0
//        var randomNumber =(Math.random()*counntuNsELECTED.size).toInt()
          val cellID =counntuNsELECTED[randomNumber]
        Toast.makeText(this@MainActivity," size "+cellID,Toast.LENGTH_LONG).show()

        var buttonSelected :Button?
        when(cellID){
            1->buttonSelected=bt1
            2->buttonSelected=bt2
            3->buttonSelected=bt3
            4->buttonSelected=bt4
            5->buttonSelected=bt5
            6->buttonSelected=bt6
            7->buttonSelected=bt7
            8->buttonSelected=bt8
            9->buttonSelected=bt9
            else->{
                buttonSelected=bt1

            }



        }
        PlayGme(cellID,buttonSelected)





    }
}
