package com.medicento.medicentofollowup;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class PendingJobDetailActivity extends AppCompatActivity {

    Toolbar toolbar;
    Pharmacy pharmacy;
    TextView areaname,address,name;

    Toolbar.OnMenuItemClickListener toolbarListener=new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            int id=menuItem.getItemId();

            switch (id){
                case R.id.call_item:
                    Intent intent = new Intent(Intent.ACTION_DIAL );
                    intent.setData(Uri.parse("tel:" + pharmacy.phone));
                    startActivity(intent);
                    break;
                case R.id.msg_item:
                    Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                    smsIntent.setType("vnd.android-dir/mms-sms");
                    smsIntent.putExtra("address", "12125551212");
                    smsIntent.putExtra("sms_body","Body of Message");
                    startActivity(smsIntent);
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

        areaname.setText("Area: "+pharmacy.areaname);
        address.setText("Address: "+pharmacy.address);
        name.setText(pharmacy.name);
    }
}
