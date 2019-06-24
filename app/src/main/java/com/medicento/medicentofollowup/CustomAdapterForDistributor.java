package com.medicento.medicentofollowup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterForDistributor extends RecyclerView.Adapter<CustomAdapterForDistributor.MyViewHolder> {

    private Context context;
    private List<Distributor> distributorList;

    public CustomAdapterForDistributor(Context context, List distributorList) {
        this.context = context;
        this.distributorList = new ArrayList<>();
        this.distributorList.addAll(distributorList);
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // inflate the item Layout
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.distributor_recycler_view_row_element, viewGroup, false);

        // set the view's size, margins, padding and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }


    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, final int i) {

        viewHolder.textViewDistributorName.setText(distributorList.get(i).getDistributorName());
        viewHolder.textViewDistributorAddress.setText(distributorList.get(i).getDistributorAddress());



        // implement setOnClickListener event on item view.
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, distributorList.get(i).getDistributorName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return distributorList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewDistributorName;
        TextView textViewDistributorAddress;

        public MyViewHolder(View itemView) {
            super(itemView);

            textViewDistributorAddress = itemView.findViewById(R.id.textViewDistributorAddress);
            textViewDistributorName = itemView.findViewById(R.id.textViewDistributorName);
        }
    }
}
