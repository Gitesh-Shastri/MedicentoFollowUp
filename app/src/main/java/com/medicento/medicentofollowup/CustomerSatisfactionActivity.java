package com.medicento.medicentofollowup;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class CustomerSatisfactionActivity extends AppCompatActivity {


    // ArrayList for pending job list
    private ArrayList<Pharmacy> rowElements = new ArrayList<>();


    private ActionMenuView actionMenuView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_satisfaction);


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


        // get the reference of toolbar
        Toolbar toolbar = findViewById(R.id.activity_cx_satisfaction_toolbar);

        actionMenuView = findViewById(R.id.activity_cx_satisfaction_toolbar_menu_view);


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
        setSupportActionBar(toolbar);

        // get the reference of RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCxSatisfaction);

        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapterForPendingJobList customAdapter = new CustomAdapterForPendingJobList(this, rowElements);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.customer_satisfaction_activity_menu_item, actionMenuView.getMenu());
        return true;
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

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void moveToActivity(Class activity) {

        Intent i = new Intent(this, activity);

        // remove this activity from back stack
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(i);
    }
}
