package com.medicento.medicentofollowup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FeedbackActivity extends AppCompatActivity {

    private TextView nameTextView,
            addressTextView,
            issueswithDistributorTV,
            lateDeliveryTV,
            latedeliveryExtendedTV,
            availabilityOfMedTV,
            availabilityOfMedExtendedTV,
            issueswithDeliveryBoyTV,
            othersTV,
            reOnBoardedTV;

    private Button submitButton;

    private EditText distributorName,other1,other2;

    private LinearLayout issueWithDistributor,
            lateDelivery,
            availabilityOfMedicine,
            issuesWithDeliveryBoy,
            lateDeliveryExtended,
            availabilityOfMedicineExtended,
            issuesWithDeliveryBoyExtended,
            others,
            othersLayout,
            reOnBoarded;

    private CheckBox yes1,no1,yes2,no2,yes3,no3,yes4,no4,yes5,yes6,yes7,no5,no6,no7,idk;
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
        issueswithDistributorTV = findViewById(R.id.textHint2);
        lateDeliveryTV = findViewById(R.id.textHint3);
        latedeliveryExtendedTV = findViewById(R.id.textHint6);
        availabilityOfMedTV = findViewById(R.id.textHint4);
        availabilityOfMedExtendedTV = findViewById(R.id.textHint7);
        issueswithDeliveryBoyTV = findViewById(R.id.textHint5);
        othersTV = findViewById(R.id.textHint8);
        reOnBoardedTV = findViewById(R.id.textHint9);

        issueWithDistributor = findViewById(R.id.issueswithdistributor);
        issuesWithDeliveryBoy = findViewById(R.id.issueswithdeliveryboy);
        lateDelivery = findViewById(R.id.latedelivery);
        availabilityOfMedicine = findViewById(R.id.availabilityofmedicine);
        lateDeliveryExtended = findViewById(R.id.latedeliveryextended);
        availabilityOfMedicineExtended = findViewById(R.id.availabilityofmedicineextended);
        issuesWithDeliveryBoyExtended = findViewById(R.id.issueswithdeliveryboyextended);
        others = findViewById(R.id.others);
        othersLayout = findViewById(R.id.otherslayout);
        reOnBoarded = findViewById(R.id.reonboarded);

        yes1 = findViewById(R.id.yes1);
        yes2 = findViewById(R.id.yes2);
        yes3 = findViewById(R.id.yes3);
        yes4 = findViewById(R.id.yes4);
        no1 = findViewById(R.id.no1);
        no2 = findViewById(R.id.no2);
        no3 = findViewById(R.id.no3);
        no4 = findViewById(R.id.no4);
        yes5 = findViewById(R.id.yes5);
        yes6 = findViewById(R.id.yes6);
        yes7 = findViewById(R.id.yes7);
        no5 = findViewById(R.id.no5);
        no6 = findViewById(R.id.no6);
        no7 = findViewById(R.id.no7);
        idk = findViewById(R.id.idk);

        distributorName = findViewById(R.id.distributorname);
        other1 = findViewById(R.id.other1);
        other2 = findViewById(R.id.other2);

        submitButton = findViewById(R.id.submitbutton);

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
        yes5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxClicked(view.getId());
            }
        });
        yes6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxClicked(view.getId());
            }
        });
        yes7.setOnClickListener(new View.OnClickListener() {
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
        no5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxClicked(view.getId());
            }
        });
        no6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxClicked(view.getId());
            }
        });
        no7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxClicked(view.getId());
            }
        });
    }

    public void onCheckboxClicked(int id){
        switch (id){
            case R.id.yes1:
                no1.setChecked(false);
                break;
                
            case R.id.yes2:
                latedeliveryExtendedTV.setVisibility(View.VISIBLE);
                lateDeliveryExtended.setVisibility(View.VISIBLE);
                no2.setChecked(false);
                break;
                
            case R.id.yes3:
                availabilityOfMedExtendedTV.setVisibility(View.VISIBLE);
                availabilityOfMedicineExtended.setVisibility(View.VISIBLE);
                no3.setChecked(false);
                break;
                
            case R.id.yes4:
                issuesWithDeliveryBoyExtended.setVisibility(View.VISIBLE);
                no4.setChecked(false);
                break;
                
            case R.id.yes5:
                no5.setChecked(false);
                break;
                
            case R.id.yes6:
                othersLayout.setVisibility(View.VISIBLE);
                break;
                
            case R.id.yes7:
                no7.setChecked(false);
                idk.setChecked(false);
                break;
                
            case R.id.no1:
                yes1.setChecked(false);
                break;
                
            case R.id.no2:
                latedeliveryExtendedTV.setVisibility(View.GONE);
                lateDeliveryExtended.setVisibility(View.GONE);
                yes2.setChecked(false);
                break;
                
            case R.id.no3:
                availabilityOfMedExtendedTV.setVisibility(View.GONE);
                availabilityOfMedicineExtended.setVisibility(View.GONE);
                yes3.setChecked(false);
                break;
                
            case R.id.no4:
                issuesWithDeliveryBoyExtended.setVisibility(View.GONE);
                yes4.setChecked(false);
                break;
                
            case R.id.no5:
                yes5.setChecked(false);
                break;
                
            case R.id.no6:
                yes6.setChecked(false);
                break;
                
            case R.id.no7:
                idk.setChecked(false);
                yes7.setChecked(false);
                break;

            case R.id.submitbutton:
                
                submit();
                break;

            case R.id.idk:
                no7.setChecked(false);
                yes7.setChecked(false);
                break;
        }
    }

    private void submit() {

    }
}
