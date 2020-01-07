package com.example.iu4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class lehrveranstaltungsverwaltunghs extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, loginas.class);

        startActivity(intent);

        finish();
    }


}
