package com.example.susmitharajan.resume;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import static com.example.susmitharajan.resume.additional.github_profile;
import static com.example.susmitharajan.resume.additional.linkedin_profile;
import static com.example.susmitharajan.resume.education.college;
import static com.example.susmitharajan.resume.education.course;
import static com.example.susmitharajan.resume.education.endDate;
import static com.example.susmitharajan.resume.education.startDate;
import static com.example.susmitharajan.resume.personal.email;
import static com.example.susmitharajan.resume.personal.firstname;
import static com.example.susmitharajan.resume.personal.lastname;
import static com.example.susmitharajan.resume.personal.phone;
import static com.example.susmitharajan.resume.work.CendDate;
import static com.example.susmitharajan.resume.work.CstartDate;
import static com.example.susmitharajan.resume.work.company;
import static com.example.susmitharajan.resume.work.job_description;
import static com.example.susmitharajan.resume.work.job_profile;

/**
 * Created by susmitharajan on 18/03/18.
 */

public class resume extends Activity {
    SharedPreferences sf;
    public static final String preferences = "pref";
    TextView rfirstname, rlastname, rphone, remail, rcollege, rcourse, rstartDate, rendDate;
    TextView rcompany,rjob_profile,tCstartDate,tCendDate,rjob_description, rlinkedin, rgithub;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resume);
        sf = getSharedPreferences(preferences, Context.MODE_PRIVATE);
        rfirstname = (TextView)findViewById(R.id.first_name);
        rlastname = (TextView)findViewById(R.id.last_name);
        rphone = (TextView) findViewById(R.id.phone);
        remail = (TextView) findViewById(R.id.email);

        rcollege = (TextView)findViewById(R.id.college);
        rcourse = (TextView) findViewById(R.id.course);
        rstartDate = (TextView) findViewById(R.id.startDate);
        rendDate = (TextView) findViewById(R.id.endDate);

        rcompany = (TextView) findViewById(R.id.company);
        rjob_profile = (TextView) findViewById(R.id.job_profile);
        tCstartDate = (TextView) findViewById(R.id.rstartDate);
        tCendDate = (TextView) findViewById(R.id.rendDate);
        rjob_description = (TextView) findViewById(R.id.job_description);

        rlinkedin = (TextView) findViewById(R.id.linkedin);
        rgithub = (TextView) findViewById(R.id.github);


        //personal information

        if (sf.contains(firstname)) {
           rfirstname.setText(sf.getString(firstname, ""));
        }
        if(sf.contains(lastname)){
            rlastname.setText(sf.getString(lastname, ""));
        }
        if(sf.contains(phone)){
            rphone.setText(sf.getString(phone,""));
        }
        if(sf.contains(email)){
            remail.setText(sf.getString(email,""));
        }

        //Education

        if (sf.contains(college)) {
            rcollege.setText(sf.getString(college, "")+"  ");
        }
        if(sf.contains(course)){
            rcourse.setText(sf.getString(course, ""));
        }
        if(sf.contains(startDate)){
            rstartDate.setText(sf.getString(startDate,"")+"-");
        }
        if(sf.contains(endDate)){
            rendDate.setText(sf.getString(endDate,""));
        }


        //Work Experience

        if (sf.contains(company)) {
            rcompany.setText(sf.getString(company, "")+ " ");
        }
        if (sf.contains(job_profile)) {
            rjob_profile.setText(sf.getString(job_profile, ""));
        }
        if (sf.contains(CstartDate)) {
            tCstartDate.setText(sf.getString(CstartDate, "")+"-");
        }
        if (sf.contains(CendDate)) {
            tCendDate.setText(sf.getString(CendDate, ""));
        }
        if(sf.contains(job_description)){
            rjob_description.setText(sf.getString(job_description,""));
        }


        if (sf.contains(linkedin_profile)) {
            rlinkedin.setText(sf.getString(linkedin_profile, ""));
        }
        if (sf.contains(github_profile)) {
            rgithub.setText(sf.getString(github_profile, ""));
        }


    }
}
