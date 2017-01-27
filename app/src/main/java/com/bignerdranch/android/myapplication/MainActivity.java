package com.bignerdranch.android.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tw=(TextView)findViewById(R.id.tw1);

        class my extends AsyncTask{
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                tw.setText("Begin");
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                tw.setText("End");
            }

            @Override
            protected Object doInBackground(Object[] params) {
                    TimeUnit t=new TimeUnit();
                t.sleep(10);
                return null;
            }
        }
        my i=new my();

    }
}
