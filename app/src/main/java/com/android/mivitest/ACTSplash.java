package com.android.mivitest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.mivitest.model.CollectionData;
import com.android.mivitest.parser.ResponseJSONParser;
import com.android.mivitest.util.Utils;

public class ACTSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        MIVIApplication application = MIVIApplication.getAppInstance();
        CollectionData collectionData = ResponseJSONParser.getParsedResponse(Utils.readFromCollectionJSON(getAssets()));
        if (collectionData != null)
            application.setCollectionData(collectionData);
        else {
            Toast.makeText(this, "No data Available", Toast.LENGTH_SHORT).show();
        }

        loadHomeScreen();
    }

    private void loadHomeScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ACTSplash.this, ACTLogin.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
