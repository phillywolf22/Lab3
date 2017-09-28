package com.example.root.lab3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private static final String ACTIVITY_NAME="StartActivity";
    private String preference_key_file="FileCreated";

  EditText loginText;
    EditText passText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME," I am in OnStart()");

        Button loginButton = (Button) findViewById(R.id.button3);


//        loginText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences prefs = getSharedPreferences(
//                        "com.example.app", Context.MODE_PRIVATE);
//
//            }
//        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginText = (EditText) findViewById(R.id.loginEmail);
                passText = (EditText) findViewById(R.id.passw);

//                Toast toast = Toast.makeText(this , text, duration); //this is the ListActivity
//                toast.show();

                //setOnCheckedSaved();
                showSavedData();

                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);
                //showSavedData();


            }
        });




    }

    public void showSavedData(){

        Context context = this;
            SharedPreferences prefs1 = getSharedPreferences(preference_key_file, MODE_PRIVATE);


        String username1 = prefs1.getString("Login", "bla@gmail.com");

        String password1 = prefs1.getString("Password", "abc");

        loginText.setText(username1);
        passText.setText(password1);

        String name = prefs1.getString("Login","");
        String pw = prefs1.getString("Password", "");




        SharedPreferences.Editor editor = prefs1.edit();
        editor.putString(name,loginText.getText().toString());
        editor.putString(pw,passText.getText().toString());

        editor.apply();

            //prefs = getSharedPreferences("loginInfo1", Context.MODE_PRIVATE);



            setOnCheckedSaved();




    }

    public void displayData(){


    }
    public void setOnCheckedSaved(){
        CharSequence text = "SAVED!";// "Switch is Off"
        int duration = Toast.LENGTH_SHORT; //= Toast.LENGTH_LONG if Off
        Toast toast = Toast.makeText(this , text, duration); //this is the ListActivity
        toast.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME," I am in OnResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME," I am in OnStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME," I am in OnPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME," I am in OnStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME," I am in OnDestroy()");
    }



}
