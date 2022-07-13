package com.example.trialone.ui.dashboard;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.anychart.APIlib;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

import com.example.trialone.databinding.FragmentDashboardBinding;
import com.example.trialone.R;


public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    AnyChartView chart;
    AnyChartView chart2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //CHART 1 BLOCK Start
        AnyChartView chart = root.findViewById(R.id.chart);

        APIlib.getInstance().setActiveAnyChartView(chart);

        Cartesian cartesian = AnyChart.column();

        //fake values as data
        List<DataEntry> dataEntries = new ArrayList<>();
        for (int i = 0; i <= 5 - 1; i++) {
            dataEntries.add(new ValueDataEntry(i, i));
        }
        //end fake data

        cartesian.data(dataEntries);
        cartesian.title("Tests per Day");
        // pie.background(String.valueOf(Color.BLACK));
        cartesian.background().fill("@color/black");
        chart.setChart(cartesian);
        //CHART 1 BLOCK End

        //CHART 2 BLOCK Start
        AnyChartView chart2 = root.findViewById(R.id.chart2);

        APIlib.getInstance().setActiveAnyChartView(chart2);
        Cartesian pie2 = AnyChart.line();

        pie2.data(dataEntries);
        pie2.title("IOP Level");
        // pie.background(String.valueOf(Color.BLACK));
        pie2.background().fill("@color/black");

        chart2.setChart(pie2);
        //CHART 2 BLOCK End

        //CHART 3 BLOCK Start
        AnyChartView chart3 = root.findViewById(R.id.chart3);

        APIlib.getInstance().setActiveAnyChartView(chart3);

        Cartesian cartesian2 = AnyChart.column();

        cartesian2.data(dataEntries);
        cartesian2.title("Average IOP");
        // pie.background(String.valueOf(Color.BLACK));
        cartesian2.background().fill("@color/black");
        chart3.setChart(cartesian2);

        // chart.animate().rotation(5000).setDuration(5000);
        //CHART 3 BLOCK End

        //Finalize Screen when Data tab is clicked
        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
