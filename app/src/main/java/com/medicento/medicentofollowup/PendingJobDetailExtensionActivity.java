package com.medicento.medicentofollowup;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PendingJobDetailExtensionActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Pharmacy pharmacy;
    private TextView areaname,address,name,currentCallTimings,previousCallTimings,noOfDistributors,noOfProblems;
    private ImageView calldown,msgdown;
    private RecyclerView distributorRV,problemRV;

    private ArrayList<String> distributorList=new ArrayList<>(),problemsList=new ArrayList<>();
    private SimpleSIngleTextviewRecyclerviewAdapter distributorAdapter,problemAdapter;

    private Toolbar.OnMenuItemClickListener toolbarListener=
            new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    int id=menuItem.getItemId();

                    switch (id){
                        case R.id.call_item:
                            call();
                            break;
                        case R.id.msg_item:
                            message();
                            break;
                    }
                    return true;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_job_detail_extension);

        pharmacy=new Pharmacy("Rohini","A-block," +
                " market place sector 2 rohini","139819439878", "AP pharma");
        init();
    }

    private void init() {

        toolbar = (Toolbar) findViewById(R.id.pending_job_detail_toolbar);
        toolbar.setSubtitle("Test Subtitle");
        toolbar.inflateMenu(R.menu.toolbar_menu);

        toolbar.setOnMenuItemClickListener(toolbarListener);
        areaname=findViewById(R.id.area);
        address=findViewById(R.id.address);
        name=findViewById(R.id.pharma_name);
        calldown=findViewById(R.id.call_item_down);
        msgdown=findViewById(R.id.msg_item_down);
        currentCallTimings=findViewById(R.id.timing);
        previousCallTimings=findViewById(R.id.status);
        noOfDistributors=findViewById(R.id.count_of_distributors);
        noOfProblems=findViewById(R.id.count_problems);
        distributorRV=findViewById(R.id.distributors_recyclerview);
        problemRV=findViewById(R.id.problems_recyclerview);

        calldown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call();
            }
        });

        msgdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message();
            }
        });

        areaname.setText("Area: "+pharmacy.areaname);
        address.setText("Address: "+pharmacy.address);
        name.setText(pharmacy.name);

        distributorAdapter=new SimpleSIngleTextviewRecyclerviewAdapter(distributorList, this, new SimpleSIngleTextviewRecyclerviewAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(PendingJobDetailExtensionActivity.this,"Single distributor item selected!",Toast.LENGTH_SHORT).show();
            }
        });

        problemAdapter=new SimpleSIngleTextviewRecyclerviewAdapter(problemsList, this, new SimpleSIngleTextviewRecyclerviewAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(PendingJobDetailExtensionActivity.this,"Single distributor item selected!",Toast.LENGTH_SHORT).show();
            }
        });

        collectData();

        distributorRV.setAdapter(distributorAdapter);
        distributorRV.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL));
//        progressBar1.setVisibility(View.GONE);
        problemRV.setAdapter(problemAdapter);
        problemRV.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL));
//        progressBar2.setVisibility(View.GONE);
    }

    private void collectData() {
        for (int i=1;i<=8;i++){
            distributorList.add("Distributor no.: "+i);
            problemsList.add("Problem no.: "+i);
        }
    }

    public void call(){
        Intent intent = new Intent(Intent.ACTION_DIAL );
        intent.setData(Uri.parse("tel:" + pharmacy.phone));
        startActivity(intent);
    }

    public void message(){
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", pharmacy.phone);
        startActivity(smsIntent);
    }
}
