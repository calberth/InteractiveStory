package cah.interactivestory.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cah.interactivestory.R;

public class MainActivity extends AppCompatActivity {
    private EditText mNameField;
    private Button mStartButton;
    private String mName; //we can also just delete and pass along as parameter


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //make sure stuff is set after setContentView
        mNameField = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mName = mNameField.getText().toString();
                //Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
                //has to be MainActivity.this because otherwise "this" is something else
                StartStory();
            }
        });
    }

    private void StartStory() {
        Intent intent = new Intent(this, StoryActivity.class);
        //we use class because it needs the object
        //"this" refers to main activity class that we are in
        intent.putExtra(getString(R.string.key_name), mName);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNameField.setText("");
    }
}
