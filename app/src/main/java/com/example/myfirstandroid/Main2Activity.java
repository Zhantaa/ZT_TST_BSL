package com.example.myfirstandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        String username1=intent.getStringExtra("username");
        EditText editText=(EditText)findViewById(R.id.editText4);
        editText.setText(username1);

        final EditText password1=(EditText)findViewById(R.id.editText5);
        Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("password",password1.getText().toString());
                setResult(2,intent);
                finish();

            }
        });
    }
}
