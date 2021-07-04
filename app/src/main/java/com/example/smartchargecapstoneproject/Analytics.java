package com.example.smartchargecapstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Analytics extends AppCompatActivity {
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);

        backBtn = findViewById(R.id.analyticsBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Analytics.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });

        GraphView graph = (GraphView) findViewById(R.id.graph);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

        double y;
        for (int x=0; x<90; x++){
            y=Math.sin(2*x*0.2)-2*Math.sin(x*0.2);
            series.appendData(new DataPoint(x,y), true, 90);
        }

        graph.addSeries(series);

        series.setColor(Color.RED);
        series.setTitle("Power Consumption");
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(8);
        series.setThickness(4);

    }
}