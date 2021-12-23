package com.example.donation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.donation.main.DonationApp;
import com.example.models.Donation;

import java.util.ArrayList;
import java.util.List;

public class Base extends AppCompatActivity {
    public DonationApp app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (DonationApp) getApplication();
//        app.dbManager.open();
//        app.dbManager.setTotalDonated(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        app.dbManager.close();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu (Menu menu){
        super.onPrepareOptionsMenu(menu);
        MenuItem report = menu.findItem(R.id.menuReport);
        MenuItem donate = menu.findItem(R.id.menuDonate);
        MenuItem reset = menu.findItem(R.id.menuReset);
        if(app.donations.isEmpty())
        {
            report.setEnabled(true);
            reset.setEnabled(false);
        }
        else {
            report.setEnabled(true);
            reset.setEnabled(true);
        }
        if(this instanceof MainActivity){
            donate.setVisible(false);
            if(!app.donations.isEmpty())
            {
                report.setVisible(true);
                reset.setEnabled(true);
            }
        }
        else {
            report.setVisible(false);
            donate.setVisible(true);
            reset.setVisible(true);
        }
        return true;
    }
    public void report(MenuItem item)
    {
        startActivity (new Intent(this, Report.class));
    }
    public void donate(MenuItem item)
    {
        startActivity (new Intent(this, MainActivity.class));
    }
    public void reset(MenuItem item) {}
}
