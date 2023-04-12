package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.json.JSONException;
import org.json.JSONObject;

import static android.view.View.GONE;

public class CovidTrackerData extends AppCompatActivity {
    TextView totalCases ,totalRecovered,totalCritical,totalActive,totalDeaths,totalTests,affCount;
    SimpleArcLoader simpleArcLoader;
    Button chart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_tracker_data);
         totalCases=findViewById(R.id.totalCases);
         totalRecovered=findViewById(R.id.totalRecovered);
         totalCritical=findViewById(R.id.totalCritical);
         totalActive=findViewById(R.id.totalActive);
         totalDeaths=findViewById(R.id.totalDeaths);
         totalTests=findViewById(R.id.totalTests);
         affCount=findViewById(R.id.affCount);
         simpleArcLoader=findViewById(R.id.loader);
         chart=findViewById(R.id.chart);
        chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CovidTrackerData.this,Covid_Graph.class);

                startActivity(intent);
            }
        });






        fetchData();

    }






    private void fetchData() {
        String url="https://corona.lmao.ninja/v2/all/";
        simpleArcLoader.start();
        StringRequest request=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response.toString());

                            totalCases.setText(jsonObject.getString("cases"));
                            totalRecovered.setText(jsonObject.getString("recovered"));
                            totalCritical.setText(jsonObject.getString("critical"));
                            totalActive.setText(jsonObject.getString("active"));
                            totalDeaths.setText(jsonObject.getString("deaths"));
                            totalTests.setText(jsonObject.getString("tests"));
                            affCount.setText(jsonObject.getString("affectedCountries"));

                            simpleArcLoader.stop();
                            simpleArcLoader.setVisibility(View.GONE);


                        }
                        catch (JSONException e) {

                            e.printStackTrace();
                            simpleArcLoader.stop();
                            simpleArcLoader.setVisibility(View.GONE);
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CovidTrackerData.this,error.getMessage() ,Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);


    }
}