package com.example.user.notesk1;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity {
    Button b_rock,b_paper,b_scissors;
    String myChoice, cpuChoice, reslut ;
    ImageView iv_cpu,iv_me;
    Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        iv_cpu=(ImageView)findViewById(R.id.iv_cpu);
        iv_me=(ImageView)findViewById(R.id.iv_me);

        b_paper=(Button)findViewById(R.id.b_papper);
        b_rock=(Button)findViewById(R.id.b_rock);
        b_scissors =(Button)findViewById(R.id.b_scissors);
        r=new Random();


        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice="rock";
                iv_me.setImageResource(R.drawable.rock);
                calculate();
            }
        });

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice="paper";
                iv_me.setImageResource(R.drawable.paper);
                calculate();
            }
        });
        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice="scissors";
                iv_me.setImageResource(R.drawable.scissors);
                calculate();
            }
        });



    }

    public void calculate(){
        int cpu=r.nextInt(3);
        if (cpu ==0){
            cpuChoice="rock";
            iv_cpu.setImageResource(R.drawable.rock);

        }
        else if (cpu ==1){
            cpuChoice="paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }
        else if (cpu ==2){
            cpuChoice="scissors";
            iv_cpu.setImageResource(R.drawable.scissors);
        }



        if (myChoice.equals("rock") && cpuChoice.equals("paper")){
            reslut="YOU LOSE";

        } else if (myChoice.equals("rock") && cpuChoice.equals("scissors")){
            reslut="YOU WIN";

        } else if (myChoice.equals("paper") && cpuChoice.equals("rock")){
            reslut="YOU WIN";

        } else
        if (myChoice.equals("paper") && cpuChoice.equals("scissors")){
            reslut="YOU LOSE";

        } else
        if (myChoice.equals("scissors") && cpuChoice.equals("paper")){
            reslut="YOU WIN";

        } else
        if (myChoice.equals("scissors") && cpuChoice.equals("rock")){
            reslut="YOU LOSE";

        } else
        if (myChoice.equals("scissors") && cpuChoice.equals("scissors")){
            reslut="DRAW";

        } else
        if (myChoice.equals("rock") && cpuChoice.equals("rock")){
            reslut="DRAW";

        } else
        if (myChoice.equals("paper") && cpuChoice.equals("paper")){
            reslut="DRAW";

        }
        Toast.makeText(Game.this, reslut ,Toast.LENGTH_LONG).show();
    }


}

