package com.jennifer.playzoom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.jennifer.playzoom.databinding.ActivityPrincipalBinding;

public class PrincipalActivity extends AppCompatActivity {

    private ActivityPrincipalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fabAddMovie.setOnClickListener(v -> {
            Snackbar.make(binding.getRoot(), "Add a movie", Snackbar.LENGTH_SHORT).show();
        });
        binding.tbPlayzoom.setTitle("Bienvenidos(as)");
        setSupportActionBar(binding.tbPlayzoom);

    }
}