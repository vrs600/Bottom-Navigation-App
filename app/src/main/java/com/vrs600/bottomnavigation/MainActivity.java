package com.vrs600.bottomnavigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vrs600.bottomnavigation.fragments.Account;
import com.vrs600.bottomnavigation.fragments.Home;
import com.vrs600.bottomnavigation.fragments.Search;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout fragmentContainer;
    Toolbar toolbar;
    String TOOLBAR_TITLE = "Title";     // Set your toolbar title here

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingUpIds();
        initialTask();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            onItemSelected(item);
            return true;
        });
    }

    @SuppressLint("NonConstantResourceId")
    private void onItemSelected(MenuItem item) {
        Fragment selectedFragment;

        switch (item.getItemId()) {
            case R.id.nav_home: {
                selectedFragment = new Home();
            }
            break;

            case R.id.nav_search: {
                selectedFragment = new Search();
            }
            break;

            case R.id.nav_account: {
                selectedFragment = new Account();
            }
            break;

            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
        // Replacing selected fragment with the current fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting_menu: {
                onSettingMenuItemSelected();
            }
            break;

            case R.id.more_menu: {
                onMoreMenuItemSelected();
            }
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onMoreMenuItemSelected() {
        // Code here...
    }

    private void onSettingMenuItemSelected() {
        // Code here...
    }

    private void initialTask() {
        setSupportActionBar(toolbar);
        toolbar.setTitle(TOOLBAR_TITLE);

        // Setting initial fragment as 'Home' fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home()).commit();
    }

    private void settingUpIds() {
        toolbar = findViewById(R.id.main_home_toolbar);
        fragmentContainer = findViewById(R.id.fragment_container);
        bottomNavigationView = findViewById(R.id.btm_nav_main);
    }
}