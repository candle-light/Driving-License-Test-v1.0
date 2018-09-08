package com.badcompany.licensetest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Socket socket;
    private static final int SERVER_PORT = 22222;
    private static final String SERVER_IP = "62.75.189.139";

    private TextView txtlogin, txtpassword;
    private String username, id, def_lang = "en";
    private Uri imageUri;
    private Button theory, create;
    private ImageButton btnProfile;

    private int Msg_Code = 0, Err_Msg_Code = 0, Scs_Msg_Code = 0;

    private static final String SAVED_INSTANCE_URI = "uri";
    private static final String SAVED_INSTANCE_RESULT = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //loadLocale();

        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
       // if (isFirstRun()) {
            Toast.makeText(MainActivity.this, "Let's do something on first run", Toast.LENGTH_SHORT).show();
           //summonDialog();
            levelGuideDialogPopUp();
        //}
        theory = findViewById(R.id.btn_test);
        btnProfile = findViewById(R.id.imageView1);

       /* create = (Button) findViewById(R.id.btn_signup);
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
            }); */


        theory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // theory.setEnabled(false);
                    Intent intent = new Intent(getApplicationContext(), ChooseQuizActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // theory.setEnabled(false);
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMunuInflater = getMenuInflater();
        mMunuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*if(item.getItemId() == R.id.action_settings){
            //do settings
        }*/
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "pressed settings", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.action_report_bug:
                Toast.makeText(MainActivity.this, "report bug", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (imageUri != null) {
            outState.putString(SAVED_INSTANCE_URI, imageUri.toString());
            //outState.putString(SAVED_INSTANCE_RESULT, scanResults.getText().toString());
        }
        super.onSaveInstanceState(outState);
    }
    protected void summonDialog(){
        final  AlertDialog alertDialog  = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alert 3");
        alertDialog.setMessage("00:10");
        alertDialog.show();   //

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                alertDialog.setMessage("00:"+ (millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
               // info.setVisibility(View.GONE);
            }
        }.start();


    }
    protected void levelGuideDialogPopUp(){
        try {
            final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
            //mBuilder.setTitle("Choose Language..");
            View mView = getLayoutInflater().inflate(R.layout.dialog_level_guide, null);
             final TextView mainMessage = mView.findViewById(R.id.lvl_guide_info);
            final TextView lvlProgressBar = mView.findViewById(R.id.lvl_progress_bar);

            mBuilder.setView(mView);


            final AlertDialog alertDialog = mBuilder.create();
           /* LangEng.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        setLocale("en");
                        recreate();
                        dialog.dismiss();

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Couldn't change language", Toast.LENGTH_SHORT).show();
                        System.out.println("Couldn't change language");
                        e.printStackTrace();
                    }
                }
            });*/

            alertDialog.show();
            new CountDownTimer(20000, 100) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mainMessage.setText("MEssage" +(millisUntilFinished/1000));

                    //alertDialog.setMessage("00:"+ (millisUntilFinished/1000));
                }

                @Override
                public void onFinish() {
                    // info.setVisibility(View.GONE);
                }
            }.start();


        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Couldn't change language", Toast.LENGTH_SHORT).show();
            System.out.println("Couldn't change language");
            e.printStackTrace();
        }


    }

    protected void setLocale(String s) {
        Locale locale = new Locale(s);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
        editor.putString("def_lang", s);
        editor.apply();

    }

    protected void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        String lang = prefs.getString("def_lang", "");
        setLocale(lang);
        def_lang = lang;

    }

    private boolean isURLReachable(String s) {
        ///ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (isNetworkAvailable()) {
            //netInfo != null && netInfo.isConnected()) {
            try {
                URL url = new URL("http://" + s);   // "http://192.168.1.13"   Change to "http://google.com" for www  test.
                HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
                urlc.setConnectTimeout(10 * 1000);          // 10 s.
                urlc.connect();
                if (urlc.getResponseCode() == 200) {        // 200 = "OK" code (http connection is fine).
                    Log.wtf("Connection", "Success !");
                    System.out.println("Server is running!");
                    return true;
                } else {
                    return false;
                }
            } catch (MalformedURLException e1) {
                return false;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean isFirstRun() {
        boolean isFirstRun = getSharedPreferences("PREFERENCES", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (!isFirstRun)
            return false;
        else {// Place your dialog code here to display the dialog

            getSharedPreferences("PREFERENCES", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun", false)
                    .apply();
            return true;
        }
    }

    private class Authenticate extends AsyncTask<String[], Void, String> {
        private PrintWriter out;
        private BufferedReader in;
        private String[] details;

        @Override
        protected String doInBackground(String[]... params) {

            if (isNetworkAvailable()) {
                //netInfo != null && netInfo.isConnected()) {
                try {
                    URL url = new URL("http://" + SERVER_IP);   // "http://192.168.1.13"   Change to "http://google.com" for www  test.
                    HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
                    urlc.setConnectTimeout(10 * 1000);          // 10 s.
                    urlc.connect();
                    if (urlc.getResponseCode() == 200) {        // 200 = "OK" code (http connection is fine).
                        Log.wtf("Connection", "Success !");
                        System.out.println("Server is running!");
                        //return true;
                    } else {
                        System.out.println("Server is NOT running!");
                        // return false;
                    }
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                    //return false;
                } catch (IOException e) {
                    e.printStackTrace();
                    // return false;
                }
            }


            try {
                System.out.println("TOAST 1");
                InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
                socket = new Socket(serverAddr, SERVER_PORT);

                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            } catch (UnknownHostException e1) {
                e1.printStackTrace();
                System.out.println("TOAST 2");
                System.out.println("STEP 2.1");
            } catch (IOException e1) {
                System.out.println("TOAST 3");
                System.out.println("STEP 2.2");
                e1.printStackTrace();
            }
            details = params[0];
            System.out.println("Send this message");
            out.println(" Send this message \n");
            out.flush();

            System.out.println("Sent");
            String s = "", total = null;
            while (total == null) {
                System.out.println("Waiting");
                try {
                    s = in.readLine();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                total += s;
            }

            if (!s.equals("")) {
                String[] vars = s.split("\\s+");

                System.out.println(s);
                if (vars[0].equals("Err")) {
                    if (vars[1].equals("1")) Err_Msg_Code = 1;
                    if (vars[1].equals("2")) Err_Msg_Code = 2;
                    if (vars[1].equals("3")) Err_Msg_Code = 3;
                } else if (vars[0].equals("Scs")) {
                    Err_Msg_Code = 0;
                    id = vars[2];
                    username = vars[3] + " " + vars[4];
                    System.out.println("USERNAME >> " + username);

                    if (vars[1].equals("7")) { //seller
                        Scs_Msg_Code = 7;

                    } else if (vars[1].equals("8")) { //buyer
                        Scs_Msg_Code = 8;
                    }
                }


            }
            if (socket != null && !socket.isClosed()) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
            return "Finished";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            theory.setEnabled(true);
            if (Err_Msg_Code == 0) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("own_name", username);
                intent.putExtra("own_id", id);
                startActivity(intent);

            } else {
                System.out.println("Post Exe ERR" + Err_Msg_Code);
                switch (Err_Msg_Code) {
                    case 1:
                        Toast.makeText(MainActivity.this, "Email address already taken!", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "User not found!", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "User not found!", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, "User does not Have Sell permissions!", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(MainActivity.this, "User does not Have Buy permissions!", Toast.LENGTH_SHORT).show();
                        break;
                    case 11:
                        Toast.makeText(MainActivity.this, "No records yet..", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Unknown Error code: " + Err_Msg_Code, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }


        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

    }
}
