package com.example.android1lesson6.ui.fragments.second_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android1lesson6.R;
import com.example.android1lesson6.databinding.FragmentSecondBinding;
import com.example.android1lesson6.model.Model;
import com.example.android1lesson6.ui.fragments.first_fragment.FirstFragment;

import java.text.BreakIterator;
import java.util.Locale;
import java.util.Timer;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    Model model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupListener();
    }

    private void setupListener() {
        binding.bynSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = binding.etInputText.getText().toString().trim();
                model = new Model(message);
                Bundle bundle = new Bundle();
                bundle.putSerializable("key",model);
                FirstFragment firstFragment = new FirstFragment();
                firstFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,firstFragment).commit();
            }
        });
    }

    // getSupportFragmentManager

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
