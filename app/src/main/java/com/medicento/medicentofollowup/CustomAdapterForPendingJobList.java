package com.medicento.medicentofollowup;

import android.content.Context;
import android.content.Intent;
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


    private ArrayList<Pharmacy> rowElements;
    private ArrayList<Pharmacy> originalRowElements;
    private Context context;

    public CustomAdapterForPendingJobList(Context context, ArrayList rowElements) {
        this.context = context;
        this.rowElements = new ArrayList<>();
        this.rowElements.addAll(rowElements);
        this.originalRowElements = rowElements;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // inflate the item Layout
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragement_pending_job_recycler_view_row, viewGroup, false);

        // set the view's size, margins, padding and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, final int i) {

        viewHolder.tvPharmacyName.setText(rowElements.get(i).getPharmacyName());
        viewHolder.tvActionTime.setText(rowElements.get(i).getCallingTime());
        viewHolder.tvMoto.setText(String.valueOf(rowElements.get(i).getActionMoto()));

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

                Toast.makeText(context, rowElements.get(i).getPharmacyName(), Toast.LENGTH_SHORT).show();

                Pharmacy pharmacy = rowElements.get(i);

                moveToActivity(PendingJobDetailsActivity.class, pharmacy);

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


    // defining method to filter element in list
    public void filter(String charText) {
        charText = charText.toLowerCase();

        if (charText.length() == 0) {
            rowElements.clear();
            rowElements.addAll(originalRowElements);
        } else {
            rowElements.clear();
            for (Pharmacy element : originalRowElements) {
                if (element.getPharmacyName().toLowerCase().contains(charText)) {
                    rowElements.add(element);
                }
            }

            if (rowElements.size() == 0) {

                Toast.makeText(context, charText + ": not found", Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(context, "found " + rowElements.size() + " results:)", Toast.LENGTH_SHORT).show();
            }

        }

        notifyDataSetChanged();
    }


    private void moveToActivity(Class activity, Pharmacy pharmacy) {

        Intent i = new Intent(context, activity);

        // pass serialized pharmacy object to next activity
        i.putExtra("PHARMACY_OBJECT", pharmacy);

        // remove this activity from back stack
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        context.startActivity(i);
    }
}
