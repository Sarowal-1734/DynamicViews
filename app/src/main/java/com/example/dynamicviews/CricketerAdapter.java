package com.example.dynamicviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CricketerAdapter extends RecyclerView.Adapter<CricketerAdapter.MyViewHolder> {

    Context context;
    ArrayList<CricketerModel> cricketers;

    public CricketerAdapter(Context context, ArrayList<CricketerModel> cricketers) {
        this.context = context;
        this.cricketers = cricketers;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cricketer_row_item, parent,false); //if true the app will crash
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.CricketerName.setText(cricketers.get(position).cricketerName);
        holder.CricketerTeam.setText(cricketers.get(position).teamName);
    }

    @Override
    public int getItemCount() {
        return cricketers.size(); //number of items in the list
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView CricketerName;
        TextView CricketerTeam;
        public MyViewHolder(View itemView){
            super(itemView);
            CricketerName = itemView.findViewById(R.id.textViewName);
            CricketerTeam = itemView.findViewById(R.id.textViewTeam);
        }
    }

}
