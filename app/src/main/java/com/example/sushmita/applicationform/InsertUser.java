package com.example.sushmita.applicationform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InsertUser extends AppCompatActivity {
    EditText t1, t2, t3, t4;
    MyDbHandler myDbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user);
        t1 = (EditText) findViewById(R.id.textView2);
        t2 = (EditText) findViewById(R.id.textView3);
        t3 = (EditText) findViewById(R.id.textView4);
        t4 = (EditText) findViewById(R.id.textView5);
        myDbHandler = Temp.getMyDbHandler();

    }

    public void save(View view) {
        String id = t1.getText().toString();
        String name = t2.getText().toString();
        String email = t3.getText().toString();
        String phone = t4.getText().toString();
        if (id.equals("") || name.equals("") || email.equals("") || phone.equals("")) {
            Toast.makeText(this, "PLZZ!! fill valid details", Toast.LENGTH_SHORT).show();
        } else {
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setEmail(email);
            user.setPhone(phone);
            int i = myDbHandler.insertUser(user);
            if (i == 1) {
                Toast.makeText(this, "USER DATA INSERTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "DATA NOT INSERTED", Toast.LENGTH_SHORT).show();
            }

        }
    }
}

