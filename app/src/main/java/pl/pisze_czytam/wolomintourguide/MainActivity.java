package pl.pisze_czytam.wolomintourguide;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import pl.pisze_czytam.wolomintourguide.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final String STACK = "";
    ActivityMainBinding bind;
    FragmentManager fragmentManager;
    Fragment fragment;
    int countBackStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.getBackStackEntryCount();
        countBackStack = getFragmentManager().getBackStackEntryCount();

        if (savedInstanceState == null) {
            fragment = new MainFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black);

        bind.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                displayFragment(item);
                bind.drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    public void displayFragment(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_about:
                fragment = new MainFragment();
                break;
            case R.id.nav_history:
                fragment = new HistoryFragment();
                break;
            case R.id.nav_go:
                fragment = new GoFragment();
                break;
            case R.id.nav_eat:
                fragment = new EatFragment();
                break;
            case R.id.nav_drink:
                fragment = new DrinkFragment();
                break;
            case R.id.nav_sleep:
                fragment = new SleepFragment();
                break;
            default:
                fragment = new MainFragment();
        }
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(STACK).commit();
        setTitle(menuItem.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                bind.drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if (countBackStack == 0) {
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }
    }
}