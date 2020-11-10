package com.example.fragmentactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


public class BlankFragment extends Fragment {

    private TextView textView;
    private ImageView imageView;
    private TextView textBodyView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       Bundle bundle = this.getArguments();
       Data model = (Data) bundle.getSerializable("keyModel");
        System.out.println(model.getTitle());
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        textView = (TextView) view.findViewById(R.id.secondTitle);
        textBodyView =(TextView) view.findViewById(R.id.bodySecondInfo);
        textBodyView.setMovementMethod(ScrollingMovementMethod.getInstance());
        imageView = (ImageView) view.findViewById(R.id.imageSecondView);
        textView.setText(model.getTitle());
        textBodyView.setText(model.getBodyInfo());
        Glide.with(this).load(model.getImage()).into(imageView);
       return view;
    }
}