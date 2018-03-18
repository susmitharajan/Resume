package com.example.susmitharajan.resume;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

/**
 * Created by susmitharajan on 17/03/18.
 */

public class personal extends Activity{
    SharedPreferences sf;
    EditText efirstname,elastname,ephone,Eemail;
    public static final String preferences = "pref";
    public static final String firstname = "firstname";
    public static final String lastname = "lastname";
    public static final String phone = "phone";
    public static final String email = "email";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal);
        efirstname = (EditText) findViewById(R.id.firstname);
        elastname = (EditText) findViewById(R.id.lastname);
        ephone = (EditText) findViewById(R.id.phone);
        Eemail = (EditText) findViewById(R.id.email);
        sf = getSharedPreferences(preferences, Context.MODE_PRIVATE);

        if (sf.contains(firstname)) {
            efirstname.setText(sf.getString(firstname, ""));
        }
        if(sf.contains(lastname)){
            elastname.setText(sf.getString(lastname, ""));
        }
        if(sf.contains(phone)){
            ephone.setText(sf.getString(phone,""));
        }
        if(sf.contains(email)){
            Eemail.setText(sf.getString(email,""));
        }
    }

    @Override
    public void onBackPressed() {
        String firstname1 = efirstname.getText().toString();
        String lastname1 = elastname.getText().toString();
        String phone1 = ephone.getText().toString();
        String email1 = Eemail.getText().toString();
        SharedPreferences.Editor editor = sf.edit();
        editor.putString(firstname, firstname1);
        editor.putString(lastname, lastname1);
        editor.putString(phone, phone1);
        editor.putString(email, email1);
        editor.commit();
        finish();
    }
}
