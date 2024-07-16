//package com.example.uaspemrogramanmobile;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.content.ContextCompat;
//
//import android.Manifest;
//import android.content.pm.PackageManager;
//import android.location.Address;
//import android.location.Geocoder;
//import android.location.Location;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.google.android.gms.location.FusedLocationProviderClient;
//import com.google.android.gms.location.LocationServices;
//import com.google.android.gms.tasks.OnSuccessListener;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Locale;
//
//public class GPS2 extends AppCompatActivity {
//    FusedLocationProviderClient fusedLocationProviderClient;
//    TextView lattitude, longitude, address, country;
//    Button location;
//    private final int REQUEST_CODE = 100;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gps2);
//
//        lattitude = findViewById(R.id.getLattitude);
//        longitude = findViewById(R.id.getLongitude);
//        address = findViewById(R.id.getAddress);
//        country = findViewById(R.id.getCountry);
//        location = findViewById(R.id.getLocation);
//
//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
//        location.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getLastLocation();
//            }
//        });
//
//        public void getLastLocation() {
//            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
//                    @Override
//                    public void onSuccess(Location location) {
//                        if(location != null) {
//                            Geocoder geocoder = new Geocoder(GPS2.this, Locale.getDefault());
//                            List<Address> addresses = null;
//                            try {
//                                addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
//                                lattitude.setText((int) addresses.get(0).getLatitude());
//                                longitude.setText((int) addresses.get(0).getLongitude());
//                                address.setText(addresses.get(0).getAddressLine(0));
//                                country.setText(addresses.get(0).getCountryName());
//                            } catch (IOException e) {
//                                throw new RuntimeException(e);
//                            }
//
//                        }
//                    }
//                });
//            } else {
//                askPermission();
//            }
//        }
//    }
//}