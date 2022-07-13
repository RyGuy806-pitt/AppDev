package com.example.trialone.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.trialone.databinding.FragmentHomeBinding;
import com.example.trialone.databinding.FragmentDashboardBinding;
import com.example.trialone.R;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Btn = (Button) root.findViewById(R.id.Btn);
        Instructions = (TextView) root.findViewById(R.id.Instructions);
        proc();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private Button Btn;
    private TextView Instructions;
    private int clicks;

    //Start Test Button, Controls what text is displayed

    public void proc(){
        Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clicks = clicks + 1;
                if(clicks%2==0) {
                    Instructions.setText("Hello, Lets Begin");
                    Btn.setText("Start Test");
                }
                else{
                    Instructions.setText("Insert Instructions Here");
                    Btn.setText("Stop Test");
                }
            }
        });
    }
}