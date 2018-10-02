package com.example.briennemcnally.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.segment.analytics.Analytics;
import com.segment.analytics.Properties;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void segmentTrack(View v){
        Analytics.with(this).track("Clicked Track");
    }

    public void flush(View v){
        Analytics.with(this).flush();
    }

    public void productViewed(View v){
        Analytics.with(this).track("Product Viewed", new Properties().putValue("name", "Moto 360"));
    }

    public void purchasedItem(View v){
        Analytics.with(this).track("Purchased Item", new Properties().putValue("sku", "13d31").putRevenue(199.99));
    }
}
