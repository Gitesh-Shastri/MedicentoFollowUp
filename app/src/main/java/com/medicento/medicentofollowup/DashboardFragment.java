package com.medicento.medicentofollowup;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DashboardFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    CardView card1,card2,card3,card4,card5,card6;

    public DashboardFragment() {

    }

    @Override
    public void onAttach(Context context) {
        try {
            mListener=(OnFragmentInteractionListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException("The parent activity should implement the listener interface..");
        }
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_dashboard, container, false);

        init(view);

        return view;
    }

    private void init(View view) {

        card1=view.findViewById(R.id.card_view1);
        card2=view.findViewById(R.id.card_view2);
        card3=view.findViewById(R.id.card_view3);
        card4=view.findViewById(R.id.card_view4);
        card5=view.findViewById(R.id.card_view5);
        card6=view.findViewById(R.id.card_view6);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onCardClick(view.getId());
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onCardClick(view.getId());
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onCardClick(view.getId());
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onCardClick(view.getId());
            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onCardClick(view.getId());
            }
        });
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onCardClick(view.getId());
            }
        });

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onCardClick(int id);
    }
}