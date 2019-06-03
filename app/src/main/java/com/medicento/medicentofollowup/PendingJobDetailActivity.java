package com.medicento.medicentofollowup;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PendingJobDetailActivity extends AppCompatActivity {

    Toolbar toolbar;
    Pharmacy pharmacy;
    TextView areaname,address,name;
    ImageView calldown,msgdown;

    Toolbar.OnMenuItemClickListener toolbarListener=new Toolbar.OnMenuItemClickListener() {
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
        setContentView(R.layout.activity_pending_job_detail);

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
