package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistroActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText correo;
    private EditText contrasena;
    private EditText contrasenaConfirmacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();

        correo = findViewById(R.id.etemailregistro);
        contrasena = findViewById(R.id.etcontrasenaregistro);
        contrasenaConfirmacion = findViewById(R.id.etconfirmarcontrasenaregistro);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void registrarUsuario(View view) {

        if (contrasena.getText().toString().equals(contrasenaConfirmacion.getText().toString())) {

            mAuth.createUserWithEmailAndPassword(correo.getText().toString(), contrasena.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                //Log.d(TAG, "signInWithCustomToken:success");
                                Toast.makeText(getApplicationContext(), "Usuario creado.", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(i);
                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                //Log.w(TAG, "signInWithCustomToken:failure", task.getException());
                                Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }
                        }
                    });
        }else {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para regresar al activity de login.

    public void Anterior(View view) {
        Intent anterior = new Intent(this, LoginActivity.class);
        startActivity(anterior);
    }
}