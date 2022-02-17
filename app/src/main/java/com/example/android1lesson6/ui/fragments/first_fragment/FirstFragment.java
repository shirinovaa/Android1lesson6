package com.example.android1lesson6.ui.fragments.first_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1lesson6.R;
import com.example.android1lesson6.databinding.FragmentFirstBinding;
import com.example.android1lesson6.ui.fragments.first_fragment.adapter.Adapter;
import com.example.android1lesson6.ui.fragments.second_fragment.SecondFragment;
import com.example.android1lesson6.listener.OnClickListener;
import com.example.android1lesson6.model.Model;

public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    Adapter adapterData;
    Model modelData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapterData = new Adapter();
        binding.recView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recView.setAdapter(adapterData);
        listener();
        getData();

    }

    private void listener() {
        binding.btnOpenToSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, secondFragment).commit();
            }

        });

        adapterData.setOnItemClickListener(new OnClickListener() {
            @Override
            public void onItemClickListener(int position, Model modelData) {
                SecondFragment secondFragment = new SecondFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, secondFragment).commit();
                Model modelData1 = new Model(adapterData.list.get(position).getData().trim());
                Bundle bundle = new Bundle();
                bundle.putSerializable("key1", modelData1);
                secondFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, secondFragment).commit();


            }
        });
    }


    private void getData() {
        if (getArguments() != null) {
//              String data = getArguments().getString("key");
//              binding.tvValue.setText(data);
             modelData = (Model) getArguments().getSerializable("key");
             adapterData.addData(modelData);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}