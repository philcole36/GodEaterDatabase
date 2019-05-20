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
    private List<aragamiData> aragamiDataList = new ArrayList<>();

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
        aragamiData data = new aragamiData("Orgetail", "A small Aragami whose tail resembles a demon's face. \n" +
                "Usually subsisting on the corpses of other Aragami, it is prolific and found throughout the world. Although new breeds of Aragami have been growing, Ogretail show no signs of diminishing in number. \n" +
                "\n" +
                "If attacked from the side, it falls quickly, However, its tail spin attack is powerful. When it clenches its legs, make sure to back away. ");
        aragamiDataList.add(data);
        data = new aragamiData("sai", "1");
        aragamiDataList.add(data);
        data = new aragamiData("raghu", "2");
        aragamiDataList.add(data);
        
        Collections.sort(aragamiDataList, new Comparator<aragamiData>() {
            @Override
            public int compare(aragamiData o1, aragamiData o2) {
                return o1.name.compareTo(o2.name);
            }
        });
    }
}