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

public class additional extends Activity {
    SharedPreferences sf;
    EditText elinkedin, egithub;
    public static final String preferences = "pref";
    public static final String linkedin_profile = "linkedin_profile";
    public static final String github_profile = "github_profile";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additional);
        elinkedin = (EditText) findViewById(R.id.linkedin);
        egithub = (EditText) findViewById(R.id.gihub);
        sf = getSharedPreferences(preferences, Context.MODE_PRIVATE);
        if (sf.contains(linkedin_profile)) {
            elinkedin.setText(sf.getString(linkedin_profile, ""));
        }
        if (sf.contains(github_profile)) {
            egithub.setText(sf.getString(github_profile, ""));
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String linkedin_profile1 = elinkedin.getText().toString();
        String github_profile1 = egithub.getText().toString();
        SharedPreferences.Editor editor = sf.edit();
        editor.putString(linkedin_profile, linkedin_profile1);
        editor.putString(github_profile, github_profile1);
        editor.commit();
        finish();
    }
}
