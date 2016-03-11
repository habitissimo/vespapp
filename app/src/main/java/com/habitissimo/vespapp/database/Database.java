package com.habitissimo.vespapp.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.habitissimo.vespapp.Vespapp;
import com.habitissimo.vespapp.base.Controller;

public class Database {
    private SharedPreferences preferences;

    public Database(Context context) {
        preferences = context.getSharedPreferences("database", Context.MODE_PRIVATE);
    }

    public static Database get(Context context) {
        return Vespapp.get(context).getDatabase();
    }

    public static Database get(Controller controller) {
        return get(controller.getContext());
    }

    private SharedPreferences getPrefs() {
        return preferences;
    }

    public void save(String key, String value) {
        getStringPref(key).set(value);
    }

    public void save(String key, int value) {
        getIntPref(key).set(value);
    }

    public String load(String key) {
        return getStringPref(key).get();
    }

    public int loadInt(String key) {
        return getIntPref(key).get();
    }

    public void saveInt(String key, int value) {
        getIntPref(key).set(value);
    }

    @NonNull private StringPreference getStringPref(String key) {
        return new StringPreference(getPrefs(), key);
    }

    @NonNull private IntPreference getIntPref(String key) {
        return new IntPreference(getPrefs(), key);
    }
}
