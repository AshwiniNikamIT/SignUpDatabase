package com.example.signupdatabase;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    database mydb;

    EditText firstName;
    EditText lastName;
    TextInputLayout emailAd;
    TextInputLayout pass;
    TextInputLayout conPassw;
    Button sing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mydb = new database(this);

        firstName = findViewById(R.id.first);
        lastName = findViewById(R.id.last);
        emailAd = findViewById(R.id.textEmail);
        pass = findViewById(R.id.text_input_password);
        conPassw = findViewById(R.id.text_con_password);
        sing = findViewById(R.id.signUp);

        sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fname = firstName.getText().toString();
                String lmame = lastName.getText().toString();
                String em = emailAd.getEditText().getText().toString();
                String pas = pass.getEditText().getText().toString();
                String conPas = conPassw.getEditText().getText().toString();

                if (fname.equals("") || lmame.equals("") || em.equals("") || pas.equals("") || conPas.equals("") == true) {
                    Toast.makeText(getApplicationContext(), "Please enter all details.", Toast.LENGTH_SHORT).show();
                } else
                    {
                    if (pas.equals(conPas)) {
                        Boolean b = mydb.checkMail(em);
                        if (b == false) {
                            emailAd.setError("Email already exixts.");
                        } else {
                            mydb.insertData(fname, lmame, em, pas);
                            Intent intent = new Intent(SignUp.this, welcome.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "You have successfully registered.", Toast.LENGTH_LONG).show();
                        }


                    } else
                        {
                        conPassw.setError("Password doesn't match");
                    }
                }
            }
        });

    }

}




