package com.example.link_online_tutoring_app_;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

public class ChatActivityTest {
    SharedPreferences.Editor PE;
    public static String SHARED_PREF_LOGIN="shared_prefs_login";
    @Rule
    public ActivityTestRule rule = new ActivityTestRule(ChatActivity.class, true, false);


    @Test
    public  void Chats(){
        rule.launchActivity(new Intent());
        Context cx = getInstrumentation().getTargetContext();
        PE = cx.getSharedPreferences(LoginActivity.SHARED_PREF_LOGIN, Context.MODE_PRIVATE).edit();
        PE.putString("Key", "90");
        PE.apply();
        PE.commit();
        rule.launchActivity(new Intent());

    }
    


}
