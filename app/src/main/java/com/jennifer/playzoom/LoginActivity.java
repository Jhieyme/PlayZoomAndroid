package com.jennifer.playzoom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Toast;

import com.jennifer.playzoom.databinding.ActivityLoginBinding;
import com.jennifer.playzoom.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v -> {
            //Toast.makeText(this, "Login press", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PrincipalActivity.class);
            intent.putExtra(PrincipalActivity.EMAIL, binding.tilEmail.getEditText().getText().toString());
            startActivity(intent);
            finish();
        });

        binding.tilEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Boolean isOk = isCredentialsValidate(s.toString(), binding.tilPassword.getEditText().getText().toString());
                binding.btnLogin.setEnabled(isOk);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //--------------------------------------------------------------------------------

        binding.tilPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Boolean isOk = isCredentialsValidate(binding.tilEmail.getEditText().getText().toString(), s.toString());
                binding.btnLogin.setEnabled(isOk);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private Boolean isCredentialsValidate(String email, String password){
        Boolean isEmailOk = !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
        Boolean isPasswordOk = password.length() >= 8;
        return isEmailOk && isPasswordOk;
    }
}