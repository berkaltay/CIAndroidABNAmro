package com.abnamro.apps.referenceandroid.test;


import android.content.Intent;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import com.abnamro.apps.referenceandroid.MainActivity;
import com.abnamro.apps.referenceandroid.comLib.testMethods;
import com.microsoft.appcenter.espresso.Factory;
import com.microsoft.appcenter.espresso.ReportHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class homeScreenTests extends testMethods {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    //helper to have reports on App center
    @Rule
    public ReportHelper reportHelper = Factory.getReportHelper();

    @Before
    public void setUp() {
        mActivityTestRule.launchActivity(new Intent());
        mActivityTestRule.getActivity();
    }

    @Test
    public void verifyHomeScreen() {
        verifyHomeScreenBody();
        verifyToolBar();
        verifyMenuBar();
        verifyNavigationBar();
        verifyStatusBar();
    }

    @Test
    public void verifyPopUpMenu() {
        verifyMenuBar();
        verifySubMenu();
    }

    @Test
    public void verifyMailButtonAndSnackBar() {
        verifyMailButton();
        verifySnackBar();
    }

    @After
    public void tearDown() {
        mActivityTestRule.finishActivity();
        //Takes screenshots for each test when the test run is completed
        reportHelper.label("Finishing Tests");
    }

}