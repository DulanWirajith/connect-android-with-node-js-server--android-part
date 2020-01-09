package com.example.connectandroidwithnodeserver.remote_connection;

import com.example.connectandroidwithnodeserver.model.RegisterRequest;
import com.example.connectandroidwithnodeserver.model.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
//    method for call registration route in node server
    @POST("/api/v1.0.0/registration")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);
}
