package com.reto1_2.appmintic.controlador;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.reto1_2.appmintic.MainActivity;
import com.reto1_2.appmintic.modelo.Usuario;
import com.reto1_2.appmintic.vista.RegistroActivity;

public class RegistroController {

    public static void crearUsuario(Context context, String nombre, String correo, String pass) {

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(correo, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {   //-----metodo de autenticacion
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isComplete()){
                            registroUsuario(context, nombre, correo);
                        }else
                            Toast.makeText(context, "Error de registro", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private static void registroUsuario(Context context, String nombre, String correo) {

        try {

            FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            String id = firebaseUser.getUid();
            long tiempoRegistro = firebaseUser.getMetadata().getCreationTimestamp();

            Usuario usuario = new Usuario(id, nombre, correo, "", tiempoRegistro);

            FirebaseFirestore.getInstance()
                    .collection(Constantes.USUARIOS)
                    .document(id)
                    .set(usuario, SetOptions.merge())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            
                            if (task.isComplete()){
                                Intent intent = new Intent(context, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                context.startActivity(intent);
                            }else
                                Toast.makeText(context, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                        }
                    });
            
        }catch (NullPointerException e){
            e.getCause();
        }

    }
}
