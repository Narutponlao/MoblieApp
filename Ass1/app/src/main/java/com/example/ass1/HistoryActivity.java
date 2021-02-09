package com.example.ass1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class HistoryActivity extends AppCompatActivity {
    ListView listView1,listView2,listView3,listView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        listView1 = findViewById(R.id.listView1);
        listView2 = findViewById(R.id.listView2);
        listView3 = findViewById(R.id.listView3);
        listView4 = findViewById(R.id.listView4);

    load();

    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        final TextView txtView  = findViewById(R.id.textView1);
        final TextView txtView1 = findViewById(R.id.textView2);
        final TextView txtView2 = findViewById(R.id.textView3);
        final TextView txtView3 = findViewById(R.id.textView4);
        final TextView txtView4 = findViewById(R.id.textViewASS);
        txtView.setTextSize(getResources().getConfiguration().fontScale*15);
        txtView1.setTextSize(getResources().getConfiguration().fontScale*15);
        txtView2.setTextSize(getResources().getConfiguration().fontScale*15);
        txtView3.setTextSize(getResources().getConfiguration().fontScale*15);
        txtView4.setTextSize(getResources().getConfiguration().fontScale*15);
    }

    public void load(){
        try {
            FileInputStream fis = openFileInput("example1.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            String lines1;
            String lines1_toString;

            while((lines1=bufferedReader.readLine())!=null){
            stringBuffer.append(lines1);

            }
            lines1_toString = stringBuffer.toString();
            //Toast.makeText(this, lines1_toString, Toast.LENGTH_LONG).show();
            String[] pump1 = lines1_toString.split(";");
            ArrayAdapter<String> salesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,pump1);
            listView1.setAdapter(salesAdapter);
/*********************************************************************************************************************************************************/
            FileInputStream fis2 = openFileInput("example2.txt");
            InputStreamReader inputStreamReader2 = new InputStreamReader(fis2);
            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
            StringBuffer stringBuffer2 = new StringBuffer();
            String lines2;
            String lines2_toString;

            while((lines2=bufferedReader2.readLine())!=null){
                stringBuffer2.append(lines2);

            }
            lines2_toString = stringBuffer2.toString();
            // Toast.makeText(this, lines2_toString, Toast.LENGTH_LONG).show();
            String[] pump2 = lines2_toString.split(";");
            ArrayAdapter<String> sp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,pump2);
            listView2.setAdapter(sp);

/*********************************************************************************************************************************************************/
            FileInputStream fis3 = openFileInput("example3.txt");
            InputStreamReader inputStreamReader3 = new InputStreamReader(fis3);
            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader3);
            StringBuffer stringBuffer3 = new StringBuffer();
            String lines3;
            String lines3_toString;

            while((lines3=bufferedReader3.readLine())!=null){
                stringBuffer3.append(lines3);

            }
            lines3_toString = stringBuffer3.toString();
            //Toast.makeText(this, lines3_toString, Toast.LENGTH_LONG).show();
            String[] pump3 = lines3_toString.split(";");
            ArrayAdapter<String> sms = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,pump3);
            listView3.setAdapter(sms);
/*********************************************************************************************************************************************************/
            FileInputStream fis4 = openFileInput("example4.txt");
            InputStreamReader inputStreamReader4 = new InputStreamReader(fis4);
            BufferedReader bufferedReader4 = new BufferedReader(inputStreamReader4);
            StringBuffer stringBuffer4 = new StringBuffer();
            String lines4;
            String lines4_toString;

            while((lines4=bufferedReader4.readLine())!=null){
                stringBuffer4.append(lines4);

            }
            lines4_toString = stringBuffer4.toString();
           // Toast.makeText(this, lines1_toString, Toast.LENGTH_LONG).show();
            String[] pump4 = lines4_toString.split(";");
            ArrayAdapter<String> ss = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,pump4);
            listView4.setAdapter(ss);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }


}