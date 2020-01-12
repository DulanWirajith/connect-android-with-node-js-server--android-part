package com.example.connectandroidwithnodeserver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.connectandroidwithnodeserver.model.RegisterRequest;
import com.example.connectandroidwithnodeserver.model.RegisterResponse;
import com.example.connectandroidwithnodeserver.remote_connection.API;
import com.example.connectandroidwithnodeserver.remote_connection.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignup = findViewById(R.id.btn_signup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register_passenger();

                Context context = getApplicationContext();
                CharSequence text = "SignUp Button Clicked!!...";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });
    }

    public void register_passenger() {
//        create API object
        API service = RetrofitClient.createService(API.class);

//        create RegisterRequest object
        RegisterRequest registerRequest = new RegisterRequest();

        registerRequest.setPassenger_mail("dulanwirajith1995@gmail.com");
        registerRequest.setFirst_name("Dulan");
        registerRequest.setLast_name("Wirajith");
        registerRequest.setGender("male");
        registerRequest.setContact_no("077123456");
        registerRequest.setBirthday("1995/06/11");
        registerRequest.setPassword("123456");

//        request and get response
        final Call<RegisterResponse> isRegisterSuccessful = service.registerUser(registerRequest);


        isRegisterSuccessful.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();

                } else {

                }

                if (response.code() == 500) {
                    Toast.makeText(MainActivity.this, String.format("%s", response.message()), Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Context context = getApplicationContext();
                CharSequence text = "failed";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}
