package com.atharva.pbbnavdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navview ;
    CoordinatorLayout coordinatorLayout;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    FrameLayout frameLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout=findViewById(R.id.drawerLayout);
        navview=findViewById(R.id.navview);
        coordinatorLayout=findViewById(R.id.coordinatorlayout);
        toolbar=findViewById(R.id.toolbar);
        frameLayout=findViewById(R.id.framlayout);
        setuptoolbar();

        getSupportFragmentManager().beginTransaction().replace(R.id.framlayout, new HomeFragment()).commit();
        drawerLayout.closeDrawer(GravityCompat.START);


       navview.setNavigationItemSelectedListener(this);





    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navhome:{
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout, new HomeFragment()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                setTitle("Home");
                break;
            }


            case R.id.navexplore:
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout, new ExploreFragment()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                setTitle("Explore India");
                break;
            }
            case R.id.navcreate:{
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout, new CreateTourFragment()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                setTitle("Create Tour");

                break;
            }
            case R.id.navwhybookus:{
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout, new WhyBookUsFragment()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                setTitle("Why Book Us");

                break;
            }
            case R.id.navcontactus:{
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout, new ContactUsFragement()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);

                setTitle("Contact Us");

                break;
            }

        }
        return true;
    }

    void setuptoolbar()
    {
        setSupportActionBar(toolbar);
        setTitle("Home");


        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerToggle.setDrawerIndicatorEnabled(false);
        drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }


        });
        drawerToggle.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id=item.getItemId();

       if (id== android.R.id.home )
       {
           drawerLayout.openDrawer(GravityCompat.START);
       }

                return super.onOptionsItemSelected(item);


    }

}