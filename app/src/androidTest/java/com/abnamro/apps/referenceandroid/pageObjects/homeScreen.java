package com.abnamro.apps.referenceandroid.pageObjects;

import android.view.View;
import com.abnamro.apps.referenceandroid.R;
import org.hamcrest.Matcher;

import static androidx.test.espresso.matcher.ViewMatchers.*;

public class homeScreen {
    public static final String fragmentText = "Hello World!";
    public static final String toolBarText = "ReferenceAndroid";
    public static final String menuDescription = "More options";
    public static final String msgText = "Replace with your own action";
    public static final String menuTitleText = "Settings";

    public Matcher<View> homeScreen = withId(R.id.fragment);
    public Matcher<View> toolBar = withId(R.id.toolbar);
    public Matcher<View> screenTitle = withText(toolBarText);
    public Matcher<View> menuButton = withContentDescription(menuDescription);
    public Matcher<View> menuBar = withId(R.id.content);
    public Matcher<View> dropDownMenuTitle = withId(R.id.title);
    public Matcher<View> floatingActionButton = withId(R.id.fab);
    public Matcher<View> snackBar = withId(R.id.snackbar_text);
    public Matcher<View> navBar = withId(android.R.id.navigationBarBackground);
    public Matcher<View> statusBar = withId(android.R.id.statusBarBackground);
}
