package com.badcompany.licensetest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Donatas on 26/08/2018.
 */

public class ProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //loadLocale();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);

        /*loginbtn = (Button) findViewById(R.id.btn_login);
        create = (Button) findViewById(R.id.btn_signup);
        txtlogin = (TextView) findViewById(R.id.input_email);
        txtpassword = (TextView) findViewById(R.id.input_password);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);*/

           /* loginbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //if (isNetworkAvailable()){
                    // if(isURLReachable(getApplicationContext(), SERVER_IP)){
                    try {
                        loginbtn.setEnabled(false);
                        String user = txtlogin.getText().toString();
                        String pass = txtpassword.getText().toString();
                        String[] details = new String[]{ user, pass};

                        new Authenticate().execute(details);

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Permission Denied!", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
            });
            create.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        create.setEnabled(false);
                        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                        startActivity(intent);
                    } catch (Exception e) {
                        System.out.println("STEP 7");
                        e.printStackTrace();
                    }
                }
            });*/

    }
}
