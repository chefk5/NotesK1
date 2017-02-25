package com.example.user.notesk1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpinionsShow extends AppCompatActivity {
    Button btshow;
    TextView tv;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinions_show);
        btshow=(Button)findViewById(R.id.btshow);
        tv=(TextView)findViewById(R.id.show);
        final String showAllURL = "http://knc.freevar.com/selectAllReviews.php";
        tv.setMovementMethod(new ScrollingMovementMethod());//////////////////////////////////

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        btshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.POST, showAllURL,
                        new Response.Listener<JSONArray>() {

                            @Override
                            public void onResponse(JSONArray ja) {


                                try {
                                    for (int i = 0; i < ja.length(); i++) {
                                        JSONObject rev = ja.getJSONObject(i);
                                        String authorName = rev.getString("authorName");
                                        String userReview = rev.getString("userReview");

                                        tv.append(authorName+" was reviewed with:\n "+"\""+userReview+"\"\n"+"___________________"+"\n");



                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("error", error.toString());
                    }
                });
                // Add the request to the RequestQueue.
                requestQueue.add(jsonRequest);
            }


        });

    }
}
