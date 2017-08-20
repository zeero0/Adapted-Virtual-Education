package com.zeeroapps.hackathonapp.utils;

import android.app.Application;
import android.content.SharedPreferences;

import com.zeeroapps.hackathonapp.R;

/**
 * Created by fazalullah on 8/20/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferences sp = getSharedPreferences(getString(R.string.my_sp), MODE_PRIVATE);
        String curLang = sp.getString(getString(R.string.my_sp_language), null);
        if (curLang != null){
            LanguageSettings.changeLanguage(this, curLang);
        }
    }
}
