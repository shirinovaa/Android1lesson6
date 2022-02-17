package com.example.android1lesson6.ui.fragments.first_fragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android1lesson6.databinding.HolderItemBinding;
import com.example.android1lesson6.listener.OnClickListener;
import com.example.android1lesson6.model.Model;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.HolderData> {

    public ArrayList<Model> list = new ArrayList<>();
    OnClickListener onClickListener;

    public void setOnItemClickListener(OnClickListener onItemClickListener) {
        this.onClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderData(HolderItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(Model model) {
        this.list.add(model);
        notifyDataSetChanged();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        private HolderItemBinding binding;

        public HolderData(@NonNull HolderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Model model) {
            binding.tvData.setText(model.getData());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onItemClickListener(getAdapterPosition(), model);
                }
            });


        }
    }
}
