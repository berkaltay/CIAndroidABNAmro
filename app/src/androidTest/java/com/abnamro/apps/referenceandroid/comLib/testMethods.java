package com.abnamro.apps.referenceandroid.comLib;

import android.widget.TextView;
import com.abnamro.apps.referenceandroid.pageObjects.homeScreen;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;

public class testMethods {

    private final homeScreen pageObjects = new homeScreen();

    public void verifyHomeScreenBody() {
        onView(allOf(instanceOf(TextView.class), withParent(pageObjects.homeScreen)))
                .check(matches(isDisplayed()))
                .check(matches(withText(homeScreen.fragmentText)));
    }

    public void verifyToolBar() {
        onView(allOf(instanceOf(TextView.class), withParent(pageObjects.toolBar)))
                .check(matches(isDisplayed()))
                .check(matches(pageObjects.screenTitle));

    }

    //More Options is displayed or not
    public void verifyMenuBar() {
        onView(pageObjects.menuButton)
                .check(matches(isDisplayed()));
    }

    //Popup with text "Settings"
    public void verifySubMenu() {
        //Before clicking on More Options
        onView(pageObjects.menuBar).check(doesNotExist());
        onView(pageObjects.menuButton).check(matches(isClickable()));
        onView(pageObjects.menuButton).perform(click());

        //After clicking on More Options
        onView(pageObjects.menuBar).check(matches(isDisplayed()));
        onView(pageObjects.dropDownMenuTitle).check(matches(isDisplayed()))
                .check(matches(withText(homeScreen.menuTitleText)));
    }

    public void verifyMailButton() {
        onView(pageObjects.floatingActionButton).check(matches(isDisplayed()))
                .check(matches(isClickable()))
                .check(matches(isEnabled()));

    }

    public void verifySnackBar() {
        onView(pageObjects.snackBar).check((doesNotExist()));
        onView(pageObjects.menuButton).check(matches(isClickable()));
        onView(pageObjects.floatingActionButton).perform(click());

        onView(pageObjects.snackBar)
                .check(matches(isDisplayed()))
                .check(matches(withText(homeScreen.msgText)));
    }

    public void verifyNavigationBar() {
        onView(pageObjects.navBar)
                .check(matches(isDisplayed()));
    }

    public void verifyStatusBar() {
        onView(pageObjects.statusBar)
                .check(matches(isDisplayed()));
    }

}
