package com.happynewyear;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.happynewyear.chrisymas.ChristmasActivity;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;




public class MainActivity extends AppCompatActivity{
    private ViewHolder mViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewHolder = new ViewHolder();
        handleDrawer();

    }


    private void handleDrawer() {
        DuoDrawerToggle duoDrawerToggle = new DuoDrawerToggle(this,
                mViewHolder.mDuoDrawerLayout,
                mViewHolder.mToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);


        mViewHolder.btn_christmas.setOnClickListener(v->{
          startActivity(new Intent(MainActivity.this, ChristmasActivity.class));
        });


        mViewHolder.mDuoDrawerLayout.setDrawerListener(duoDrawerToggle);
        duoDrawerToggle.syncState();

        mViewHolder.mToolbar.setNavigationIcon(R.drawable.ic_lines_menu);
       // mViewHolder.mToolbar.hideOverflowMenu();
      //  mViewHolder.mToolbar.showContextMenu();


    }



          //  mViewHolder.mDuoDrawerLayout.closeDrawer();


    private class ViewHolder {
        private DuoDrawerLayout mDuoDrawerLayout;
        private Toolbar mToolbar;
        private TextView btn_christmas;

        ViewHolder() {
            mDuoDrawerLayout = findViewById(R.id.drawer);
            mToolbar = findViewById(R.id.toolbar);
            btn_christmas = findViewById(R.id.btn_christmas);
        }
    }




    @Override
    public void onBackPressed() {

        if (mViewHolder.mDuoDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mViewHolder.mDuoDrawerLayout.closeDrawer(GravityCompat.START);
        }
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("")
                .setMessage(getResources().getString(R.string.txt_close_app))
                .setPositiveButton(getResources().getString(R.string.txt_yes), (dialog, which) ->
                        finish())
                .setNegativeButton(getResources().getString(R.string.txt_No), null)
                .show();
    }


    @Override
    protected void onStop() {
        if (mViewHolder.mDuoDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mViewHolder.mDuoDrawerLayout.closeDrawer(GravityCompat.START);
        }
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mViewHolder.mDuoDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mViewHolder.mDuoDrawerLayout.closeDrawer(GravityCompat.START);
        }
    }
}
