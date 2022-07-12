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
        AnyChartView chart = root.findViewById(R.id.chart);

        APIlib.getInstance().setActiveAnyChartView(chart);

        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();
        for (int i = 0; i <= 5 - 1; i++) {
            dataEntries.add(new ValueDataEntry(i, i));
        }
        pie.data(dataEntries);
        pie.title("Overview of Expenses");
        // pie.background(String.valueOf(Color.BLACK));
        pie.background().fill("@color/black");
        chart.setChart(pie);

        AnyChartView chart2 = root.findViewById(R.id.chart2);

        APIlib.getInstance().setActiveAnyChartView(chart2);
        Pie pie2 = AnyChart.pie();

        pie2.data(dataEntries);
        pie2.title("Overview of Expenses 2");
        // pie.background(String.valueOf(Color.BLACK));
        pie2.background().fill("@color/black");

        chart2.setChart(pie2);

        // chart.animate().rotation(5000).setDuration(5000);
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
