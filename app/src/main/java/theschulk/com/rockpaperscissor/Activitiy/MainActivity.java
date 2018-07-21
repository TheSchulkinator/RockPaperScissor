package theschulk.com.rockpaperscissor.Activitiy;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import theschulk.com.rockpaperscissor.R;

import static theschulk.com.rockpaperscissor.Utility.RockPaperScissorUtility.createRandomNumber;
import static theschulk.com.rockpaperscissor.Utility.RockPaperScissorUtility.evaluateWinner;

public class MainActivity extends AppCompatActivity {
    ImageView cpuChoiceImageView;
    TextView resultTextView;
    TextView winnerTextView;
    TextView loserTextView;
    TextView tieTextView;

    //vars for shared prefernces
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int tieScore;
    int lostScore;
    int winScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tieTextView = findViewById(R.id.tieTextView);
        loserTextView = findViewById(R.id.cpuWinsTextView);
        winnerTextView = findViewById(R.id.userWinTextView);

        sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        tieScore = sharedPreferences.getInt(getString(R.string.keyTie), 0);
        tieTextView.setText(getString(R.string.tiesBox) + tieScore);

        lostScore = sharedPreferences.getInt(getString(R.string.keyCpuWins), 0);
        loserTextView.setText(getString(R.string.lossesBox) + lostScore);

        winScore = sharedPreferences.getInt(getString(R.string.keyUserWins), 0);
        winnerTextView.setText(getString(R.string.winsBox) + winScore);
    }

    //set up click events for all button pushes
    //0=rock, 1=paper, 2=scissor
    public void onRockClick(View view){
        int cpuSelection = createRandomNumber();
        int winnerResult = evaluateWinner(0, cpuSelection);
        displayResults(winnerResult, cpuSelection);
    }

    public void onPaperClick(View view){
        int cpuSelection = createRandomNumber();
        int winnerResult = evaluateWinner(1, cpuSelection);
        displayResults(winnerResult, cpuSelection);
    }

    public void onScissorClick(View view){
        int cpuSelection = createRandomNumber();
        int winnerResult = evaluateWinner(2, cpuSelection);
        displayResults(winnerResult, cpuSelection);
    }

    public void displayResults(int result, int cpuChoice){
        cpuChoiceImageView = findViewById(R.id.cpuImageView);
        resultTextView = findViewById(R.id.resultTextView);

        //set image view to cpu choice
        switch (cpuChoice){
            case 0:
                cpuChoiceImageView.setImageResource(R.drawable.ic_rock);
                break;
            case 1:
                cpuChoiceImageView.setImageResource(R.drawable.ic_paper);
                break;
            case 2:
                cpuChoiceImageView.setImageResource(R.drawable.ic_scissor);
                break;
        }

        //display result text and update the score boxes
        //0=tie, 1=loser, 2=winner
        sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        switch (result){
            case 0:
                tieScore = sharedPreferences.getInt(getString(R.string.keyTie), 0);
                tieScore += 1;
                editor.putInt(getString(R.string.keyTie), tieScore);
                editor.commit();
                tieTextView.setText(getString(R.string.tiesBox) + tieScore);
                resultTextView.setText(R.string.tie);
                break;
            case 1:
                lostScore = sharedPreferences.getInt(getString(R.string.keyCpuWins), 0);
                lostScore += 1;
                editor.putInt(getString(R.string.keyCpuWins), lostScore);
                editor.commit();
                loserTextView.setText(getString(R.string.lossesBox) + lostScore);
                resultTextView.setText(R.string.loser);
                break;
            case 2:
                winScore = sharedPreferences.getInt(getString(R.string.keyUserWins), 0);
                winScore += 1;
                editor.putInt(getString(R.string.keyUserWins), winScore);
                editor.commit();
                winnerTextView.setText(getString(R.string.winsBox) + winScore);
                resultTextView.setText(R.string.winner);
                break;
        }

    }
}
