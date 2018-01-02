package com.everestadvanced.launcher;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    Button homescreen;
    private static String EnterAndroid = "12345";
    static String CombinationsKeyValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        homescreen= (Button) findViewById(R.id.button);
        homescreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                //builder.setTitle("Exit Application");
                builder.setMessage("Do You Wand to Exit !!!");
                //builder.setIcon(R.drawable.logo);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do do my action here

                        startActivity(new Intent("android.intent.action.DeskTop"));
                        dialog.dismiss();
                    }

                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // I do not need any action here you might

                        dialog.cancel();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
    @Override
    public void onBackPressed() {
        // nothing to do here
        // … really
    }

    public boolean requestPressKey(int paramInt)
    {
        Log.i("Tag", "requestPressKey() key = " + paramInt);
        if ((paramInt >= 7) && (paramInt <= 16))
        {
            String str = Integer.toString(paramInt - 7);
            CombinationsKeyValue = convertStringNull(CombinationsKeyValue) + str;
            if (CombinationsKeyValue.indexOf(EnterAndroid) != -1)
            {
                CombinationsKeyValue = "";
                Log.v("Tag", "key  OK!");
                startActivity(new Intent("android.intent.action.DeskTop"));
            }
            return true;
        }
        return false;
    }
    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
//        switch (paramInt)
//        {
//            default:return false;
//        }
        requestPressKey(paramInt);
        return true;
    }
    public static final String convertStringNull(String paramString)
    {
        if ((paramString == null) || (paramString.equals(null))) {
            return "";
        }
        return paramString;
    }

}
