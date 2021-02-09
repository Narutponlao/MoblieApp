package com.example.ass1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    Button button;
    EditText inputField1;
    EditText inputField2;
    Button historyButton;
    EditText inputField3;
    EditText inputField4;
    //Button deleteButton;
    String dum;
    float num1;
    DecimalFormat formatter = new DecimalFormat("#,###");
    DecimalFormat formatter1 = new DecimalFormat("#,###.##");
    private static final String FILE_NAME1 = "example1.txt";
    private static final String FILE_NAME2 = "example2.txt";
    private static final String FILE_NAME3 = "example3.txt";
    private static final String FILE_NAME4 = "example4.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        historyButton = findViewById(R.id.buttonHistory);
        button = findViewById(R.id.button1);
        inputField1 = findViewById(R.id.editTextNumberSigned1);
        inputField2 = findViewById(R.id.editTextNumberDecimal);
        inputField3 = findViewById(R.id.editTextNumberSigned2);
        inputField4 = findViewById(R.id.editTextNumberSigned3);
      //  deleteButton = findViewById(R.id.buttonDel);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                num1 = Float.valueOf(inputField1.getText().toString()) * (Float.valueOf(inputField2.getText().toString()) / 100);
                dum = formatter.format(num1);
                inputField4.setText(dum);

                num1 = Float.valueOf(inputField1.getText().toString()) - num1;
                dum = formatter.format(num1);
                inputField3.setText(dum);

                num1 = Float.valueOf(inputField1.getText().toString());
                dum = formatter.format(num1);
                inputField1.setText(dum);

                num1 = Float.valueOf(inputField2.getText().toString());
                dum = formatter1.format(num1);
                inputField2.setText(dum);
                save();
            }
        });

        historyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);

            }
        });
  /*  deleteButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            delete();
        }
    });
*/
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        final TextView txtView = findViewById(R.id.textView1);
        final TextView txtView1 = findViewById(R.id.textView2);
        final TextView txtView2 = findViewById(R.id.textView3);
        final TextView txtView3 = findViewById(R.id.textView4);
        final TextView txtView4 = findViewById(R.id.textViewASS);
        txtView.setTextSize(getResources().getConfiguration().fontScale * 15);
        txtView1.setTextSize(getResources().getConfiguration().fontScale * 15);
        txtView2.setTextSize(getResources().getConfiguration().fontScale * 15);
        txtView3.setTextSize(getResources().getConfiguration().fontScale * 15);
        txtView4.setTextSize(getResources().getConfiguration().fontScale * 15);
    }

    public void save() {
        String splitter = ";";
        String text = inputField1.getText().toString();
        String text2 = inputField2.getText().toString();
        String text3 = inputField3.getText().toString();
        String text4 = inputField4.getText().toString();

        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME1, MODE_APPEND);
            fos.write(text.getBytes());
            fos.write(splitter.getBytes());
            fos.close();
            fos = openFileOutput(FILE_NAME2, MODE_APPEND);
            fos.write(text2.getBytes());
            fos.write(splitter.getBytes());
            fos.close();
            fos = openFileOutput(FILE_NAME3, MODE_APPEND);
            fos.write(text3.getBytes());
            fos.write(splitter.getBytes());
            fos.close();
            fos = openFileOutput(FILE_NAME4, MODE_APPEND);
            fos.write(text4.getBytes());
            fos.write(splitter.getBytes());
            fos.close();

            //Toast.makeText(this,text4, Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

   /* public void delete() {
        File file1 = new File(getFilesDir(), FILE_NAME1);
        File file2 = new File(getFilesDir(), FILE_NAME2);
        File file3 = new File(getFilesDir(), FILE_NAME3);
        File file4 = new File(getFilesDir(), FILE_NAME4);
        if (file1.exists()) {
            deleteFile(FILE_NAME1);
            deleteFile(FILE_NAME2);
            deleteFile(FILE_NAME3);
            deleteFile(FILE_NAME4);
        } else {
            Toast.makeText(this, "File not found", Toast.LENGTH_LONG).show();

        }

*/
    }



