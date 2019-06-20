package edu.calvin.cs262.monopoly;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

public class NewPlayerActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "com.example.android.roomplayerssample.REPLY";

    private EditText mEditPlayerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);
        mEditPlayerView = findViewById(R.id.edit_player);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditPlayerView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String player = mEditPlayerView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, player);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}