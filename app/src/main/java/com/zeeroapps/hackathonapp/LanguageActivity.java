package com.zeeroapps.hackathonapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zeeroapps.hackathonapp.utils.LanguageSettings;

public class LanguageActivity extends Activity implements View.OnClickListener {

    Button btnEng, btnUrdu, btnSindhi, btnPushto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        btnEng = (Button) findViewById(R.id.btnEnglish);
        btnUrdu = (Button) findViewById(R.id.btnUrdu);
        btnSindhi = (Button) findViewById(R.id.btnPunj);
        btnPushto = (Button) findViewById(R.id.btnPushto);
        btnEng.setOnClickListener(this);
        btnUrdu.setOnClickListener(this);
        btnSindhi.setOnClickListener(this);
        btnPushto.setOnClickListener(this);

        SharedPreferences sp = getSharedPreferences(getString(R.string.my_sp), MODE_PRIVATE);
        String curLang = sp.getString(getString(R.string.my_sp_language), null);
        if (curLang != null){
            changeLang(curLang);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnEnglish:
                changeLang("en");
                break;
            case R.id.btnUrdu:
                changeLang("ur");
                break;
            case R.id.btnPunj:
                changeLang("si");
                break;
            case R.id.btnPushto:
                changeLang("pu");
                break;
            default:
                changeLang("en");
                break;
        }
    }

    public void changeLang(String lang){
        LanguageSettings.changeLanguage(this, lang);
        startActivity(new Intent(LanguageActivity.this, DiseaseActivity.class));
        finish();
    }
}
