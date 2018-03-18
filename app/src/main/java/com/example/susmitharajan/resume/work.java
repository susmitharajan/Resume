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

public class work extends Activity {
    SharedPreferences sf;
    EditText ecompany,ejob_profile,eCstartDate,ECendDate,ejob_description;
    public static final String preferences = "pref";
    public static final String company = "company";
    public static final String job_profile = "job_profile";
    public static final String CstartDate = "CstartDate";
    public static final String CendDate = "CendDate";
    public static final String job_description = "job_description";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.work);
        ecompany = (EditText) findViewById(R.id.company);
        ejob_profile = (EditText) findViewById(R.id.job_profile);
        eCstartDate = (EditText) findViewById(R.id.startDate);
        ECendDate = (EditText) findViewById(R.id.endDate);
        ejob_description = (EditText) findViewById(R.id.job_description);
        sf = getSharedPreferences(preferences, Context.MODE_PRIVATE);

        if (sf.contains(company)) {
            ecompany.setText(sf.getString(company, ""));
        }
        if (sf.contains(job_profile)) {
            ejob_profile.setText(sf.getString(job_profile, ""));
        }
        if (sf.contains(CstartDate)) {
            eCstartDate.setText(sf.getString(CstartDate, ""));
        }
        if (sf.contains(CendDate)) {
            ECendDate.setText(sf.getString(CendDate, ""));
        }
        if(sf.contains(job_description)){
            ejob_description.setText(sf.getString(job_description,""));
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String company1 = ecompany.getText().toString();
        String job_profle1 = ejob_profile.getText().toString();
        String startdate1 = eCstartDate.getText().toString();
        String endDate1 = ECendDate.getText().toString();
        String job_description1 = ejob_description.getText().toString();
        SharedPreferences.Editor editor = sf.edit();
        editor.putString(company, company1);
        editor.putString(job_profile, job_profle1);
        editor.putString(CstartDate, startdate1);
        editor.putString(CendDate, endDate1);
        editor.putString(job_description, job_description1);
        editor.commit();
        finish();
    }
}
