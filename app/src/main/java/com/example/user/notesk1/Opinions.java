package com.example.user.notesk1;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.R.attr.key;

public class Opinions extends AppCompatActivity {
    TextView name, opinion, results;
    EditText nameV, opinionV;
    Button btinsert, btshow;
    RequestQueue requestQueue;
    String insertURL = "http://knc.freevar.com/insertReview.php";
    //String showAllURL="http://localhost/Android/selectAllReviews.php";
    private String key="khaled";

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinions);

            name = (TextView) findViewById(R.id.nameTextview);
        opinion = (TextView) findViewById(R.id.opinionTextView);
        nameV = (EditText) findViewById(R.id.nameEditText);
        opinionV = (EditText) findViewById(R.id.opinionEditText);
        //results = (TextView) findViewById(R.id.results);
      //  results.setMovementMethod(new ScrollingMovementMethod());
        btinsert = (Button) findViewById(R.id.btinsert);
        btshow = (Button) findViewById(R.id.btshow);
       // final String showAllURL = "http://knc.freevar.com/selectAllReviews.php";




        requestQueue = Volley.newRequestQueue(getApplicationContext());

        btshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Opinions.this,OpinionsShow.class);
                startActivity(i1);
            }
        });

        btinsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest request = new StringRequest(Request.Method.POST, insertURL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println(response.toString());
                        Toast.makeText(Opinions.this,"Review added",Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Opinions.this,"Duplicate entries",Toast.LENGTH_SHORT).show();
                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("authorName", nameV.getText().toString());
                        parameters.put("userReview", opinionV.getText().toString());


                        return parameters;
                    }
                };
                requestQueue.add(request);
            }

        });

    }
}
