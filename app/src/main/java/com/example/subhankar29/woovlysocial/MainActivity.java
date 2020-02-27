package com.example.subhankar29.woovlysocial;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.subhankar29.woovlysocial.model.Login;
import com.example.subhankar29.woovlysocial.model.User;
import com.example.subhankar29.woovlysocial.model.UserClient;

public class MainActivity extends AppCompatActivity {

    EditText email, passwordValue;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                login();
            }
        });

    }

    private void init(){
        email = findViewById(R.id.loginAddress);
        passwordValue = findViewById(R.id.password);
        login = findViewById(R.id.logIn);
    }

    //I am creating a dummy Login Method:
    private void login() {

        //Dummy checking for User Name and password:

        if((email.getText().toString().equals("admin")) && (passwordValue.getText().toString().equals("1234"))){
            //Go to the next Activity:
            Intent intent = new Intent(MainActivity.this, PostListingScreen.class);
            startActivity(intent);
            finish();

        }else{
            Toast.makeText(MainActivity.this, "Log In: admin Password: 1234", Toast.LENGTH_SHORT).show();
        }

    }

}


