package com.example.android1lesson6.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android1lesson6.R;
import com.example.android1lesson6.databinding.ActivityMainBinding;
import com.example.android1lesson6.ui.fragments.first_fragment.FirstFragment;

public class  MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
            .add(R.id.fragment_container, FirstFragment.class,null).commit();

        }
    }

    }
