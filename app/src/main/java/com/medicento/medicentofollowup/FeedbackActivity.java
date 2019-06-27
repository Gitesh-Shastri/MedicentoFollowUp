package com.medicento.medicentofollowup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FeedbackActivity extends AppCompatActivity {

    private TextView nameTextView,
            addressTextView;

    private LinearLayout issueWithDistributor,
            lateDelivery,
            availabilityOfMedicine,
            issuesWithDeliveryBoy;

    private CheckBox yes1,no1,yes2,no2,yes3,no3,yes4,no4,yes5,yes6,yes7,no5,no6,no7;
    private Feedbacks feedbacks = new Feedbacks();
    private Problems problems = new Problems();
    private List<String> listOfMedicineNotAvailable = new ArrayList<>();
    private List<String> otherReasonsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        nameTextView = findViewById(R.id.nameTextView);
        addressTextView = findViewById(R.id.addressTextView);
        issueWithDistributor = findViewById(R.id.issueswithdistributor);
        issuesWithDeliveryBoy = findViewById(R.id.issueswithdeliveryboy);

        yes1 = findViewById(R.id.yes1);
        yes2 = findViewById(R.id.yes2);
        yes3 = findViewById(R.id.yes3);
        yes4 = findViewById(R.id.yes4);
        no1 = findViewById(R.id.no1);
        no2 = findViewById(R.id.no2);
        no3 = findViewById(R.id.no3);
        no4 = findViewById(R.id.no4);

        yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxClicked(view.getId());
            }
        });
        yes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxClicked(view.getId());
            }
        });
        yes3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxClicked(view.getId());
            }
        });
        yes4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxClicked(view.getId());
            }
        });

        no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxClicked(view.getId());
            }
        });
        no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxClicked(view.getId());
            }
        });
        no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxClicked(view.getId());
            }
        });
        no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxClicked(view.getId());
            }
        });
    }

    public void onCheckboxClicked(int id){
        switch (id){
            case R.id.yes1:
                no1.setSelected(false);
                break;
            case R.id.yes2:
                no2.setSelected(false);
                break;
            case R.id.yes3:
                no3.setSelected(false);
                break;
            case R.id.yes4:
                no4.setSelected(false);
                break;
            case R.id.no1:
                yes1.setSelected(false);
                break;
            case R.id.no2:
                yes2.setSelected(false);
                break;
            case R.id.no3:
                yes3.setSelected(false);
                break;
            case R.id.no4:
                yes4.setSelected(false);
                break;
        }
    }
}
