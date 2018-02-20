package ru.sbertech.android.codegen.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ru.sbertech.android.codegen.myapplication.loggen.Factory$$$Autogenerate;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener((View v) -> {
           // Factory$$$Autogenerate.create("");
            new FactoryReflection(this);

        });
    }
}
