package com.reto1_2.appmintic.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.reto1_2.appmintic.MainActivity;
import com.reto1_2.appmintic.R;

public class LoginActivity extends AppCompatActivity {

    EditText et_user, et_pass;
    TextView tv_lost_pass, tv_registro;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_user = findViewById(R.id.et_user);
        et_pass = findViewById(R.id.et_pass);
        tv_lost_pass = findViewById(R.id.tv_lost_pass);
        tv_registro = findViewById(R.id.tv_registro);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

        tv_lost_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this, LostPassActivity.class));
            }
        });

        tv_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this , RegistroActivity.class));
            }
        });



    }
}