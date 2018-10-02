package com.example.briennemcnally.testapplication;

import android.app.Application;
import com.segment.analytics.Analytics;
import com.segment.analytics.Analytics.LogLevel;
import com.segment.analytics.Properties;
import com.segment.analytics.Traits;
import com.segment.analytics.android.integrations.firebase.FirebaseIntegration;


public class TestApplication extends Application {
    @Override public void onCreate() {
        super.onCreate();
        Analytics analytics = new Analytics.Builder(this, "Qa2UrywujXhNCXzcV6CtoU3glgqoYYcG")
                .use(FirebaseIntegration.FACTORY)
                .logLevel(LogLevel.VERBOSE)
                .build();
        Analytics.setSingletonInstance(analytics);

        // Safely call Analytics.with(context) from anywhere within your app!
        Analytics.with(this).identify("user123", new Traits().putName("brie"), null);
        Analytics.with(this).track("Application Started");
        Analytics.with(this).track("Product Viewed", new Properties().putValue("name", "Moto 360"));
        Analytics.with(this).track("Purchased Item", new Properties().putValue("sku", "13d31").putRevenue(199.99));

    }
}
