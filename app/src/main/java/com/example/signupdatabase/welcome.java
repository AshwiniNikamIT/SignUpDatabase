package com.example.signupdatabase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater Infalater=getMenuInflater();
        Infalater.inflate(R.menu.logout,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent in=new Intent(welcome.this,MainActivity.class);
        startActivity(in);
        return super.onOptionsItemSelected(item);
    }

}
