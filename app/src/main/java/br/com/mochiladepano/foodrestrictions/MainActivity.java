/*
 * Copyright (C) 2015-2016 The Food Restriction Project Team
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package br.com.mochiladepano.foodrestrictions;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private static AppSettings settingsApp;
    private static FoodIconSettings settingsFood;
    private boolean showHelp = true;

    private FoodIconList foodIconList;

    public static AppSettings getAppSettings() {
        return settingsApp;
    }

    public static FoodIconSettings getFoodSettings() { return settingsFood; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        settingsApp = AppSettings.getSettingsApp(this);
        settingsFood = FoodIconSettings.getFoodIconSettings(this);
        foodIconList = new FoodIconList();

        if (showHelp) {
            if (settingsApp.isHelpDialog()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(getResources().getString(R.string.help_title));
                builder.setMessage(getResources().getString(R.string.help_message));
                builder.setPositiveButton(getResources().getString(R.string.help_not_show), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        settingsApp.setHelpDialog(false);
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
            showHelp = false;
        }

        Fragment fragment = null;

        try {
            if (checkConfig()) {
                fragment = FoodIconGrid.class.newInstance();
            } else {
                fragment = FoodIconConfig.class.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

    }

    public boolean checkConfig() {
        if (foodIconList.getFoodRestrictionList(true).size() <= 0) {
            Toast.makeText(
                    getApplicationContext(),
                    getResources()
                            .getString(R.string.no_config_msg),
                    Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass = null;

        switch (id) {
            case R.id.nav_icons:
                if (checkConfig()) {
                    fragmentClass = FoodIconGrid.class;
                } else {
                    fragmentClass = FoodIconConfig.class;
                }
                break;

            case R.id.nav_text:
                if (checkConfig()) {
                    fragmentClass = FoodMessages.class;
                } else {
                    fragmentClass = FoodIconConfig.class;
                }
                break;

            case R.id.nav_app_settings:
                fragmentClass = AppConfig.class;
                break;

            case R.id.nav_veg_vegan:
                fragmentClass = MessageLanguageSelector.class;
                break;

            case R.id.nav_food_settings:
                fragmentClass = FoodIconConfig.class;
                break;

            case R.id.nav_about_us:
                fragmentClass = AboutUs.class;
                break;
        }

        if (fragmentClass != null) {
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
