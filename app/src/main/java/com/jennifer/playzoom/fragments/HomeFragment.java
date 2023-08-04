package com.jennifer.playzoom.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jennifer.playzoom.databinding.FragmentHomeBinding;
import com.jennifer.playzoom.model.Movie;
import com.jennifer.playzoom.model.Series;
import com.jennifer.playzoom.model.Shows;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RVResumeAdapter adapter  = new RVResumeAdapter(getData());
        binding.rvMoviesResume.setAdapter(adapter);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rvMoviesResume.setLayoutManager(layoutManager);
    }
    private List<Shows> getData(){
        List<Shows> shows = new ArrayList<>();
        shows.add(new Series("WandaVision", "https://assets-prd.ignimgs.com/2022/05/10/wandasgrief-oneup-1652213876179.jpg", 1));
        shows.add(new Series("Star Wars: Rebelds", "https://musingsonthem49.files.wordpress.com/2015/09/sw-rebels_tsol_poster.jpg", 3));
        shows.add(new Movie("Avengers", "https://img.ecartelera.com/img/35400/35493_nuevo-banner-con-los-vengadores.jpg", "Infinite Saga"));
        shows.add(new Movie("Barbie", "https://static.euronews.com/articles/stories/07/51/45/54/1440x810_cmsv2_d794baf9-5913-5e00-ab52-461ab3b4b56f-7514554.jpg", ""));
        shows.add(new Series("Black Mirror", "https://www.americatv.com.pe/cinescape/wp-content/uploads/2017/05/189068.jpg", 5));
        shows.add(new Series("The witcher", "https://redanianintelligence.com/wp-content/uploads/2023/06/poster-wide.jpg", 3));
        shows.add(new Movie("Oppenheimer", "https://i.ytimg.com/vi/MnE8L44r9VM/maxresdefault.jpg", ""));
        return shows;
    }
}