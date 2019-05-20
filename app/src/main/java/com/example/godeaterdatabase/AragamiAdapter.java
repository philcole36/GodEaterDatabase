package com.example.godeaterdatabase;


import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

class AragamiAdapter extends RecyclerView.Adapter<AragamiAdapter.MyViewHolder> {
    List<aragamiData> studentDataList;
    public AragamiAdapter(List<aragamiData> studentDataList) {
        this.studentDataList=studentDataList;
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
        aragamiData data=studentDataList.get(i);
        Random rnd = new Random();
        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        viewHolder.parent.setBackgroundColor(currentColor);
        viewHolder.name.setText(data.name);
        viewHolder.details.setText(String.valueOf(data.details));

    }

    @Override
    public int getItemCount() {
        return studentDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,details;
        LinearLayout parent;
        public MyViewHolder(View itemView) {
            super(itemView);
            parent=itemView.findViewById(R.id.parent);
            name=itemView.findViewById(R.id.name);
            details=itemView.findViewById(R.id.details);
        }
    }
}
