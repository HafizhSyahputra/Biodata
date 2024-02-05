package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextNis;
    private EditText editTextnama;
    private EditText editTextalamat;
    private Spinner editTextkota;
    private RadioGroup radioGroupJK;
    private EditText editTextumur;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNis = findViewById(R.id.ETnis);
        editTextnama = findViewById(R.id.ETnama);
        editTextalamat = findViewById(R.id.ETalamat);
        editTextkota = findViewById(R.id.listItem);
        radioGroupJK = findViewById(R.id.pilih_jk);
        editTextumur = findViewById(R.id.ETUmur);

        buttonAdd = findViewById(R.id.submitButton);
        buttonAdd.setOnClickListener(this);
    }

    private void addEmployee() {
        final String nis = editTextNis.getText().toString().trim();
        final String nama = editTextnama.getText().toString().trim();
        final String alamat = editTextalamat.getText().toString().trim();
        final String kota = editTextkota.getSelectedItem().toString().trim();

        int selectedId = radioGroupJK.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);

        if (selectedRadioButton != null) {
            final String jk = selectedRadioButton.getText().toString().trim();
            final String umur = editTextumur.getText().toString().trim();

            class AddEmployee extends AsyncTask<Void, Void, String> {
                ProgressDialog loading;

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    loading = ProgressDialog.show(MainActivity.this, "Menambahkan...", "Tunggu...", false, false);
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    loading.dismiss();
                    Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                }

                @Override
                protected String doInBackground(Void... v) {
                    HashMap<String, String> params = new HashMap<>();
                    params.put(com.example.biodata.konfigurasi.KEY_EMP_NIS, nis);
                    params.put(com.example.biodata.konfigurasi.KEY_EMP_NAMA, nama);
                    params.put(com.example.biodata.konfigurasi.KEY_EMP_ALAMAT, alamat);
                    params.put(com.example.biodata.konfigurasi.KEY_EMP_KOTA, kota);
                    params.put(com.example.biodata.konfigurasi.KEY_EMP_JK, jk);
                    params.put(com.example.biodata.konfigurasi.KEY_EMP_UMUR, umur);
                    RequestHandler rh = new RequestHandler();
                    return rh.sendPostRequest(com.example.biodata.konfigurasi.URL_ADD, params);
                }
            }

            AddEmployee ae = new AddEmployee();
            ae.execute();
        } else {
            Toast.makeText(MainActivity.this, "Pilih jenis kelamin", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == buttonAdd) {
            addEmployee();
        }
    }
}
