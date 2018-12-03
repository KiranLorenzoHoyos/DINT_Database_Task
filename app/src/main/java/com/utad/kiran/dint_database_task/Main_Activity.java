package com.utad.kiran.dint_database_task;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.utad.kiran.dint_database_task.ClassDialog.Class_Fragment;
import com.utad.kiran.dint_database_task.CommunityDialog.Community_Fragment;
import com.utad.kiran.dint_database_task.Notification.Notification_Activity;
import com.utad.kiran.dint_database_task.ProfessorDialog.Professor_Fragment;
import com.utad.kiran.dint_database_task.Qualification.Qualification_Activity;

public class Main_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.nav_view);
        LayoutInflater.from(getBaseContext()).inflate(R.layout.nav_header, navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        email = navigationView.findViewById(R.id.profileEmail);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Class_Fragment()).commit();
            navigationView.setCheckedItem(R.id.nav_class);
        }
        email.setText(Session.getInstance().user.getUserMail());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_class:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Class_Fragment()).commit();
                break;
            case R.id.nav_notifications:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Notification_Activity()).commit();
                break;
            case R.id.nav_qualifications:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Qualification_Activity()).commit();
                break;
            case R.id.nav_professors:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Professor_Fragment()).commit();
                break;
            case R.id.nav_communities:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Community_Fragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
