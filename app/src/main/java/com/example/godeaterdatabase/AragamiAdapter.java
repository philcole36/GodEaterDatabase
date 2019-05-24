package com.example.godeaterdatabase;


import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;

class AragamiAdapter extends RecyclerView.Adapter<AragamiAdapter.MyViewHolder> {
    List<AragamiData> AragamiMajorList;
    public AragamiAdapter(List<AragamiData> AragamiMajorList) {
        this.AragamiMajorList = AragamiMajorList;
    }
    

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.aragami_row, viewGroup, false);

        return new MyViewHolder(itemView);

    }


    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        final AragamiData data= AragamiMajorList.get(i);

        int currentColor = Color.argb(255, 000, 000, 000);
        viewHolder.parent.setBackgroundColor(currentColor);
        viewHolder.name.setText(data.name);
        viewHolder.details.setText(String.valueOf(data.details));

        viewHolder.img.setImageResource(data.img);
        Log.d(TAG, "onBindViewHolder: Image:" + data.img);

        viewHolder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AragamiPage.class);
                intent.putExtra("aragami_name", data.name);
                intent.putExtra("aragami_details", data.details);
                intent.putExtra("aragami_weakness", data.weakness);

                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return AragamiMajorList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,details;
        ImageView img;
        LinearLayout parent;
        public MyViewHolder(View itemView) {
            super(itemView);
            parent=itemView.findViewById(R.id.parent);
            name=itemView.findViewById(R.id.name);
            details=itemView.findViewById(R.id.details);
            img=itemView.findViewById(R.id.aragami_pic);
        }
    }
}
