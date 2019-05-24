package com.example.godeaterdatabase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
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
        if(getIntent().hasExtra("aragami_name") && getIntent().hasExtra("aragami_details") && getIntent().hasExtra("aragami_weakness")){
            Log.d(TAG, "getIncomingIntent: found intent extras");

            String aragaminame = getIntent().getStringExtra("aragami_name");
            String aragamidets = getIntent().getStringExtra("aragami_details");
            String aragamiweakness = getIntent().getStringExtra("aragami_weakness");
            setData(aragaminame, aragamidets, aragamiweakness);
        }
    }

    private void setData(String aragaminame, String aragamidets, String aragamiweakness){
        Log.d(TAG, "setData: Set name to widget");

        TextView name = findViewById(R.id.name);
        TextView details = findViewById(R.id.details);
        TextView weakness = findViewById(R.id.weakness);


        name.setText(aragaminame);
        details.setText(aragamidets);
        weakness.setText(aragamiweakness);

    }
}
