package com.medicento.medicentofollowup;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class PendingJobDetailsActivity extends AppCompatActivity {


    private ActionMenuView actionMenuView;

    private TextView textViewArea;
    private TextView textViewAddress;
    private TextView textViewCallingTime;


    private TextView textViewFirstCallDate;

    private TextView textViewNumberOfDistributor;
    private RecyclerView recyclerViewDistributors;

    private TextView textViewNumberOfProblemsFaced;

    private TextView textViewProductQuality;
    private TextView textViewProductMismatch;
    private TextView textViewLateDelivery;
    private TextView textViewCreditPeriod;
    private TextView textViewIssueWithDistributor;
    private TextView textViewMedicineNotAvailable;
    private TextView textViewIssueWithDeliveryBoy;

    private TextView textViewFirstOrderDate;


    private Button buttonCallPharmacy;
    private Button buttonMessagePharmacy;

    private LinearLayout linearLayoutExtendPendingJobDetailsForRetention;


    private Pharmacy pharmacy;


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


        textViewArea = findViewById(R.id.textViewArea);
        textViewAddress = findViewById(R.id.textViewAddress);
        textViewCallingTime = findViewById(R.id.textViewCallingTime);

        // get references for buttons
        buttonCallPharmacy = findViewById(R.id.buttonCallPharmacy);
        buttonMessagePharmacy = findViewById(R.id.buttonMesagePharmacy);

        // get the pharmacy object from intent
        Intent intent = getIntent();
        pharmacy = (Pharmacy) intent.getSerializableExtra("PHARMACY_OBJECT");

        Moto moto = pharmacy.getActionMoto();

        // if motive is RETENTION
        if (moto.equals(Moto.RETENTION)) {

            linearLayoutExtendPendingJobDetailsForRetention = findViewById(R.id.linearLayoutExtendPendingJobDetailsForRetention);

            // show the extended layouts
            linearLayoutExtendPendingJobDetailsForRetention.setVisibility(View.VISIBLE);

            textViewFirstCallDate = findViewById(R.id.textViewFirstCallDate);

            textViewNumberOfDistributor = findViewById(R.id.textViewNumberOfDistributor);


            textViewNumberOfProblemsFaced = findViewById(R.id.textViewNumberOfProblemsFaced);


            textViewFirstOrderDate = findViewById(R.id.textViewFirstOrderDate);


            // set the datas
            Date firstCallDate = pharmacy.getFirstCallDate();

            String data = "First call @ " + firstCallDate.getDate() + "/" +
                    firstCallDate.getMonth() + "/" + firstCallDate.getYear();

            textViewFirstCallDate.setText(data);


            data = "No. of distributor: " + pharmacy.getDistributorList().size();
            textViewNumberOfDistributor.setText(data);

            // populate the list of distributor
            if (pharmacy.getDistributorList().size() != 0) {
                // populate the list of distributor
                recyclerViewDistributors = findViewById(R.id.recyclerViewDistributors);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                recyclerViewDistributors.setLayoutManager(linearLayoutManager);

                //  call the constructor of CustomAdapter to send the reference and data to Adapter
                CustomAdapterForDistributor customAdapterForDistributor = new CustomAdapterForDistributor(this, pharmacy.getDistributorList());

                recyclerViewDistributors.setAdapter(customAdapterForDistributor);
            }


            // now we have to get the problems faced
            int problemsFacedCount = 0;

            if (pharmacy.getFeedbacks().getProblems().isProductQuality()) {

                textViewProductQuality = findViewById(R.id.textViewProductQuality);
                textViewProductQuality.setVisibility(View.VISIBLE);
                problemsFacedCount++;
            }

            if (pharmacy.getFeedbacks().getProblems().isProductMismatch()) {

                textViewProductMismatch = findViewById(R.id.textViewProductMismatch);
                textViewProductMismatch.setVisibility(View.VISIBLE);
                problemsFacedCount++;
            }

            if (pharmacy.getFeedbacks().getProblems().isLateDelivery()) {

                textViewLateDelivery = findViewById(R.id.textViewLateDelivery);
                textViewLateDelivery.setVisibility(View.VISIBLE);
                problemsFacedCount++;
            }


            if (pharmacy.getFeedbacks().getProblems().isCreditPeriod()) {

                textViewCreditPeriod = findViewById(R.id.textViewCreditPeriod);
                textViewCreditPeriod.setVisibility(View.VISIBLE);
                problemsFacedCount++;
            }


            if (pharmacy.getFeedbacks().getProblems().isIssueWithDistributor()) {

                textViewIssueWithDistributor = findViewById(R.id.textViewIssueWithDistributor);
                textViewIssueWithDistributor.setVisibility(View.VISIBLE);
                problemsFacedCount++;
            }

            if (pharmacy.getFeedbacks().getProblems().isIssueWithDeliveryBoy()) {

                textViewIssueWithDeliveryBoy = findViewById(R.id.textViewIssueWithDeliveryBoy);
                textViewIssueWithDeliveryBoy.setVisibility(View.VISIBLE);
                problemsFacedCount++;
            }


            if (pharmacy.getFeedbacks().getProblems().isMedicineNotAvailable()) {

                textViewMedicineNotAvailable = findViewById(R.id.textViewMedicineNotAvailable);
                textViewMedicineNotAvailable.setVisibility(View.VISIBLE);
                problemsFacedCount++;
            }

            String msg = "Number of problems faced: " + problemsFacedCount;
            textViewNumberOfProblemsFaced.setText(msg);

            // set fist order date
            Date firstOrderDate = pharmacy.getFirstOrderDate();
            data = "First order @ " + firstOrderDate.getDate() + "/" + firstOrderDate.getMonth() + "/" + firstOrderDate.getYear();
            textViewFirstOrderDate.setText(data);

        }

        String s = "Address: " + pharmacy.getAddress();
        textViewAddress.setText(s);

        textViewCallingTime.setText(pharmacy.getCallingTime());

        buttonCallPharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showToastMessage("Opening calling app...");
                call();

            }
        });


        buttonMessagePharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastMessage("Opening messaging app...");
                message();
            }
        });

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

            showToastMessage("Opening calling app...");

            call();



        }

        if (id == R.id.pendin_jobs_details_message_pharmacy_button) {

            showToastMessage("Opening messaging app...");
            message();
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


    public void call() {

        // attach call listener
        EndCallListener callListener = new EndCallListener();
        TelephonyManager mTM = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        mTM.listen(callListener, PhoneStateListener.LISTEN_CALL_STATE);

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + pharmacy.getMobileNumber()));
        startActivity(intent);
    }

    public void message() {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", pharmacy.getMobileNumber());
        startActivity(smsIntent);
    }


    class EndCallListener extends PhoneStateListener {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            if(TelephonyManager.CALL_STATE_RINGING == state) {
                Log.i("CALL_STATE1", "RINGING, number: " + incomingNumber);

                moveToActivity(FeedbackActivity.class);
            }
            if(TelephonyManager.CALL_STATE_OFFHOOK == state) {
                //wait for phone to go offhook (probably set a boolean flag) so you know your app initiated the call.
                Log.i("CALL_STATE1", "OFFHOOK");
                moveToActivity(FeedbackActivity.class);
            }
            if(TelephonyManager.CALL_STATE_IDLE == state) {
                //when this state occurs, and your flag is set, restart your app
                Log.i("CALL_STATE1", "IDLE");
            }
        }
    }
}


