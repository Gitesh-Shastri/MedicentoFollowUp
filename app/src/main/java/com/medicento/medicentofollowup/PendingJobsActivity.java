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
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class PendingJobsActivity extends AppCompatActivity {

    // ArrayList for pending job list
    protected static ArrayList<Pharmacy> rowElements = new ArrayList<>();

    private Toolbar toolbar;
    private SearchView searchViewActivityPendingJobs;
    private boolean isSearchViewOpen = false;
    private CustomAdapterForPendingJobList customAdapter;
    private RecyclerView recyclerView;
    private ActionMenuView actionMenuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_jobs);


        ArrayList<Pharmacy> rowElements = new ArrayList<>();

        //get the pharmacy details and add into rowElements
        Pharmacy pharmacy1 = new Pharmacy();
        pharmacy1.setPharmacyName("A.P. Pharma");
        pharmacy1.setActionMoto(Moto.ACQUISITION);
        pharmacy1.setCallingTime("Call@9:30PM");
        pharmacy1.setAddress("Bangalore");

        rowElements.add(pharmacy1);

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setPharmacyName("Gupta Pharma");
        pharmacy.setActionMoto(Moto.RETENTION);
        pharmacy.setCallingTime("Call@2:30PM");
        pharmacy.setAddress("Bihar852107");
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

        PendingJobsActivity.rowElements.clear();
        PendingJobsActivity.rowElements.addAll(rowElements);

        // get the reference of toolbar
        toolbar = findViewById(R.id.activity_pending_job_toolbar);

        actionMenuView = findViewById(R.id.activity_pending_job_toolbar_menu_view);

        // get reference of searchViewFragmentPendingJobs
        searchViewActivityPendingJobs = findViewById(R.id.searchViewActivityPendingJobs);


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
        recyclerView = findViewById(R.id.recyclerViewPendingJobs);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                    if (toolbar.isSelected()) {
                        recyclerView.canScrollVertically(-1);
                    }
                }


            });
        }

        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        customAdapter = new CustomAdapterForPendingJobList(this, rowElements);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView


        // set queryChangeListener to search bar
        searchViewActivityPendingJobs.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                customAdapter.filter(s);
                return false;
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.pending_jobs_activity_menu_item, actionMenuView.getMenu());

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_back_button) {
            showToastMessage("back button pressed..");

            moveToActivity(MainActivity.class);
        }

        if (id == R.id.filter_pending_jobs) {

            showToastMessage("filter pending jobs..");

            if (!isSearchViewOpen) {

                isSearchViewOpen = true;

                item.setIcon(R.drawable.ic_close_black_24dp);
                item.setTitle("close search bar");

                // make the searchView ready to get input
                searchViewActivityPendingJobs.setIconified(false);

                searchViewActivityPendingJobs.setVisibility(View.VISIBLE);
                searchViewActivityPendingJobs.animate().alpha(1).setDuration(500);
            } else {
                isSearchViewOpen = false;

                // revert back the adapter
                customAdapter = new CustomAdapterForPendingJobList(this, rowElements);
                recyclerView.setAdapter(customAdapter);

                item.setIcon(R.drawable.filter_filled_icon);
                item.setTitle("Filter pending jobs");

                searchViewActivityPendingJobs.animate().alpha(0).setDuration(500);

                searchViewActivityPendingJobs.setVisibility(View.GONE);
            }


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
