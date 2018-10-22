package com.dany.android.myapplication;

import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.dany.android.myapplication.adapter.VpHomeAdapter;
import com.dany.android.myapplication.fragment.AccountFragment;
import com.dany.android.myapplication.fragment.AppsFragment;
import com.dany.android.myapplication.fragment.FeedFragment;
import com.dany.android.myapplication.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private int[] icons = {
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_apps_black_24dp,
            R.drawable.ic_explore_black_24dp,
            R.drawable.ic_account_circle_black_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        changeStatusBarColor();
        setupViewPager(viewPager);
        setupTabIcon();
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }


    private void setupTabIcon() {
        // Setup tab Home
        TextView titleHome = (TextView) LayoutInflater.from(this).inflate(R.layout.layout_custom_tabs, null);
        titleHome.setText("Home");
        titleHome.setCompoundDrawablesWithIntrinsicBounds(0, icons[0], 0, 0);
        tabLayout.getTabAt(0).setCustomView(titleHome);

        // Setup tab Apps
        TextView titleApps = (TextView) LayoutInflater.from(this).inflate(R.layout.layout_custom_tabs, null);
        titleApps.setText("Apps");
        titleApps.setCompoundDrawablesWithIntrinsicBounds(0, icons[1], 0, 0);
        tabLayout.getTabAt(1).setCustomView(titleApps);

        // Setup tab Feed
        TextView titleFeed = (TextView) LayoutInflater.from(this).inflate(R.layout.layout_custom_tabs, null);
        titleFeed.setText("Feed");
        titleFeed.setCompoundDrawablesWithIntrinsicBounds(0, icons[2], 0, 0);
        tabLayout.getTabAt(2).setCustomView(titleFeed);

        // Setup tab Account
        TextView titleAccount = (TextView) LayoutInflater.from(this).inflate(R.layout.layout_custom_tabs, null);
        titleAccount.setText("Account");
        titleAccount.setCompoundDrawablesWithIntrinsicBounds(0, icons[3], 0, 0);
        tabLayout.getTabAt(3).setCustomView(titleAccount);
    }

    private void setupViewPager(ViewPager viewPager) {
        VpHomeAdapter vpHomeAdapter = new VpHomeAdapter(getSupportFragmentManager());
        vpHomeAdapter.addFrag(new HomeFragment());
        vpHomeAdapter.addFrag(new AppsFragment());
        vpHomeAdapter.addFrag(new FeedFragment());
        vpHomeAdapter.addFrag(new AccountFragment());
        viewPager.setAdapter(vpHomeAdapter);
    }

    private void initView() {
        viewPager = findViewById(R.id.vp_home);
        tabLayout = findViewById(R.id.tabs);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Apps");
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
