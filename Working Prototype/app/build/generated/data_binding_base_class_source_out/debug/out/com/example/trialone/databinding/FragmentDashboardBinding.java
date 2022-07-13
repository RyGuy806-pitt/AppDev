// Generated by view binder compiler. Do not edit!
package com.example.trialone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.anychart.AnyChartView;
import com.example.trialone.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDashboardBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AnyChartView chart;

  @NonNull
  public final AnyChartView chart2;

  @NonNull
  public final AnyChartView chart3;

  @NonNull
  public final ScrollView scroll;

  @NonNull
  public final TextView textDashboard;

  private FragmentDashboardBinding(@NonNull LinearLayout rootView, @NonNull AnyChartView chart,
      @NonNull AnyChartView chart2, @NonNull AnyChartView chart3, @NonNull ScrollView scroll,
      @NonNull TextView textDashboard) {
    this.rootView = rootView;
    this.chart = chart;
    this.chart2 = chart2;
    this.chart3 = chart3;
    this.scroll = scroll;
    this.textDashboard = textDashboard;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDashboardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDashboardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_dashboard, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDashboardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.chart;
      AnyChartView chart = ViewBindings.findChildViewById(rootView, id);
      if (chart == null) {
        break missingId;
      }

      id = R.id.chart2;
      AnyChartView chart2 = ViewBindings.findChildViewById(rootView, id);
      if (chart2 == null) {
        break missingId;
      }

      id = R.id.chart3;
      AnyChartView chart3 = ViewBindings.findChildViewById(rootView, id);
      if (chart3 == null) {
        break missingId;
      }

      id = R.id.scroll;
      ScrollView scroll = ViewBindings.findChildViewById(rootView, id);
      if (scroll == null) {
        break missingId;
      }

      id = R.id.text_dashboard;
      TextView textDashboard = ViewBindings.findChildViewById(rootView, id);
      if (textDashboard == null) {
        break missingId;
      }

      return new FragmentDashboardBinding((LinearLayout) rootView, chart, chart2, chart3, scroll,
          textDashboard);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}