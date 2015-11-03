package edu.slcc.alexknight.hangdroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    String theWord = "WORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void newLetter(View view) {
        EditText editText = (EditText) findViewById(R.id.editTextLetter);

        String letter = editText.getText().toString();

        editText.setText("");

        Log.d("MYLOG", "The letter is: " + letter);

        checkLetter(letter);
    }

    private void checkLetter(String letter) {
        letter = letter.toUpperCase();
        char aLetter = letter.charAt(0);

        boolean letterGuessed = false;

        for(int i=0; i<theWord.length(); i++) {
            if (theWord.charAt(i) == aLetter) {
                letterGuessed = true;
                Log.d("MYLOG", "Letter Found "+aLetter);
                showLetter(i,aLetter);
            }
        }
    }

    private void showLetter(int i, char aLetter) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutLetters);

        TextView textView = (TextView) layout.getChildAt(i);

        textView.setText(Character.toString(aLetter));
    }

}
