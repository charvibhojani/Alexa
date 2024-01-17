package com.tooandunitils.alexa;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ValueActivity extends Activity implements ValueAdapter.Myclick {

    RecyclerView lv1;
    ArrayList<ValueItem> valueItems = new ArrayList<>();
    String commands;
    private FavDB dbHelper;
    TextView name;
    ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_list_new);

        dbHelper = new FavDB(this);

        lv1 = findViewById(R.id.lv1);
        name = findViewById(R.id.name);
        back = findViewById(R.id.back);

        commands = SharedPreference.getCategory();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lv1.setLayoutManager(linearLayoutManager);

        if (commands.equalsIgnoreCase("Alarms")) {

            valueItems.add(new ValueItem("Alexa, Snooze ", false));
            valueItems.add(new ValueItem("Alexa, when's my next alarm? ", false));
            valueItems.add(new ValueItem("Alexa, cancel my alarms ", false));
            valueItems.add(new ValueItem("Alexa, set a timer for 30 minutes ", false));
            valueItems.add(new ValueItem("Alexa, set an alarm for 7 AM ", false));
            valueItems.add(new ValueItem("Alexa, set a second timer for 10 minutes ", false));
            valueItems.add(new ValueItem("Alexa, what are my timers? ", false));
            valueItems.add(new ValueItem("Alexa, cancel all alarms ", false));
            valueItems.add(new ValueItem("Alexa, set an alarm for 6:30 AM every weekday ", false));
            valueItems.add(new ValueItem("Alexa, set an alarm for 8:00 AM ", false));
            valueItems.add(new ValueItem("Alexa, what alarms do I have set? ", false));
            valueItems.add(new ValueItem("Alexa, what time is my next alarm? ", false));
            valueItems.add(new ValueItem("Alexa, change the alarm sound to Chirping bird ", false));
            valueItems.add(new ValueItem("Alexa, tell me about my alarms for tomorrow. ", false));
            valueItems.add(new ValueItem("Alexa, increase alarm volume. ", false));

        }
        if (commands.equalsIgnoreCase("Basics")) {

            valueItems.add(new ValueItem("Alexa, Help", false));
            valueItems.add(new ValueItem("Alexa, Mute", false));
            valueItems.add(new ValueItem("Alexa, Unmute", false));
            valueItems.add(new ValueItem("Alexa, Stop", false));
            valueItems.add(new ValueItem("Alexa, Volume Up", false));
            valueItems.add(new ValueItem("Alexa, Volume Down", false));
            valueItems.add(new ValueItem("Alexa, Set Volume to 5", false));
            valueItems.add(new ValueItem("Alexa, Go to SleepPlay set Volume to 10", false));
            valueItems.add(new ValueItem("Alexa, open Zomato", false));
            valueItems.add(new ValueItem("Alexa, tell me a riddle.", false));
            valueItems.add(new ValueItem("Alexa, play a subway surfers game", false));
            valueItems.add(new ValueItem("Alexa, set a pasta timer for 20 minutes.", false));
            valueItems.add(new ValueItem("Alexa, answer the call.", false));
            valueItems.add(new ValueItem("Alexa, send a message to Mummy", false));
            valueItems.add(new ValueItem("Alexa, tell me a fun fact", false));

        }
        if (commands.equalsIgnoreCase("Bluetooth")) {

            valueItems.add(new ValueItem("Alexa, pair Bluetooth", false));
            valueItems.add(new ValueItem("Alexa, discover my devices", false));
            valueItems.add(new ValueItem("Alexa, find Bluetooth devices", false));
            valueItems.add(new ValueItem("Alexa, enter Bluetooth pairing mode", false));
            valueItems.add(new ValueItem("Alexa, start device discovery", false));
            valueItems.add(new ValueItem("Alexa, play music on Bluetooth", false));
            valueItems.add(new ValueItem("Alexa, skip to the next song on Bluetooth", false));
            valueItems.add(new ValueItem("Alexa, go back on Bluetooth", false));
            valueItems.add(new ValueItem("Alexa, disconnect Bluetooth", false));
            valueItems.add(new ValueItem("Alexa, increase Bluetooth volume", false));
            valueItems.add(new ValueItem("Alexa, connect to my device.", false));
            valueItems.add(new ValueItem("Alexa, switch audio to my device.", false));
            valueItems.add(new ValueItem("Alexa, what's my Bluetooth status?", false));
            valueItems.add(new ValueItem("Alexa, what devices are available for pairing?", false));
            valueItems.add(new ValueItem("Alexa, I'm having trouble with Bluetooth.", false));

        }
        if (commands.equalsIgnoreCase("Calender")) {

            valueItems.add(new ValueItem("Alexa, what's on my calendar?", false));
            valueItems.add(new ValueItem("Alexa, what are my events for tomorrow?", false));
            valueItems.add(new ValueItem("Alexa, what's my appointment?", false));
            valueItems.add(new ValueItem("Alexa, what time is it?", false));
            valueItems.add(new ValueItem("Alexa, schedule a meeting called interview on 27th", false));
            valueItems.add(new ValueItem("Alexa, move my interview to 1st june", false));
            valueItems.add(new ValueItem("Alexa, reminder for task on 23rd May", false));
            valueItems.add(new ValueItem("Alexa, what's the date?", false));
            valueItems.add(new ValueItem("Alexa, add an event to calendar", false));
            valueItems.add(new ValueItem("Alexa, what's on calendar for today?", false));
            valueItems.add(new ValueItem("Alexa, link my Google Calendar.", false));
            valueItems.add(new ValueItem("Alexa, connect my Apple Calendar.", false));
            valueItems.add(new ValueItem("Alexa, sync with Outlook Calendar.", false));
            valueItems.add(new ValueItem("Alexa, what's on the agenda for today?", false));
            valueItems.add(new ValueItem("Alexa, what's my daily briefing?", false));

        }
        if (commands.equalsIgnoreCase("Call-me")) {

            valueItems.add(new ValueItem("Alexa, call the last number", false));
            valueItems.add(new ValueItem("Alexa, answer the call", false));
            valueItems.add(new ValueItem("Alexa, pick up", false));
            valueItems.add(new ValueItem("Alexa, hang up", false));
            valueItems.add(new ValueItem("Alexa, end the call", false));
            valueItems.add(new ValueItem("Alexa, call 123456789 on speakerphone", false));
            valueItems.add(new ValueItem("Alexa, call Daddy's mobile phone", false));
            valueItems.add(new ValueItem("Alexa, call Mummy on speakerphone", false));
            valueItems.add(new ValueItem("Alexa, dial friend", false));
            valueItems.add(new ValueItem("Alexa, stop the call", false));
            valueItems.add(new ValueItem("Alexa, change my name.", false));
            valueItems.add(new ValueItem("Alexa, send a voice message to Daddy", false));
            valueItems.add(new ValueItem("Alexa, decline the call.", false));
            valueItems.add(new ValueItem("Alexa, who did I call last?", false));
            valueItems.add(new ValueItem("Alexa, what are my recent calls?", false));

        }
        if (commands.equalsIgnoreCase("Echo")) {

            valueItems.add(new ValueItem("Alexa, what can you show me?", false));
            valueItems.add(new ValueItem("Alexa, show the living room camera", false));
            valueItems.add(new ValueItem("Alexa, show the weekend forecast", false));
            valueItems.add(new ValueItem("Alexa, show me some interesting videos on YouTube", false));
            valueItems.add(new ValueItem("Alexa, show me a recipe from AllRecipes", false));
            valueItems.add(new ValueItem("Alexa, play my video", false));
            valueItems.add(new ValueItem("Alexa, show me my timers", false));
            valueItems.add(new ValueItem("Alexa, open an uber app", false));
            valueItems.add(new ValueItem("Alexa, shoe me a movie show times", false));
            valueItems.add(new ValueItem("Alexa, help me learn a new language.", false));
            valueItems.add(new ValueItem("Alexa, recommend a book to read.", false));
            valueItems.add(new ValueItem("Alexa, tell me a science fact.", false));
            valueItems.add(new ValueItem("Alexa, clear my to-do list.", false));
            valueItems.add(new ValueItem("Alexa, give me the latest news headlines.", false));
            valueItems.add(new ValueItem("Alexa, show me the front door camera.", false));

        }
        if (commands.equalsIgnoreCase("EQ-Control")) {

            valueItems.add(new ValueItem("Alexa, set the treble to three", false));
            valueItems.add(new ValueItem("Alexa, set night mode", false));
            valueItems.add(new ValueItem("Alexa, increase bass", false));
            valueItems.add(new ValueItem("Alexa, decrease bass", false));
            valueItems.add(new ValueItem("Alexa, increase bass in living room", false));
            valueItems.add(new ValueItem("Alexa, set night mode on bedroom tv", false));
            valueItems.add(new ValueItem("Alexa, set movie mode", false));
            valueItems.add(new ValueItem("Alexa, set bass to two on the soundbar", false));
            valueItems.add(new ValueItem("Alexa, decrease treble", false));
            valueItems.add(new ValueItem("Alexa, disable night mode", false));
            valueItems.add(new ValueItem("Alexa, save these EQ settings as 'Party Mode' ", false));
            valueItems.add(new ValueItem("Alexa, load 'Movie Night' EQ preset.", false));
            valueItems.add(new ValueItem("Alexa, set the equalizer to 'Custom EQ 1.'", false));
            valueItems.add(new ValueItem("Alexa, create a new EQ profile called 'Chillout.'", false));
            valueItems.add(new ValueItem("Alexa, decrease the 10 kHz frequency by 2 decibels.", false));

        }
        if (commands.equalsIgnoreCase("Family")) {

            valueItems.add(new ValueItem("Alexa, Send hug to mummy through whatsapp", false));
            valueItems.add(new ValueItem("Alexa, call my Daddy", false));
            valueItems.add(new ValueItem("Alexa, drop a message on family whatsapp group", false));
            valueItems.add(new ValueItem("Alexa, play a multiplayer game", false));
            valueItems.add(new ValueItem("Alexa, start a trivia game for 5 members", false));
            valueItems.add(new ValueItem("Alexa, play a movie for the whole family", false));
            valueItems.add(new ValueItem("Alexa, show photo memories with grandmother", false));
            valueItems.add(new ValueItem("Alexa, create a shared shopping list for [family/friends]", false));
            valueItems.add(new ValueItem("Alexa, remind me to call Hensie on her birthday", false));
            valueItems.add(new ValueItem("Alexa, remind me to wish friend a happy anniversary", false));
            valueItems.add(new ValueItem("Alexa, what's on the family calendar for next week?", false));
            valueItems.add(new ValueItem("Alexa, when is the next family gathering?", false));
            valueItems.add(new ValueItem("Alexa, create a reminder for our family vacation.", false));
            valueItems.add(new ValueItem("Alexa, tell me a science fact for a school project.", false));
            valueItems.add(new ValueItem("Alexa, what are some good educational apps for kids?", false));

        }
        if (commands.equalsIgnoreCase("Food")) {

            valueItems.add(new ValueItem("Alexa, find restaurants near me", false));
            valueItems.add(new ValueItem("Alexa, search for pizza places in Vesu", false));
            valueItems.add(new ValueItem("Alexa, where is the nearest grocery store?", false));
            valueItems.add(new ValueItem("Alexa, find coffee shops in Surat", false));
            valueItems.add(new ValueItem("Alexa, tell me about Construction", false));
            valueItems.add(new ValueItem("Alexa, what are the customer reviews for Starbucks", false));
            valueItems.add(new ValueItem("Alexa, find food delivery near me", false));
            valueItems.add(new ValueItem("Alexa, suggest a recipe for noodles", false));
            valueItems.add(new ValueItem("Alexa, what are some healthy recipes?", false));
            valueItems.add(new ValueItem("Alexa, what are some low-carb recipes?", false));
            valueItems.add(new ValueItem("Alexa, what's on my shopping list?", false));
            valueItems.add(new ValueItem("Alexa, find Italian restaurants nearby.", false));
            valueItems.add(new ValueItem("Alexa, recommend a romantic restaurant for date night.", false));
            valueItems.add(new ValueItem("Alexa, tell me a fun food fact.", false));
            valueItems.add(new ValueItem("Alexa, share a food-related joke.", false));

        }
        if (commands.equalsIgnoreCase("Christmas")) {

            valueItems.add(new ValueItem("Alexa, turn on the Christmas tree", false));
            valueItems.add(new ValueItem("Alexa, turn off the Christmas tree", false));
            valueItems.add(new ValueItem("Alexa, activate the Christmas tree", false));
            valueItems.add(new ValueItem("Alexa, set the Christmas tree brightness to 10%", false));
            valueItems.add(new ValueItem("Alexa, dim the Christmas tree lights", false));
            valueItems.add(new ValueItem("Alexa, brighten the Christmas tree lights", false));
            valueItems.add(new ValueItem("Alexa, set the Christmas tree color to red", false));
            valueItems.add(new ValueItem("Alexa, change the Christmas tree lights to pink", false));
            valueItems.add(new ValueItem("Alexa, enable the Christmas tree twinkle effect", false));
            valueItems.add(new ValueItem("Alexa, set the Christmas tree lights to pulse", false));
            valueItems.add(new ValueItem("Alexa, where can I find the best deals for Christmas gifts?", false));
            valueItems.add(new ValueItem("Alexa, what are the top Christmas gifts this year?", false));
            valueItems.add(new ValueItem("Alexa, tell me a Santa joke.", false));
            valueItems.add(new ValueItem("Alexa, open Christmas Countdown.", false));
            valueItems.add(new ValueItem("Alexa, how many days until Christmas?", false));

        }
        if (commands.equalsIgnoreCase("Skills")) {

            valueItems.add(new ValueItem("Alexa, open airplay", false));
            valueItems.add(new ValueItem("Alexa, enable jeopardy", false));
            valueItems.add(new ValueItem("Alexa, disable whatsapp notification", false));
            valueItems.add(new ValueItem("Alexa, launch cooking skill", false));
            valueItems.add(new ValueItem("Alexa, disable dominoes", false));
            valueItems.add(new ValueItem("Alexa, open the bartender", false));
            valueItems.add(new ValueItem("Alexa, remove cooking from my skills", false));
            valueItems.add(new ValueItem("Alexa, Go to Sleep", false));
            valueItems.add(new ValueItem("Alexa, Play set Volume to 10", false));
            valueItems.add(new ValueItem("Alexa, open Zomato", false));
            valueItems.add(new ValueItem("Alexa, can you order a pizza with extra cheese", false));
            valueItems.add(new ValueItem("Alexa, what are the top skills?", false));
            valueItems.add(new ValueItem("Alexa, find skills for cooking.", false));
            valueItems.add(new ValueItem("Alexa, suggest a fitness skill.", false));
            valueItems.add(new ValueItem("Alexa, what skills do I have enabled?", false));

        }
        if (commands.equalsIgnoreCase("Local")) {

            valueItems.add(new ValueItem("Alexa, what's the weather like?", false));
            valueItems.add(new ValueItem("Alexa, what's the temperature in Surat?", false));
            valueItems.add(new ValueItem("Alexa, what's the forecast for tomorrow?", false));
            valueItems.add(new ValueItem("Alexa, what's the weather in Junagadh this weekend?", false));
            valueItems.add(new ValueItem("Alexa, what's the traffic like?", false));
            valueItems.add(new ValueItem("Alexa, what's the traffic?", false));
            valueItems.add(new ValueItem("Alexa, how long will is destination?", false));
            valueItems.add(new ValueItem("Alexa, is there traffic incidents on my route?", false));
            valueItems.add(new ValueItem("Alexa, tell me a joke", false));
            valueItems.add(new ValueItem("Alexa, give me a fun fact", false));
            valueItems.add(new ValueItem("Alexa, where's the nearest gas station?", false));
            valueItems.add(new ValueItem("Alexa, recommend a local plumber.", false));
            valueItems.add(new ValueItem("Alexa, recommend a nearby Chinese restaurant.", false));
            valueItems.add(new ValueItem("Alexa, tell me interesting facts about Surat.", false));
            valueItems.add(new ValueItem("Alexa, what movies are playing at the theaters in Junagadh", false));

        }
        if (commands.equalsIgnoreCase("Music")) {

            valueItems.add(new ValueItem("Alexa, Play music", false));
            valueItems.add(new ValueItem("Alexa, Sing Jingle Bells", false));
            valueItems.add(new ValueItem("Alexa, Sing Auld Lang Syne", false));
            valueItems.add(new ValueItem("Alexa, Sing your new Christmas song", false));
            valueItems.add(new ValueItem("Alexa, Sing a christmas carol", false));
            valueItems.add(new ValueItem("Alexa, Play music for a party", false));
            valueItems.add(new ValueItem("Alexa, Play family friendly music", false));
            valueItems.add(new ValueItem("Alexa, create a new playlist", false));
            valueItems.add(new ValueItem("Alexa, skip the song", false));
            valueItems.add(new ValueItem("Alexa, loop this playlist", false));
            valueItems.add(new ValueItem("Alexa, play the song 'Imagine' by John Lennon.", false));
            valueItems.add(new ValueItem("Alexa, play relaxing music.", false));
            valueItems.add(new ValueItem("Alexa, shuffle my playlist.", false));
            valueItems.add(new ValueItem("Alexa, repeat this song.", false));
            valueItems.add(new ValueItem("Alexa, what's a popular song right now?", false));

        }
        if (commands.equalsIgnoreCase("Notifications")) {

            valueItems.add(new ValueItem("Alexa, do I have any notifications?", false));
            valueItems.add(new ValueItem("Alexa, check my notifications", false));
            valueItems.add(new ValueItem("Alexa, what are my notifications?", false));
            valueItems.add(new ValueItem("Alexa, read the latest notification", false));
            valueItems.add(new ValueItem("Alexa, dismiss all notifications", false));
            valueItems.add(new ValueItem("Alexa, clear my notifications", false));
            valueItems.add(new ValueItem("Alexa, enable notifications for WhatsApp", false));
            valueItems.add(new ValueItem("Alexa, disable notifications for SnapChat", false));
            valueItems.add(new ValueItem("Alexa, configure notifications", false));
            valueItems.add(new ValueItem("Alexa, manage my notification preferences", false));
            valueItems.add(new ValueItem("Alexa, tell daddy to check their notifications.", false));
            valueItems.add(new ValueItem("Alexa, what notifications do I have from mummy?", false));
            valueItems.add(new ValueItem("Alexa, turn on 'Do Not Disturb.", false));
            valueItems.add(new ValueItem("Alexa, how much time is left on the timer?", false));
            valueItems.add(new ValueItem("Alexa, pause the timer", false));

        }
        if (commands.equalsIgnoreCase("Recipe")) {

            valueItems.add(new ValueItem("Alexa, Give me nutrition tips", false));
            valueItems.add(new ValueItem("Alexa, find a recipe for cheesy pasta", false));
            valueItems.add(new ValueItem("Alexa, suggest a cuisine recipe", false));
            valueItems.add(new ValueItem("Alexa, how much pizza sauce do I need for pizza?", false));
            valueItems.add(new ValueItem("Alexa, how many calories are in [food item]?", false));
            valueItems.add(new ValueItem("Alexa, how much protein is in oats?", false));
            valueItems.add(new ValueItem("Alexa, what can I use as a substitute for cheese in pasta?", false));
            valueItems.add(new ValueItem("Alexa, what is a healthier recipe of oats", false));
            valueItems.add(new ValueItem("Alexa, how many tablespoons are in a cup?", false));
            valueItems.add(new ValueItem("Alexa, how many ounces are in 100 grams?", false));
            valueItems.add(new ValueItem("Alexa, convert cups to grams in this recipe.", false));
            valueItems.add(new ValueItem("Alexa, how many tablespoons are in a quarter-cup?", false));
            valueItems.add(new ValueItem("Alexa, what's the equivalent of one ounce in milliliters?", false));
            valueItems.add(new ValueItem("Alexa, what are the user reviews for this recipe?", false));
            valueItems.add(new ValueItem("Alexa, rate this pasta recipe.", false));

        }
        if (commands.equalsIgnoreCase("Remote")) {

            valueItems.add(new ValueItem("Alexa, water the lawn.", false));
            valueItems.add(new ValueItem("Alexa, schedule the sprinklers for Monday at 7 AM.", false));
            valueItems.add(new ValueItem("Alexa, play music", false));
            valueItems.add(new ValueItem("Alexa, Stop irrigation system ", false));
            valueItems.add(new ValueItem("Alexa, rewind this song", false));
            valueItems.add(new ValueItem("Alexa, open spotify", false));
            valueItems.add(new ValueItem("Alexa, search for flowers", false));
            valueItems.add(new ValueItem("Alexa, go to Home", false));
            valueItems.add(new ValueItem("Alexa, show me my Watchlist", false));
            valueItems.add(new ValueItem("Alexa, turn on TV", false));
            valueItems.add(new ValueItem("Alexa, what's the status of the dishwasher?", false));
            valueItems.add(new ValueItem("Alexa, set a timer for the microwave for 2 minutes.", false));
            valueItems.add(new ValueItem("Alexa, start the coffee maker.", false));
            valueItems.add(new ValueItem("Alexa, preheat the oven to 350 degrees.", false));
            valueItems.add(new ValueItem("Alexa, stop the irrigation system.", false));

        }
        if (commands.equalsIgnoreCase("Ring")) {

            valueItems.add(new ValueItem("Alexa, show me the gate number 1", false));
            valueItems.add(new ValueItem("Alexa, show my front door", false));
            valueItems.add(new ValueItem("Alexa, enable ring alerts", false));
            valueItems.add(new ValueItem("Alexa, disable ring alerts", false));
            valueItems.add(new ValueItem("Alexa, notify me when there is motion at gate number 4", false));
            valueItems.add(new ValueItem("Alexa, turn off doorbell", false));
            valueItems.add(new ValueItem("Alexa, speak to the person standing in front of the camera", false));
            valueItems.add(new ValueItem("Alexa, stop listening", false));
            valueItems.add(new ValueItem("Alexa, trigger the alarm", false));
            valueItems.add(new ValueItem("Alexa, dim the lights", false));
            valueItems.add(new ValueItem("Alexa, view the backyard camera.", false));
            valueItems.add(new ValueItem("Alexa, check the status of Ring Alarm.", false));
            valueItems.add(new ValueItem("Alexa, disarm the security system.", false));
            valueItems.add(new ValueItem("Alexa, is the security system armed?", false));
            valueItems.add(new ValueItem("Alexa, change Ring to Away mode.", false));

        }
        if (commands.equalsIgnoreCase("Robot")) {

            valueItems.add(new ValueItem("Alexa, ask robot to move forward", false));
            valueItems.add(new ValueItem("Alexa, tell robot to turn right", false));
            valueItems.add(new ValueItem("Alexa, is the robot finished cleaning?", false));
            valueItems.add(new ValueItem("Alexa, send the robot to the bedroom.", false));
            valueItems.add(new ValueItem("Alexa, clean the kitchen.", false));
            valueItems.add(new ValueItem("Alexa, ask robot to tell a joke", false));
            valueItems.add(new ValueItem("Alexa, tell robot to perform a trick", false));
            valueItems.add(new ValueItem("Alexa, vacuum the living room.", false));
            valueItems.add(new ValueItem("Alexa, tell robot to play music", false));
            valueItems.add(new ValueItem("Alexa, schedule the robot to clean at 10 AM.", false));
            valueItems.add(new ValueItem("Alexa, set the robot to high-power mode.", false));
            valueItems.add(new ValueItem("Alexa, send the robot back to the dock.", false));
            valueItems.add(new ValueItem("Alexa, what's the battery level of the robot?", false));
            valueItems.add(new ValueItem("Alexa, how long has the robot been cleaning?", false));
            valueItems.add(new ValueItem("Alexa, check the robot's error status.", false));

        }
        if (commands.equalsIgnoreCase("Settled-score")) {

            valueItems.add(new ValueItem("Alexa, roll a dice", false));
            valueItems.add(new ValueItem("Alexa, roll a 26 sided dice", false));
            valueItems.add(new ValueItem("Alexa, flip a coin", false));
            valueItems.add(new ValueItem("Alexa, pick a number between 1 and 50", false));
            valueItems.add(new ValueItem("Alexa, schedule a meeting with Ramesh at 10 AM on 25/12/2023", false));
            valueItems.add(new ValueItem("Alexa, remind me to have a calm discussion with Mahesh about project on 10/12/2023 at 5 PM", false));
            valueItems.add(new ValueItem("Alexa, find mediation services near me", false));
            valueItems.add(new ValueItem("Alexa, search for relationship counseling resources", false));
            valueItems.add(new ValueItem("Alexa, give me a motivational quote", false));
            valueItems.add(new ValueItem("Alexa, give me a positive affirmation", false));
            valueItems.add(new ValueItem("Alexa, tell me the current credit score.", false));
            valueItems.add(new ValueItem("Alexa, tell me the latest NBA scores.", false));
            valueItems.add(new ValueItem("Alexa, give me the baseball scores for today.", false));
            valueItems.add(new ValueItem("Alexa, check my test scores.", false));
            valueItems.add(new ValueItem("Alexa, what was the score of the Indian team last night?", false));

        }
        if (commands.equalsIgnoreCase("Shopping")) {

            valueItems.add(new ValueItem("Alexa, I need to buy TShirt", false));
            valueItems.add(new ValueItem("Alexa, put red top on my shopping list", false));
            valueItems.add(new ValueItem("Alexa, add jeans to my cart", false));
            valueItems.add(new ValueItem("Alexa, what's on my shopping list?", false));
            valueItems.add(new ValueItem("Alexa, read my shopping list", false));
            valueItems.add(new ValueItem("Alexa, order denim jeans", false));
            valueItems.add(new ValueItem("Alexa, where's my package?", false));
            valueItems.add(new ValueItem("Alexa, track my order", false));
            valueItems.add(new ValueItem("Alexa, when will my order arrive?", false));
            valueItems.add(new ValueItem("Alexa, add bread and cheese to my cart.", false));
            valueItems.add(new ValueItem("Alexa, what are the deals of the day?", false));
            valueItems.add(new ValueItem("Alexa, recommend a popular book.", false));
            valueItems.add(new ValueItem("Alexa, find the best-rated headphones.", false));
            valueItems.add(new ValueItem("Alexa, what's the price of shoes on Amazon?", false));
            valueItems.add(new ValueItem("Alexa, when will my order arrive?", false));

        }
        if (commands.equalsIgnoreCase("Show")) {

            valueItems.add(new ValueItem("Alexa, show me today's weather", false));
            valueItems.add(new ValueItem("Alexa, show my calendar for today", false));
            valueItems.add(new ValueItem("Alexa, show movie trailers on the screen", false));
            valueItems.add(new ValueItem("Alexa, show me the front door", false));
            valueItems.add(new ValueItem("Alexa, play songs on YouTube", false));
            valueItems.add(new ValueItem("Alexa, show comedy movies on Fire TV", false));
            valueItems.add(new ValueItem("Alexa, show my photos", false));
            valueItems.add(new ValueItem("Alexa, show my skills", false));
            valueItems.add(new ValueItem("Alexa, show me more about this skill", false));
            valueItems.add(new ValueItem("Alexa, show skill cards", false));
            valueItems.add(new ValueItem("Alexa, show my Flash Briefing.", false));
            valueItems.add(new ValueItem("Alexa, customize my display settings.", false));
            valueItems.add(new ValueItem("Alexa, show me travel documentaries.", false));
            valueItems.add(new ValueItem("Alexa, show me movie trailers.", false));
            valueItems.add(new ValueItem("Alexa, show me the recipe steps.", false));

        }
        if (commands.equalsIgnoreCase("Spotify")) {

            valueItems.add(new ValueItem("Alexa, Volume up", false));
            valueItems.add(new ValueItem("Alexa, Volume down", false));
            valueItems.add(new ValueItem("Alexa, Resume", false));
            valueItems.add(new ValueItem("Alexa, Stop", false));
            valueItems.add(new ValueItem("Alexa, Next", false));
            valueItems.add(new ValueItem("Alexa, play last song", false));
            valueItems.add(new ValueItem("Alexa, play favorite playlist on spotify", false));
            valueItems.add(new ValueItem("Alexa, tell about Arijit Singh", false));
            valueItems.add(new ValueItem("Alexa, add this song to playlist", false));
            valueItems.add(new ValueItem("Alexa, play romantic songs", false));
            valueItems.add(new ValueItem("Alexa, add this song to my 'Party' playlist on Spotify.", false));
            valueItems.add(new ValueItem("Alexa, delete my 'Workout' playlist on Spotify.", false));
            valueItems.add(new ValueItem("Alexa, go back to the previous track.", false));
            valueItems.add(new ValueItem("Alexa, what album is this from?", false));
            valueItems.add(new ValueItem("Alexa, shuffle my 'Favorites' playlist on Spotify.", false));
        }

        name.setText(commands);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ValueActivity.this, Home.class);
//                startActivity(intent);
                finish();
            }
        });

        ValueAdapter valueAdapter = new ValueAdapter(valueItems, ValueActivity.this, ValueActivity.this);
        lv1.setAdapter(valueAdapter);

    }

    @Override
    public void getmypos(int pos) {

        commands = valueItems.get(pos).getText();
        finish();
    }
}
