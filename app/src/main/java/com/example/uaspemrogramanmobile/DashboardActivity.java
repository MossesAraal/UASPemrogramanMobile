package com.example.uaspemrogramanmobile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    private TextView email, password;
    private static final int REQUEST_CODE = 22;
    Button btn_kamera, btn_konverter, btn_kompas, btn_gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent i = getIntent();
        String i_email = i.getStringExtra("email");
        String i_password = i.getStringExtra("password");

        btn_kamera = findViewById(R.id.kamera);
        btn_konverter = findViewById(R.id.konverter);
        btn_kompas = findViewById(R.id.kompas);
        btn_gps = findViewById(R.id.gps);
//        email = findViewById(R.id.email);
//        email.setText(i_email);
//        password = findViewById(R.id.password);
//        password.setText(i_password);

        btn_kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(kamera, REQUEST_CODE);
            }
        });

        btn_konverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent konverter = new Intent(DashboardActivity.this, KonverterActivity.class);
                startActivity(konverter);
            }
        });

        btn_kompas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kompas = new Intent(DashboardActivity.this, KompasActivity.class);
                startActivity(kompas);
            }
        });

        btn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gps = new Intent(DashboardActivity.this, GPSActivity.class);
                startActivity(gps);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}