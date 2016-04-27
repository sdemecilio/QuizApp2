package net.greenrivertech.stacey.quizapp2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private TextView questionView;

    private int currentIndex = 0;

    private questions[] questionAsked = new questions[] {
            new questions(R.string.yellowSun, true),
            new questions(R.string.math1, false),
            new questions(R.string.seattle, false),
            new questions(R.string.oceans, true),
            new questions(R.string.biology, true),
    };

    public void updateQuestion()
    {
        int question = questionAsked[currentIndex].getQuestion();
        questionView.setText(question);
    }

    public void checkAnswer (boolean trueClicked)
    {
        boolean trueAnswer = questionAsked[currentIndex].isAnswer();

        int messageResId = 0;

        if (trueClicked == trueAnswer)
        {
            messageResId = R.string.correct;
        }
        else
        {
            messageResId = R.string.incorrect;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        questionView = (TextView)findViewById(R.id.question);

        setTrueButton((Button)findViewById(R.id.trueButton));
        getTrueButton().setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    checkAnswer(true);
                }
            });

        setFalseButton((Button)findViewById(R.id.falseButton));
        getFalseButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public Button getTrueButton()
    {
        return trueButton;
    }

    public void setTrueButton (Button trueButton)
    {
        this.trueButton = trueButton;
    }

    public Button getFalseButton()
    {
        return falseButton;
    }

    public void setFalseButton(Button falseButton)
    {
        this.falseButton = falseButton;
    }

}
