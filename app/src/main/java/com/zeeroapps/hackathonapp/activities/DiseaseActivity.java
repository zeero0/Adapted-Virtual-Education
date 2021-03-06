package com.zeeroapps.hackathonapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zeeroapps.hackathonapp.R;
import com.zeeroapps.hackathonapp.utils.LanguageSettings;

public class DiseaseActivity extends Activity implements View.OnClickListener {
    Button btnChall1, btnChall2, btnChall3, btnChall4, btnIdentify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        btnChall1 = (Button) findViewById(R.id.btnChall1);
        btnChall2 = (Button) findViewById(R.id.btnChall2);
        btnChall3 = (Button) findViewById(R.id.btnChall3);
        btnChall4 = (Button) findViewById(R.id.btnChall4);
        btnIdentify = (Button) findViewById(R.id.btnIdentifyChall);
        btnChall1.setOnClickListener(this);
        btnChall2.setOnClickListener(this);
        btnChall3.setOnClickListener(this);
        btnChall4.setOnClickListener(this);
        btnIdentify.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnChall1:
                selectChallenge("autism");
                break;
            case R.id.btnChall2:
                selectChallenge("intellectual");
                break;
            case R.id.btnChall3:
                selectChallenge("learning");
                break;
            case R.id.btnChall4:
                selectChallenge("schizophrenia");
                break;
            case R.id.btnIdentifyChall:
                startActivity(new Intent(DiseaseActivity.this, SurveyActivity.class));
                break;
            default:
                selectChallenge("autism");
                break;
        }
    }

    public void selectChallenge(String chall){
        SharedPreferences sp = getSharedPreferences(getString(R.string.my_sp), MODE_PRIVATE);
        sp.edit().putString(getString(R.string.my_sp_challenge), chall).commit();
        startActivity(new Intent(DiseaseActivity.this, LearningActivity.class));
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
