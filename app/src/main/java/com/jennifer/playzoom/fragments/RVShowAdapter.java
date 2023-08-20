package com.jennifer.playzoom.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jennifer.playzoom.databinding.ItemShowBinding;
import com.jennifer.playzoom.model.Shows;

import java.util.List;

public class RVShowAdapter extends RecyclerView.Adapter<RVShowAdapter.ShowViewHolder> {

    private List<Shows> shows;
    private FavoriteClick favoriteClick;

    public RVShowAdapter(List<Shows> shows, FavoriteClick favoriteClick){
        this.shows = shows;
        this.favoriteClick = favoriteClick;
    }

    @NonNull
    @Override
    public ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemShowBinding binding = ItemShowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ShowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowViewHolder holder, int position) {
        holder.bind(shows.get(position));
    }

    @Override
    public int getItemCount() {
        return shows.size();
    }

    public class ShowViewHolder extends RecyclerView.ViewHolder{
        private ItemShowBinding binding;
        public ShowViewHolder(@NonNull ItemShowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Shows shows) {
            binding.txtName.setText(shows.getName());
            binding.btnFavorite.setOnClickListener(v -> {
                favoriteClick.onClick(shows);
            });
            Glide.with(itemView.getContext()).load(shows.getImgUrl()).into(binding.imgShow);
        }
    }

    public interface FavoriteClick{
        public void onClick(Shows shows);
    }
}


