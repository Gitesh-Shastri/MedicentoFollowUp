package com.medicento.medicentofollowup;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class PendingJobDetailsActivity extends AppCompatActivity {


    private ActionMenuView actionMenuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_job_details);


        // get the reference of toolbar
        Toolbar toolbar = findViewById(R.id.activity_pending_job_details_toolbar);

        actionMenuView = findViewById(R.id.activity_pending_job_details_toolbar_menu_view);

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

        setSupportActionBar(toolbar);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        //use action menu view
        inflater.inflate(R.menu.pending_job_details_activity_menu_item, actionMenuView.getMenu());
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.pending_job_details_menu_back_button) {
            showToastMessage("back button pressed");

            moveToActivity(MainActivity.class);
        }

        if (id == R.id.pendin_jobs_details_call_pharmacy_button) {
            showToastMessage("calling...");

            // open feedback fragment

        }

        if(id == R.id.pendin_jobs_details_message_pharmacy_button){

            showToastMessage("Sending message to pharmacy..");
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
