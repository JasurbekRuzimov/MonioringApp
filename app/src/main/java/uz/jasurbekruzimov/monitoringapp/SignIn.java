package uz.jasurbekruzimov.monitoringapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uz.jasurbekruzimov.monitoringapp.Api.ApiClient;
import uz.jasurbekruzimov.monitoringapp.Api.ApiInterface;
import uz.jasurbekruzimov.monitoringapp.Api.LoginResponse;

public class SignIn extends AppCompatActivity {


    TextInputEditText emailAddress, password;
    Button signInBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailAddress = findViewById(R.id.emailLoginId);
        password = findViewById(R.id.passwordLoginId);
        signInBtn = findViewById(R.id.signInBtn);


        signInBtn.setOnClickListener(v -> {
            String email = Objects.requireNonNull(emailAddress.getText()).toString().trim();
            String pass = Objects.requireNonNull(password.getText()).toString().trim();

            if (email.isEmpty()) {
                emailAddress.setError("Email manzilni to'liq kiriting");
                emailAddress.requestFocus();
                return;
            }
            if (pass.isEmpty()) {
                password.setError("Parolni kiriting");
                password.requestFocus();
                return;
            }

            ApiInterface loginApi = ApiClient.getLoginApi();
            Call<LoginResponse> call = loginApi.loginWithCredentials(email, pass);

            call.enqueue(new Callback<LoginResponse>() {

                @Override
                public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                    if (response.isSuccessful()) {
                        LoginResponse loginResponse = response.body();
                        boolean success = Objects.requireNonNull(loginResponse).isSuccess();
                        String message = loginResponse.getMessage();

                        if (success) {
                            Intent intent = new Intent(SignIn.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(SignIn.this, message, Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignIn.this, getString(R.string.server_error), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                    Toast.makeText(SignIn.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}