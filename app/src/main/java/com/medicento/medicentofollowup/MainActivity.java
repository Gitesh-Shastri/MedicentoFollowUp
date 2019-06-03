package com.medicento.medicentofollowup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

/* Created as Dashboard- Nidhi Koli-DTU*/

public class MainActivity extends AppCompatActivity implements DashboardFragment.OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener {

//    FrameLayout container=findViewById(R.id.container);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DashboardFragment dashboardFragment=new DashboardFragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.container,dashboardFragment).commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onCardClick(int id) {

        Toast.makeText(MainActivity.this,"Option to be selected",Toast.LENGTH_LONG).show();

        switch (id){
            case R.id.card_view1:
                //pending jobs selected fregment
                Toast.makeText(this, "card view1 clicked", Toast.LENGTH_SHORT).show();
                loadFragment(new PendingJobsFragment());
                break;
            case R.id.card_view2:
                //to be targeted fragment
                break;
            case R.id.card_view3:
                //calls made fragment
                break;
            case R.id.card_view4:
                //success fragment
                break;
            case R.id.card_view5:
                //remarks fragment
                break;
            case R.id.card_view6:
                //critical fragment
                break;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment currFragment=getSupportFragmentManager().findFragmentById(R.id.container);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        switch (menuItem.getItemId()){
            case R.id.nav_dashboard:
                break;
            case R.id.nav_pendingjobs:
                break;
            case R.id.nav_acquisition:
                loadFragment(new CustomerAcquisitionFragment());
                break;
            case R.id.nav_retention:
                loadFragment(new CustomerRetentionFragment());
                break;
            case R.id.nav_satisfaction:
                loadFragment(new CustomerSatisfactionFragment());
                break;
            case R.id.nav_cashcollection:
                break;
            case R.id.nav_notification:
                break;
            case R.id.nav_settings:
                break;

        }



        return true;
    }


    // defining method loadFragment()
    // this will be used to replace the DashboardActivity to passed fragment
    private void loadFragment(android.app.Fragment fragment){

        // create a frame layout
        FrameLayout fragmentLayout = new FrameLayout(this);
        // set the layout params to fill the activity
        fragmentLayout.setLayoutParams(new  ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        // give the random id to fragmentLayout
        fragmentLayout.setId(View.generateViewId());

        // setContentView to fragmentLayout
        setContentView(fragmentLayout);

        // create a fragment manager
        android.app.FragmentManager fragmentManager = getFragmentManager();

        // create a FragementTransaction to begin the transaction and replace
        // the fragment

        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // replace the dashboard activity with new Fragment
        //fragmentTransaction.replace(R.id.dash_board_root_view, fragment);

        fragmentTransaction.add(fragmentLayout.getId(), fragment);
        // save the changes
        fragmentTransaction.commit();

        // remove this fragment from backStack
        fragmentManager.popBackStack();

    }
}