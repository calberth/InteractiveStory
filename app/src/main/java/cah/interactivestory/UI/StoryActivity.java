package cah.interactivestory.UI;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cah.interactivestory.R;
import cah.interactivestory.model.Choice;
import cah.interactivestory.model.Page;
import cah.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {
    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));
        //Toast.makeText(StoryActivity.this, name, Toast.LENGTH_LONG).show();
        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);

        loadPage(0);
    }

    private void loadPage(int choice){
        mCurrentPage = mStory.getPage(choice);
        String pageText = mCurrentPage.getMtext();
        pageText = String.format(pageText, mName); //adds the name where we specified in text (%1$s)

        Drawable drawable = ContextCompat.getDrawable(this, mCurrentPage.getImageId()); //this works
        mImageView.setImageDrawable(drawable);
        mTextView.setText(pageText);

        if (mCurrentPage.isFinal()) {
          mChoice1.setVisibility(View.INVISIBLE);//note, GONE will remove it from layout entirely
          mChoice2.setText("Play Again");

          mChoice2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                //int nextPage = mCurrentPage.getChoice1().getNextPage();
                finish(); //ends the storyactivity, so we go back to mainactivity
                loadPage(0);
             }
          });
       }

        else {
          mChoice1.setText(mCurrentPage.getChoice1().getText());
          mChoice2.setText(mCurrentPage.getChoice2().getText());

          mChoice1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                int nextPage = mCurrentPage.getChoice1().getNextPage();
                loadPage(nextPage);
             }
          });
          mChoice2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                int nextPage = mCurrentPage.getChoice2().getNextPage();
                loadPage(nextPage);
             }
          });
        }

    }

}
