package com.example.godeaterdatabase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class AragamiPage extends AppCompatActivity {

    private static final String TAG = "AragamiPage";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aragami_page);
        Log.d(TAG, "onCreate: started");
        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intent");
        if(getIntent().hasExtra("aragami_name") && getIntent().hasExtra("aragami_details")){
            Log.d(TAG, "getIncomingIntent: found intent extras");

            String aragaminame = getIntent().getStringExtra("aragami_name");
            String aragamidets = getIntent().getStringExtra("aragami_details");

            setName(aragaminame, aragamidets);
        }
    }

    private void setName (String aragaminame, String aragamidets){
        Log.d(TAG, "setName: Set name to widget");

        TextView name = findViewById(R.id.name);
        TextView details = findViewById(R.id.details);

        name.setText(aragaminame);
        details.setText(aragamidets);
    }
}
