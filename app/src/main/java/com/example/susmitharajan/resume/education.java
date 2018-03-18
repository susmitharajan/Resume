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

public class education extends Activity {
    SharedPreferences sf;
    EditText ecollege,ecourse,estartDate,EendDate;
    public static final String preferences = "pref";
    public static final String college = "college";
    public static final String course = "course";
    public static final String startDate = "startDate";
    public static final String endDate = "endDate";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.education);
        ecollege = (EditText) findViewById(R.id.college);
        ecourse = (EditText) findViewById(R.id.course);
        estartDate = (EditText) findViewById(R.id.startDate);
        EendDate = (EditText) findViewById(R.id.endDate);
        sf = getSharedPreferences(preferences, Context.MODE_PRIVATE);

        if (sf.contains(college)) {
            ecollege.setText(sf.getString(college, ""));
        }
        if(sf.contains(course)){
            ecourse.setText(sf.getString(course, ""));
        }
        if(sf.contains(startDate)){
            estartDate.setText(sf.getString(startDate,""));
        }
        if(sf.contains(endDate)){
            EendDate.setText(sf.getString(endDate,""));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String college1 = ecollege.getText().toString();
        String course1 = ecourse.getText().toString();
        String startdate1 = estartDate.getText().toString();
        String endDate1 = EendDate.getText().toString();
        SharedPreferences.Editor editor = sf.edit();
        editor.putString(college, college1);
        editor.putString(course, course1);
        editor.putString(startDate, startdate1);
        editor.putString(endDate, endDate1);
        editor.commit();
        finish();
    }
}
