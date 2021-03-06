package com.example.link_online_tutoring_app_.FacultiesAcitvities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.link_online_tutoring_app_.HomeActivity;
import com.example.link_online_tutoring_app_.ListAllUsers;
import com.example.link_online_tutoring_app_.PostsActivity;
import com.example.link_online_tutoring_app_.R;
import com.example.link_online_tutoring_app_.ViewPosts;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ScienceActivity extends AppCompatActivity {

    ArrayAdapter<String> arrayAdapter;
    ListView listView;


    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        listView = findViewById(R.id.listView);
        getJSON("https://lamp.ms.wits.ac.za/~s1819369/get_courses.php?id=1");
        listView.setAdapter(arrayAdapter);

        Log.d("Leo", "Entering");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) listView.getItemAtPosition(position);
                Toast.makeText(ScienceActivity.this,clickedItem, Toast.LENGTH_LONG).show();
                Log.d("Leo", "Entering");
                //perform item selected in the list view
                if(position == 0  ){ //Coms
                    Log.d("inif", "Within");
                    Intent intent = new Intent(ScienceActivity.this, ViewPosts.class);
                    intent.putExtra("course_id", 1);
                    startActivity(intent);
                }
                if(position ==1  ){ //APPM
                    Intent intent = new Intent(ScienceActivity.this, ViewPosts.class);
                    intent.putExtra("course_id", 2);
                    startActivity(intent);
                }
                if(position ==2  ){ //math
                    Intent intent = new Intent(ScienceActivity.this, ViewPosts.class);
                    intent.putExtra("course_id", 3);
                    startActivity(intent);
                }
                if(position ==3  ){ //physics
                    Intent intent = new Intent(ScienceActivity.this, ViewPosts.class);
                    intent.putExtra("course_id", 4);
                    startActivity(intent);
                }

            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        //perform item selected
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.private_chat:
                        startActivity(new Intent(ScienceActivity.this, ListAllUsers.class));
                        break;

                    case R.id.action_faculties:
                        startActivity(new Intent(ScienceActivity.this, HomeActivity.class));
                        finish();
                        break;
                    case R.id.posting:
                        startActivity(new Intent(ScienceActivity.this, PostsActivity.class));
                        break;
                }


            }
        });
    }


    //fetchData, you can make it a class to prevent code reuse
    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json).append("\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void loadIntoListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        String[] courses = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            courses[i] = obj.getString("name");
        }
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courses);
        listView.setAdapter(arrayAdapter);
    }

}





