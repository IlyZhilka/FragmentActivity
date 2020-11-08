package com.example.fragmentactivity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class FragmentRecycler extends Fragment implements Adapter.OnClickListener {

    public static FragmentRecycler newInstance(){
        return new FragmentRecycler();
    }

    FragmentManager myFragmentManager;

    RecyclerView recyclerView;

    private Adapter adapter;

    private DatabaseReference myRef;

    private ArrayList<Data> dataList;
    private View listItems;
    private RecyclerView.LayoutManager manager;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



        listItems = inflater.inflate(R.layout.fragment_item,container,false);
        recyclerView = listItems.findViewById(R.id.programmingNameList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);



        myRef = FirebaseDatabase.getInstance().getReference();
        dataList = new ArrayList<>();
        getDataFromDb();

        return listItems;
    }

    private void getDataFromDb() {
        Query query = myRef.child("info");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot :dataSnapshot.getChildren()){
                    Data data = new Data();
                    data.setImage(snapshot.child("image").getValue().toString());
                    data.setTitle(snapshot.child("title").getValue().toString());
                    data.setBodyInfo(snapshot.child("bodyInfo").getValue().toString());
                    dataList.add(data);
                }
                adapter = new Adapter(getContext(),dataList);
                adapter.setOnClickListener(FragmentRecycler.this::onClick);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    @Override
    public void onClick(Data model) {
//       BlankFragment yfc = new BlankFragment();
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("key", model);
//        yfc.setArguments(bundle);


    }
}