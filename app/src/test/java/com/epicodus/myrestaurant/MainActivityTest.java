package com.epicodus.myrestaurant;

import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

import com.epicodus.myrestaurant.ui.MainActivity;
import com.epicodus.myrestaurant.ui.RestaurantListActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertTrue;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
/**
 * Created by Guest on 6/27/16.
 */
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup(){
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent(){
        TextView appNameTextView = (TextView) activity.findViewById(R.id.appNameTextView);
        assertTrue("MyRestaurants".equals(appNameTextView.getText().toString()));
    }

    @Test
    public void secondActivityStarted(){
        activity.findViewById(R.id.findRestaurantsButton).performClick();
        Intent expectedIntent = new Intent(activity, RestaurantListActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }


}
