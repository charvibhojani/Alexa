package com.tooandunitils.alexa;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Ikev2VpnProfile;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Locale;

public class Custom_Commands extends Activity {

    Button add, speak;
    String text;
    TextView edit_custom;
    FavDB favDB;
    ArrayList<CustomItem> customItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        add = findViewById(R.id.add);
        edit_custom = findViewById(R.id.edit_custom);
        speak = findViewById(R.id.speak);

        favDB = new FavDB(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customCommand = edit_custom.getText().toString().trim();

                if (!customCommand.isEmpty()) {
                    boolean inserted = favDB.insertData_custom(customCommand);
                    if (inserted) {
                        // Clear the EditText after inserting the data
                        edit_custom.setText(""); // Clear the text in the EditText
                    }
                }

                if (customCommand.equals("")) {
                    Toast.makeText(Custom_Commands.this, "Create command", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Custom_Commands.this, Custom_List.class);
                    startActivity(intent);
                }
            }
        });

        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, 10);
                } else {
                    Toast.makeText(Custom_Commands.this, "Doesn't support Speech input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 10 && resultCode == RESULT_OK) {
            edit_custom.setText(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0));
        }
    }

}
