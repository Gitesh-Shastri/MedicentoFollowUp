package com.medicento.medicentofollowup;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PendingJobsFragment extends Fragment {

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
