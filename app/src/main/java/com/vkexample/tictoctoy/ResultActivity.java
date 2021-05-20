package com.vkexample.tictoctoy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        startActivity(new Intent(ResultActivity.this,MainActivity.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}