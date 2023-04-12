package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class Covid_Graph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid__graph);
      // pieChart=findViewById(R.id.piechart);
       // pieChart.addPieSlice(new PieModel("cases",Integer.parseInt(tcase.getText().toString(), Color.parseColor("#FFA726"))));


    }
}