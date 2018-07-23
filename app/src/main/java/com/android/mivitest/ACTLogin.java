package com.android.mivitest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ACTLogin extends AppCompatActivity{

    @BindView(R.id.etAcNumber)
    EditText etMSNNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    public void onClick(View view) {
        String strMSNNumber = etMSNNumber.getText().toString().trim();
        if(strMSNNumber.equals(MIVIApplication.getAppInstance().getCollectionData().getUserData().getId()))
        {
            Intent intent = new Intent(ACTLogin.this, ACTDetails.class);
            startActivity(intent);
        }
        else
        {
            etMSNNumber.setError("Enter Valid Account Number");
        }
    }
}
