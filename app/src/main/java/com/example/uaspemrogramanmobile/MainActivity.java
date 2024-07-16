package com.example.uaspemrogramanmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText input_email, input_password;
    Button masuk, daftar;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_email = findViewById(R.id.inputEmail);
        input_password = findViewById(R.id.inputPassword);
        masuk = findViewById(R.id.btnMasuk);
        daftar = findViewById(R.id.btnDaftar);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DaftarActivity.class);
                startActivity(i);
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = input_email.getText().toString().trim();
                String password = input_password.getText().toString().trim();

                LoginEmailPasswordUser(email, password);
            }
        });
    }

    private void LoginEmailPasswordUser(String email, String password) {
        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();

                    Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                    i.putExtra("email", email);
                    i.putExtra("password", password);
                    startActivity(i);
                }
            });
        }
    }
}