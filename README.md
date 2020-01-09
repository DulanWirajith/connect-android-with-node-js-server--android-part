# connect-with-node-server---android-part
Hey.. This is for you..

First you need to add dependencies to build.gradle file
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
    implementation 'com.squareup.retrofit2:converter-scalars:2.3.0'

Then you need to get permissions in manifest
    <uses-permission android:name="android.permission.INTERNET"/>

Then create a package named remote_connection
  create API.java public interface
    in there you have to change only methods
  create RetrofitClient.java class
    in there you have to change only base url

Then you have to create models to request and response
  eg:- RegisterRequest.java and RegisterResponse.java

And then you have to code in Activity file wchich you want to call the request
  eg:meke thiyenne main activity eke register form eka gahala. a nisa registerUser fuction eka call karanna oona    MainActivity.java file eke.

    //        create API object
        API service = RetrofitClient.createService(API.class);

//        create RegisterRequest object
        RegisterRequest registerRequest = new RegisterRequest();

        registerRequest.setPassenger_mail("themiya.gunasekara95@gmail.com");
        registerRequest.setFirst_name("Themiya");
        registerRequest.setLast_name("Gunasekara");
        registerRequest.setGender("male");
        registerRequest.setContact_no("0770471501");
        registerRequest.setBirthday("1995/06/11");
        registerRequest.setPassword("123456");

//        request and get response
        final Call<RegisterResponse> isRegisterSuccessful = service.registerUser(registerRequest);


        isRegisterSuccessful.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                Context context = getApplicationContext();
                CharSequence text = "request successful and get the response";
                int duration = Toast.LENGTH_SHORT;

//                System.out.println("response body :"+response.body().getMessage());
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
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

