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

public class project extends Activity {
    SharedPreferences sf;
    EditText eproject_name,eproject_role,eCstartDate,ECendDate,eproject_description;
    public static final String preferences = "pref";
    public static final String project_name = "project_name";
    public static final String project_role = "project_role";
    public static final String pstartDate = "CstartDate";
    public static final String pendDate = "CendDate";
    public static final String project_description = "project_description";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project);
        eproject_name = (EditText) findViewById(R.id.project_name);
        eproject_role = (EditText) findViewById(R.id.project_role);
        eCstartDate = (EditText) findViewById(R.id.pstartDate);
        ECendDate = (EditText) findViewById(R.id.pendDate);
        eproject_description = (EditText) findViewById(R.id.project_description);
        sf = getSharedPreferences(preferences, Context.MODE_PRIVATE);

        if (sf.contains(project_name)) {
            eproject_name.setText(sf.getString(project_name, ""));
        }
        if (sf.contains(project_role)) {
            eproject_role.setText(sf.getString(project_role, ""));
        }
        if (sf.contains(pstartDate)) {
            eCstartDate.setText(sf.getString(pstartDate, ""));
        }
        if (sf.contains(pendDate)) {
            ECendDate.setText(sf.getString(pendDate, ""));
        }
        if(sf.contains(project_description)){
            eproject_description.setText(sf.getString(project_description,""));
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String project_name1 = eproject_name.getText().toString();
        String project_role1 = eproject_role.getText().toString();
        String pstartdate1 = eCstartDate.getText().toString();
        String pendDate1 = ECendDate.getText().toString();
        String project_description1 = eproject_description.getText().toString();
        SharedPreferences.Editor editor = sf.edit();
        editor.putString(project_name, project_name1);
        editor.putString(project_role, project_role1);
        editor.putString(pstartDate, pstartdate1);
        editor.putString(pendDate, pendDate1);
        editor.putString(project_description, project_description1);
        editor.commit();
        finish();
    }
}
