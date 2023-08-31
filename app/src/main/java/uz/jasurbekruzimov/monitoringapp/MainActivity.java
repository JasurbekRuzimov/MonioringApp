package uz.jasurbekruzimov.monitoringapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView navImg;
    PieChart pieChart3, pieChart1, pieChart2;
    Retrofit retrofit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navImg = findViewById(R.id.nav_menu);
        pieChart1 = findViewById(R.id.allCHart);
        pieChart2 = findViewById(R.id.prQiymatiCHart);
        pieChart3 = findViewById(R.id.ishOrniCHart);

        ArrayList<PieEntry> visitors = new ArrayList<>();
        visitors.add(new PieEntry(500, 2023));
        visitors.add(new PieEntry(600, 2024));
        visitors.add(new PieEntry(600, 2025));
        visitors.add(new PieEntry(600, 2026));

        PieDataSet pieDataSet = new PieDataSet(visitors, "");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart1.setData(pieData);
        pieChart1.getDescription().setEnabled(false);
        pieChart1.setCenterText("Loyihalar soni");
        pieChart1.animate();

        pieChart2.setData(pieData);
        pieChart2.getDescription().setEnabled(false);
        pieChart2.setCenterText("Loyihalar qiymati");
        pieChart2.animate();

        pieChart3.setData(pieData);
        pieChart3.getDescription().setEnabled(false);
        pieChart3.setCenterText("Loyihalar ish o'rni");
        pieChart3.animate();


        navImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }
}