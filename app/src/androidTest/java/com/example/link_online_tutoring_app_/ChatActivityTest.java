package com.example.link_online_tutoring_app_;


import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.test.InstrumentationRegistry;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.content.Context.MODE_PRIVATE;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

@RunWith(AndroidJUnit4.class)
public class ChatActivityTest {
    @Rule
    public ActivityTestRule rule = new ActivityTestRule(ChatActivity.class, true, false);
    SharedPreferences.Editor PE;
    public static String SHARED_PREF_LOGIN="shared_prefs_login";


    @Before
    public void setUp() {
        Context cx = getInstrumentation().getTargetContext();
        PE = cx.getSharedPreferences(LoginActivity.SHARED_PREF_LOGIN, Context.MODE_PRIVATE).edit();
        PE.putString("Key", "90");
        PE.apply();
        PE.commit();
    }
    @Test
    public void onCreate() {
    }


    @Test
    public  void Chats1(){
        rule.launchActivity(new Intent());
        onView(withId(R.id.btnReload)).perform(click());

    }


    @Test
    public  void chats2(){
        int i = 91;
        String name = "Murphy";
        Intent id = new Intent();
        id.putExtra("receiver",name);
        id.putExtra("receiver_id",i );
        rule.launchActivity(id);
        onView(withId(R.id.btnReload)).perform(click());


    }

    @Test
    public void onCreate2() {
    }

    @Test
    public  void sendingText(){
        int i = 91;
        String name = "Murphy";
        Intent id = new Intent();
        id.putExtra("receiver",name);
        id.putExtra("receiver_id",i );
        rule.launchActivity(id);
        onView(withId(R.id.messageEText)).perform(typeText("hey budyy"));
        onView(withId(R.id.btnSend)).perform(click());
        onView(withId(R.id.btnReload)).perform(click());


    }




}
