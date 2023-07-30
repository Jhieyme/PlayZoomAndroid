package com.jennifer.playzoom.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jennifer.playzoom.databinding.ItemShowResumeBinding;
import com.jennifer.playzoom.model.Movie;
import com.jennifer.playzoom.model.Series;
import com.jennifer.playzoom.model.Shows;

import java.util.List;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;


public class RVResumeAdapter extends RecyclerView.Adapter<RVResumeAdapter.ResumeVH>{

    private List<Shows> shows;

    public  RVResumeAdapter(List<Shows> shows){

        this.shows = shows;
    }

    @NonNull
    @Override
    public ResumeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemShowResumeBinding binding = ItemShowResumeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ResumeVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ResumeVH holder, int position) {
        holder.bind(shows.get(position));
    }

    @Override
    public int getItemCount() {

        return shows.size();
    }

    class ResumeVH extends RecyclerView.ViewHolder{
        private ItemShowResumeBinding binding;

        public ResumeVH(ItemShowResumeBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Shows show) {
            if (show instanceof Movie){
                binding.txtSeason.setVisibility(View.GONE);
            } else if (show instanceof Series){
                binding.txtSeason.setVisibility(View.VISIBLE);
                binding.txtSeason.setText("Season " + ((Series) show).getSeason());
            }
            binding.txtName.setText(show.getName());
            ImageLoader imageLoader = Coil.imageLoader(binding.getRoot().getContext());
            ImageRequest request = new ImageRequest.Builder(binding.getRoot().getContext())
                    .data(show.getImgUrl())
                    .crossfade(true)
                    .target(binding.imgShow)
                    .build();
            imageLoader.enqueue(request);
        }
    }
}