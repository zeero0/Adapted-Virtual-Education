package com.zeeroapps.hackathonapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zeeroapps.hackathonapp.R;
import com.zeeroapps.hackathonapp.utils.LanguageSettings;

public class LearningActivity extends Activity implements View.OnClickListener {
    Button btnCourse1, btnCourse2, btnCourse3, btnCourse4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);

        btnCourse1 = (Button) findViewById(R.id.btnCourse1);
        btnCourse2 = (Button) findViewById(R.id.btnCourse2);
        btnCourse3 = (Button) findViewById(R.id.btnCourse3);
        btnCourse4 = (Button) findViewById(R.id.btnCourse4);
        btnCourse1.setOnClickListener(this);
        btnCourse2.setOnClickListener(this);
        btnCourse3.setOnClickListener(this);
        btnCourse4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCourse1:
                selectChallenge("autism");
                break;
            case R.id.btnCourse2:
                selectChallenge("intellectual");
                break;
            case R.id.btnCourse3:
                selectChallenge("learning");
                break;
            case R.id.btnCourse4:
                selectChallenge("schizophrenia");
                break;
            default:
                selectChallenge("autism");
                break;
        }
    }

    public void selectChallenge(String chall){
        SharedPreferences sp = getSharedPreferences(getString(R.string.my_sp), MODE_PRIVATE);
        sp.edit().putString(getString(R.string.my_sp_challenge), chall).commit();
        startActivity(new Intent(LearningActivity.this, MainActivity.class));
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

