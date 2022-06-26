package com.example.databasestarting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textview;
    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        TextView textview = findViewById(R.id.textview);
        EditText edittext= findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = edittext.getText().toString();
                SharedPreferences shrd = getSharedPreferences("demo", MODE_PRIVATE);
                SharedPreferences.Editor editor = shrd.edit();
                editor.putString("str", message);
                editor.apply();
                textview.setText(message);
            }
        });

        // get the value of shared preferences back]

        SharedPreferences getshared = getSharedPreferences("demo",MODE_PRIVATE);
        String value = getshared.getString("str","save the note and it will show up here");
        textview.setText(value);
    }
}