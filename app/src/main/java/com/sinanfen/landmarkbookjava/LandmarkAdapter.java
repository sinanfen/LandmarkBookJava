package com.sinanfen.landmarkbookjava;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sinanfen.landmarkbookjava.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {

    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);//Inflate XML ile Code u birbirine bağlıyor.
        return new LandmarkHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkAdapter.LandmarkHolder holder, int position) {
        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
                //chosenLandmark = landmarkArrayList.get(position);
                //intent.putExtra("landmark",landmarkArrayList.get(position));
                Singleton singleton = Singleton.getInstance();
                singleton.setSentLandmark(landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder {
        private RecyclerRowBinding binding;

        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot()); //görünümü bu şekilde verebiliyoruz.
            this.binding = binding;
        }
    }
}
