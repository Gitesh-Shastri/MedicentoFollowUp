package com.medicento.medicentofollowup;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class PendingJobsFragment extends Fragment {

    // ArrayList for pending job list
    ArrayList rowElements = new ArrayList<>(Arrays.asList(new PendingJobListElement("ABCD", "1234", "Att.@ 8:00AM", "Cx Acquisition"),
            new PendingJobListElement("ABCDE", "1234", "Call.@ 9:00AM", "Cx Retention"),
            new PendingJobListElement("ABCDF", "1234", "Att.@ 8:00AM", "Cx Acquisition"),
            new PendingJobListElement("ABCDG", "1234", "Att.@ 8:00AM", "Cx Acquisition"),
            new PendingJobListElement("ABCDH", "1234", "Att.@ 8:00AM", "Cx Acquisition")));

    Toolbar toolbar;

    // Overriding onCreateView of Fragment class

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        //  to make the options appear in your Toolbar
        setHasOptionsMenu(true);

        // get the layout associated with PendingJobsFragment

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_pending_jobs, container, false);

        // get the reference t toolbar
        toolbar = view.findViewById(R.id.fragment_pending_job_toolbar);
        toolbar.setTitle("Pending Jobs");
        Menu menu = toolbar.getMenu();
        TextView textView = view.findViewById(R.id.text);

        // replace toolbar as actionbar
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);



        // get the reference of RecyclerView
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewPendingJobs);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                    if(toolbar.isSelected()){
                        recyclerView.canScrollVertically(-1);
                    }
                }


            });
        }

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
        inflater.inflate(R.menu.pending_jobs_fragment_menu_main, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_back_button){
            showToastMessage("back button pressed..");

            moveToActivity(MainActivity.class);
        }

        if (id == R.id.filter_pending_jobs){
            showToastMessage("filter pending jobs..");

        }

        return true;
    }

    private void showToastMessage(String message){

        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    private void moveToActivity(Class activity){

        Intent i = new Intent(getActivity(), activity);

        // remove this activity from back stack
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(i);
    }
}
