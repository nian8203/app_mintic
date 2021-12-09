package com.reto1_2.appmintic.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reto1_2.appmintic.R;
import com.reto1_2.appmintic.controlador.RegistroController;
import com.reto1_2.appmintic.util.ValidarCorreo;

public class RegistroActivity extends AppCompatActivity {

    EditText et_id;
    EditText et_nombre;
    EditText et_correo;
    EditText et_conf_correo;
    EditText et_pass;
    EditText et_conf_pass;
    Button btn_registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_id = findViewById(R.id.et_id);
        et_nombre = findViewById(R.id.et_nombre);
        et_correo = findViewById(R.id.et_correo);
        et_pass = findViewById(R.id.et_pass);
        et_conf_pass = findViewById(R.id.et_conf_pass);
        btn_registrar = findViewById(R.id.btn_registrar);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                if (validarCampos()){
                    RegistroController.crearUsuario(RegistroActivity.this, getNombre(), getCorreo(), getPass());
                }else
                    Toast.makeText(RegistroActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                
            }
        });
    }

    public boolean validarCampos(){

        String nombre = getNombre().trim();
        String correo = getCorreo().trim();
        String pass = getPass().trim();
        String confPass = getConfPass().trim();

        if(nombre.length()>2 && ValidarCorreo.validar(correo) && pass.length()>5 && confPass.equals(pass)){
            return true;
        }else
            return false;
    }


    public String getId() {
        return et_id.getText().toString();
    }

    public String getNombre() {
        return et_nombre.getText().toString();
    }

    public String getCorreo() {
        return et_correo.getText().toString();
    }

    public String getConfCorreo() {
        return et_conf_correo.getText().toString();
    }

    public String getPass() {
        return et_pass.getText().toString();
    }

    public String getConfPass() {
        return et_conf_pass.getText().toString();
    }
}