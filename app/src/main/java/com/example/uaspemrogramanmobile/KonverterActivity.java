package com.example.uaspemrogramanmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class KonverterActivity extends AppCompatActivity {
    TextView t;
    EditText e;
    Button b;
    RadioButton rb1, rb2, rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konverter);

        t = findViewById(R.id.textView);
        e = findViewById(R.id.editTextNumber);
        b = findViewById(R.id.button);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double k = Double.parseDouble(e.getText().toString());

                if(rb1.isChecked()) {
                    double k1 = k*15.227;
                    e.setText(String.format("%.2f",k1));
                    Toast.makeText(KonverterActivity.this, String.format("%.2f",k1)+" Rupiah ", Toast.LENGTH_SHORT).show();
                } else if (rb1.isChecked()) {
                    double k1 = k*16.264;
                    e.setText(String.format("%.2f",k1));
                    Toast.makeText(KonverterActivity.this, String.format("%.2f",k1)+" Rupiah ", Toast.LENGTH_SHORT).show();
                } else {
                    double k1 = k*18.31448;
                    e.setText(String.format("%.2f",k1));
                    Toast.makeText(KonverterActivity.this, String.format("%.2f",k1)+" Rupiah ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Pengaturan");
        menu.add("Nilai Kami");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getTitle().equals("Pengaturan"))
            Toast.makeText(this, "Saya butuh bantuan", Toast.LENGTH_SHORT).show();
        else if(item.getTitle().equals("Nilai Kami"))
            Toast.makeText(this, "Saya bingung", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
