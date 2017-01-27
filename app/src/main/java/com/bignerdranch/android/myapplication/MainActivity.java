package com.bignerdranch.android.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
                try {
                    TimeUnit.SECONDS.sleep(10);
                }catch (Exception e){}
                return null;
            }

            @Override
            protected void onProgressUpdate(Object[] values) {
                tw.setText("Process");
                super.onProgressUpdate(values);
            }
        }
        final my i=new my();
        tw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.execute();
            }
        });
    }
}
