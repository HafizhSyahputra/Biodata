package com.example.biodata;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText etNama, etAlamat;
    private Spinner listItem;
    private RadioGroup pilihJK;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.ETnama);
        etAlamat = findViewById(R.id.ETalamat);
        listItem = findViewById(R.id.listItem);
        pilihJK = findViewById(R.id.pilih_jk);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString();
                String alamat = etAlamat.getText().toString();
                String kota = listItem.getSelectedItem().toString();
                RadioButton selectedRadioButton = findViewById(pilihJK.getCheckedRadioButtonId());
                String jenisKelamin = selectedRadioButton.getText().toString();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("NAMA", nama);
                intent.putExtra("ALAMAT", alamat);
                intent.putExtra("KOTA", kota);
                intent.putExtra("JENIS_KELAMIN", jenisKelamin);
                startActivity(intent);

            }
        });
    }
}
