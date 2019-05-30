package com.medicento.medicentofollowup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class CustomAdapterForPendingJobList extends RecyclerView.Adapter<CustomAdapterForPendingJobList.MyViewHolder> {


    private ArrayList<PendingJobListElement> rowElements;
    private Context context;

    public CustomAdapterForPendingJobList(Context context, ArrayList rowElements) {
        this.context = context;
        this.rowElements = rowElements;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // infalte the item Layout
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragement_pending_job_recycler_view_row, viewGroup, false);

        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, final int i) {

        viewHolder.tvPharmacyName.setText(rowElements.get(i).pharmacyName);
        viewHolder.tvActionTime.setText(rowElements.get(i).actionTakenTime);
        viewHolder.tvMoto.setText(rowElements.get(i).actionMoto);

        viewHolder.imageButtonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "Making dummy call..", Toast.LENGTH_SHORT).show();
            }
        });


        // implement setOnClickListener event on item view.
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, rowElements.get(i).pharmacyName, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return rowElements.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView tvPharmacyName;
        TextView tvActionTime;
        TextView tvMoto;
        ImageButton imageButtonCall;

        public MyViewHolder(View v) {
            super(v);

            tvPharmacyName = v.findViewById(R.id.textViewPharmacyName);
            tvActionTime = v.findViewById(R.id.textViewActionTime);
            tvMoto = v.findViewById(R.id.textViewMoto_);
            imageButtonCall = v.findViewById(R.id.imageButtonCall);
        }
    }


}
