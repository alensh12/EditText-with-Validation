package com.example.alensh.edittextvalidation;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher{
  EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (EditText)findViewById(R.id.validate_text);

        //Event Listener For EditText Validation
        txt.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Toast.makeText(this,"before Text Changed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Toast.makeText(this,"on text change",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterTextChanged(Editable s) {
        //Try catch if app crashed, when the value is erased
        try {int i = Integer.parseInt(s.toString());

           if (i > 100) {
               s.replace(0, s.length(), "100");
           }
       }

       catch(NumberFormatException e)
       {

       }
       }
    }

