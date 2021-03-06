package com.example.link_online_tutoring_app_;

import android.content.Intent;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.view.FocusFinder;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.TypeTextAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressMenuKey;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.hasItem;

@RunWith(AndroidJUnit4.class)
public class aaviewPostTest {

    private int code = 1;

    @Rule
    public ActivityTestRule rule = new ActivityTestRule(ViewPosts.class, true, false);


    @Test
    public  void search(){
        Intent id = new Intent();
        id.putExtra("course_id",code);
        rule.launchActivity(id);
        //onView(withId(R.id.search_post)).perform(click());
       // onView(withId(R.id.search_post)).perform(typeText("Do you think cgv is cool"));
       // onView(withId(R.id.search_post)).perform(ViewActions.closeSoftKeyboard());


    }

    @Test
    public void viewPost(){


        Intent id = new Intent();
        id.putExtra("course_id",code);
        rule.launchActivity(id);
        //onView(withId(R.id.post_recycle_view)).perform(
          //      RecyclerViewActions.actionOnItemAtPosition(0, dependent.clickChildViewWithId(R.id. post_like_btn)));

    }


    @Test
    public void  goToReplies(){
        Intent id = new Intent();
        id.putExtra("course_id",code);
        rule.launchActivity(id);
        //onView(withId(R.id.post_recycle_view)).perform(
          //      RecyclerViewActions.actionOnItemAtPosition(0, dependent.clickChildViewWithId(R.id. post_comments)));


    }


    public static class dependent {
        public  static ViewAction clickChildViewWithId(final int id) {
            return new ViewAction() {
                @Override
                public Matcher<View> getConstraints() {
                    return null;
                }
                @Override
                public String getDescription() {
                    return "Click on item with specified id";
                }
                @Override
                public void perform(UiController uiController, View view) {
                    View v1 = view.findViewById(id);
                    v1.performClick();
                }
            };
        }

    }







}
