package com.example.fragmentactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container,new FragmentRecycler());


//        if (savedInstanceState != null) {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.container,FragmentRecycler.newInstance()).commitNow();
//        }
    }


}