package com.jennifer.playzoom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.jennifer.playzoom.databinding.ActivityPrincipalBinding;
import com.jennifer.playzoom.fragments.HomeFragment;

public class PrincipalActivity extends AppCompatActivity {

    private ActivityPrincipalBinding binding;
    public static String EMAIL = "EMAIL";
    private String email;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        sharedPreferences = getSharedPreferences(LoginActivity.SESSION_PREFERENCE, MODE_PRIVATE);

        setContentView(binding.getRoot());

        setSupportActionBar(binding.tbPlayzoom);
        setSession();
        addHomeFragment();
    }

    private void addHomeFragment() {
        getSupportFragmentManager().
                beginTransaction()
                .add(binding.fcvMain.getId(), new HomeFragment()).commit();
    }


    private void setSession() {
        Intent getIntent = getIntent();
        email = getIntent.getStringExtra(EMAIL);
        binding.txtEmail.setText(email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movie_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if (item.getItemId() == R.id.search){
            Snackbar.make(binding.getRoot(), "Search", Snackbar.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.settings) {
            Snackbar.make(binding.getRoot(), "Settings", Snackbar.LENGTH_SHORT).show();
            return true;
        }else if (item.getItemId() == R.id.logout) {
            sharedPreferences.edit().clear().apply();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return false;
    }
}