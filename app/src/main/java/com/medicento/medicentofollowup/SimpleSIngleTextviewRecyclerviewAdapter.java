package com.medicento.medicentofollowup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SimpleSIngleTextviewRecyclerviewAdapter extends RecyclerView.Adapter<SimpleSIngleTextviewRecyclerviewAdapter.SimpleViewHolder> {

    public interface OnItemClickListner{
        void onItemClick(int position);
    }

    private ArrayList<String> itemList;
    private Context context;
    private OnItemClickListner mListner;

    public SimpleSIngleTextviewRecyclerviewAdapter(ArrayList<String> itemList, Context context, OnItemClickListner mListner) {
        this.itemList = itemList;
        this.context = context;
        this.mListner = mListner;
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.distributor_item,viewGroup,false);
        SimpleViewHolder simpleViewHolder=new SimpleViewHolder(view);
        return simpleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final SimpleViewHolder simpleViewHolder, int i) {
        String name=itemList.get(i);
        simpleViewHolder.nameText.setText(name);
        simpleViewHolder.nameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListner.onItemClick(simpleViewHolder.getAdapterPosition());
            }
        });
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class SimpleViewHolder extends RecyclerView.ViewHolder{

        TextView nameText;
        View view;

        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            nameText=itemView.findViewById(R.id.name);
        }
    }
}
