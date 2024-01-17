package com.tooandunitils.alexa;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class PreferenceHelper {

    private static final String PREFERENCES_NAME = "LikedItems";
    private static final String LIKED_ITEMS_KEY = "liked_items";

    private SharedPreferences preferences;

    public PreferenceHelper(Context context) {
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public Set<String> getLikedItems() {
        return preferences.getStringSet(LIKED_ITEMS_KEY, new HashSet<>());
    }

    public void addLikedItem(String item) {
        Set<String> likedItems = getLikedItems();
        likedItems.add(item);
        preferences.edit().putStringSet(LIKED_ITEMS_KEY, likedItems).apply();
    }

    public void removeLikedItem(String item) {
        Set<String> likedItems = getLikedItems();
        likedItems.remove(item);
        preferences.edit().putStringSet(LIKED_ITEMS_KEY, likedItems).apply();
    }
}
