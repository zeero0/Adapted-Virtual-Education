package com.zeeroapps.hackathonapp.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zeeroapps.hackathonapp.R;
import com.zeeroapps.hackathonapp.utils.LanguageSettings;

public class SurveyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
    }

    public void onClickLanguageButton(View v){
        SharedPreferences sp = getSharedPreferences(getString(R.string.my_sp), MODE_PRIVATE);
        String curLang = sp.getString(getString(R.string.my_sp_language), null);
        if (curLang != null){
            if (curLang.equals("ur")){
                LanguageSettings.changeLanguage(this, "en");
            }else  {
                LanguageSettings.changeLanguage(this, "ur");
            }
        }
        this.recreate();
    }
}
