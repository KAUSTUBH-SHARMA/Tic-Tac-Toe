package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //0=zero 1=cross
    int activePlayer=0;
    TextView winningText;
    Button playAgain;
    //2 means unplayed is there is nothing in that slot
    int[] gamestates={2,2,2,2,2,2,2,2,2};
    int [][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playAgain=findViewById(R.id.playAgainButton);
        playAgain.setVisibility(View.INVISIBLE);
        winningText =findViewById(R.id.textViewWinningText);
        winningText.setText("");
    }
    public void dropIn(View view){
        ImageView counter=(ImageView) view;


        int tappedCounter=Integer.parseInt(counter.getTag().toString());
        if(gamestates[tappedCounter]==2){
            counter.setTranslationY(-2000f);
            gamestates[tappedCounter]=activePlayer;
            if(activePlayer==0){
                counter.setImageResource(R.drawable.cross);
                activePlayer=1;
            }else{
                counter.setImageResource(R.drawable.zero);
                activePlayer=0;
            }

            counter.animate().translationYBy(2000f).setDuration(300);

            for(int[]winningPosition:winningPositions){
                if(gamestates[winningPosition[0]] == gamestates[winningPosition[1]]&& gamestates[winningPosition[1]]==gamestates[winningPosition[2]]&& gamestates[winningPosition[0]]!=2){
                    Toast.makeText(this,"Player "+gamestates[winningPosition[0]]+" Won the game",Toast.LENGTH_SHORT).show();

                    winningText.setText("Player "+gamestates[winningPosition[0]]+" Won the game ");
                    playAgain.setVisibility(View.VISIBLE);


                }
            }

        }



    }
    public void playAgainClicked(View view){
        winningText.setText("");
        playAgain.setVisibility(View.INVISIBLE);
    }
}

