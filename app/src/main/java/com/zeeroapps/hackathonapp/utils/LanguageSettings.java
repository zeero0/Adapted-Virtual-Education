package com.zeeroapps.hackathonapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import com.zeeroapps.hackathonapp.R;

import java.util.Locale;

/**
 * Created by fazalullah on 8/20/17.
 */

public class LanguageSettings {

    public static void changeLanguage(Context context, String language) {
        String languageToLoad  = language;
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());

        SharedPreferences sp = context.getSharedPreferences(context.getString(R.string.my_sp), Context.MODE_PRIVATE);
        sp.edit().putString(context.getString(R.string.my_sp_language), language).commit();
    }
}