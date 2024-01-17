package com.tooandunitils.alexa;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class First extends Activity {

    ImageView start, share, rate, privacy;
    Button custom_command, favv_command, create_command;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        start = findViewById(R.id.start);
        share = findViewById(R.id.share);
        rate = findViewById(R.id.rate);
        privacy = findViewById(R.id.privacy);
        custom_command = findViewById(R.id.custom_command);
        favv_command = findViewById(R.id.favv_command);
        create_command = findViewById(R.id.create_command);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First.this, Home.class);
                startActivity(intent);
            }
        });

        custom_command.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First.this, Custom_List.class);
                startActivity(intent);
            }
        });

        create_command.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First.this, Custom_Commands.class);
                startActivity(intent);
            }
        });

        favv_command.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First.this, Fav.class);
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shareApplication();

            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayStoreForRating();
            }
        });

    }

    private void shareApplication() {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
            String shareMessage = "\nLet me recommend you this application\n\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch (Exception e) {
            //e.toString();
        }
    }

    private void openPlayStoreForRating() {
        try {
            // Replace "your.package.name" with your app's package name
            String packageName = "your.package.name";

            // Create the URI for the app's page on the Play Store
            Uri uri = Uri.parse("market://details?id=" + packageName);

            // Create an intent to open the Play Store
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);

            // Set the flags to indicate that this is a market intent
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Verify if any Play Store app is available to handle the intent
            if (intent.resolveActivity(getPackageManager()) != null) {
                // Start the activity to open the Play Store
                startActivity(intent);
            } else {
                // If no Play Store app is available, open the Play Store website in a browser
                String url = "https://play.google.com/store/apps/details?id=" + packageName;
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(webIntent);
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}