package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String nama = getIntent().getStringExtra("NAMA");
        String alamat = getIntent().getStringExtra("ALAMAT");
        String kota = getIntent().getStringExtra("KOTA");
        String jenisKelamin = getIntent().getStringExtra("JENIS_KELAMIN");

        TextView textViewNama = findViewById(R.id.textViewNama);
        TextView textViewAlamat = findViewById(R.id.textViewAlamat);
        TextView textViewKota = findViewById(R.id.textViewKota);
        TextView textViewJK = findViewById(R.id.textViewJK);

        textViewNama.setText(nama);
        textViewAlamat.setText(alamat);
        textViewKota.setText(kota);
        textViewJK.setText(jenisKelamin);
    }
}
