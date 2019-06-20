package com.medicento.medicentofollowup;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class CustomerSatisfactionFragment extends Fragment {

    // ArrayList for pending job list
    private ArrayList<Pharmacy> rowElements = new ArrayList<>();


    private ActionMenuView actionMenuView;


    // Overriding onCreateView of Fragment class

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //get the pharmacy details and add into rowElements
        Pharmacy pharmacy = new Pharmacy();

        pharmacy.setPharmacyName("Balaji Pharma");
        pharmacy.setActionMoto(Moto.SATISFACTION);
        pharmacy.setCallingTime("Call@2:30PM");
        pharmacy.setAddress("Delhi852107");
        pharmacy.setFirstCallDate(new Date(2019, 6, 21));

        Feedbacks feedbacks = new Feedbacks();
        Problems problems = new Problems();
        problems.setLateDelivery(true);

        feedbacks.setLateDeliveryCount(5);
        feedbacks.setOnboarded(Onboarded.YES);

        pharmacy.setFirstOrderDate(new Date(2019, 4, 8));
        pharmacy.setMobileNumber("8139001736");

        // add to row elements
        rowElements.add(pharmacy);




        //  to make the options appear in your Toolbar
        setHasOptionsMenu(true);

        // get the layout associated with CustomerAcquisitionFragment

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_customer_satisfaction, container, false);

        // get the reference of toolbar
        Toolbar toolbar = view.findViewById(R.id.fragment_cx_satisfaction_toolbar);

        actionMenuView = view.findViewById(R.id.fragment_cx_satisfaction_toolbar_menu_view);


        // set onItemCLickListener on actionMenuView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            actionMenuView.setOnMenuItemClickListener(new ActionMenuView.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {

                    return onOptionsItemSelected(menuItem);
                }
            });
        } else {

            showToastMessage("Function not supported in this device..");
        }


        // replace toolbar as actionbar
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        toolbar.setTitle("Cx Satisfaction");

        //((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // get the reference of RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewCxSatisfaction);

        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapterForPendingJobList customAdapter = new CustomAdapterForPendingJobList(getActivity(), rowElements);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            inflater.inflate(R.menu.customer_satisfaction_fragment_menu_item, actionMenuView.getMenu());
//            super.onCreateOptionsMenu(
//                    actionMenuView.getMenu(), inflater);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.customer_satisfaction_action_back_button) {
            showToastMessage("cx back button pressed..");

            moveToActivity(MainActivity.class);
        }

        if (id == R.id.filter_customer_satisfaction) {
            showToastMessage("filter cxs..");

        }

        return true;
    }

    private void showToastMessage(String message) {

        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    private void moveToActivity(Class activity) {

        Intent i = new Intent(getActivity(), activity);

        // remove this activity from back stack
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(i);
    }
}
