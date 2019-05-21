package com.example.godeaterdatabase;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AragamiAdapter aragamiAdapter;
    List<AragamiData> aragamiDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        aragamiAdapter = new AragamiAdapter(aragamiDataList);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(aragamiAdapter);
        AragamiDataPrepare();
        
    }

    private void AragamiDataPrepare() {

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        aragamiDataList.addAll(databaseAccess.getQuotes());
        databaseAccess.close();
        
        Collections.sort(aragamiDataList, new Comparator<AragamiData>() {
            @Override
            public int compare(AragamiData o1, AragamiData o2) {
                return o1.name.compareTo(o2.name);
            }
        });
    }
}