package com.example.fragmentactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

     static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        newFragment(new FragmentRecycler());


    }

    public  void newFragment(Fragment fragment){
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }


}