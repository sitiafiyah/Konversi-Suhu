package com.siti.asyst.konversisuhusiti;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Double awal, celcius, reamur, fahrenheit, kelvin;

    EditText inputET;
    Button konversiButton;
    TextView hasilTV;
    Spinner dariSpinner, keSpinner;
    private final TextWatcher inputWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //textView.setVisibility(View.VISIBLE);
        }

        public void afterTextChanged(Editable s) {
            konversi();
        }
    };
    ArrayList<String> listSuhu = new ArrayList<>();
    ArrayList<String> listSuhu2 = new ArrayList<>();
    String selectedSuhu;
    String selectedSuhu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputET = findViewById(R.id.input_edittext);

        dariSpinner = findViewById(R.id.dari_spinner);
        keSpinner = findViewById(R.id.ke_spinner);

        dariSpinner.setOnItemSelectedListener(this);
        keSpinner.setOnItemSelectedListener(this);

        //konversiButton = findViewById(R.id.konversi_button);
        inputET.addTextChangedListener(inputWatcher);

        //konversiButton.setOnClickListener(this);
        hasilTV = findViewById(R.id.hasil_textview);

        listSuhu.add("Celcius");
        listSuhu.add("Fahrenheit");
        listSuhu.add("Reamur");
        listSuhu.add("Kelvin");

        listSuhu2.add("Celcius");
        listSuhu2.add("Fahrenheit");
        listSuhu2.add("Reamur");
        listSuhu2.add("Kelvin");

        ArrayAdapter<String> suhuAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listSuhu);
        dariSpinner.setAdapter(suhuAdapter);

        ArrayAdapter<String> suhu2Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listSuhu2);
        keSpinner.setAdapter(suhu2Adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedSuhu = dariSpinner.getSelectedItem().toString();
        selectedSuhu2 = keSpinner.getSelectedItem().toString();
        konversi();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.konversi_button:
//                String input = inputET.getText().toString();
//                String satuan = String.valueOf(dariSpinner.getSelectedItemPosition());
//                String tujuan = String.valueOf(keSpinner.getSelectedItemPosition());
//
//                if(inputET.getText().toString().equals("")){
//                    Toast.makeText(getBaseContext(), "Masukkan suhu awal", Toast.LENGTH_SHORT).show();
//                    awal = 0.0;
//                }else{
//                    awal = Double.parseDouble(inputET.getText().toString());
//                    if (!TextUtils.isEmpty(input)){
//                        if(satuan.equals("0") && tujuan.equals("0")){ //c - c
//                            celcius = awal;
//                            fahrenheit = (1.8 * awal) + 32;
//                            reamur = 0.8 * awal;
//                            kelvin = awal + 273;
//
//                            hasilTV.setText(String.valueOf(celcius));
//                        }else if(satuan.equals("0") && tujuan.equals("1")){ //c - f
//                            celcius = awal;
//                            fahrenheit = (1.8 * awal) + 32;
//                            reamur = 0.8 * awal;
//                            kelvin = awal + 273;
//
//                            hasilTV.setText(String.valueOf(fahrenheit));
//                        }else if(satuan.equals("0") && tujuan.equals("2")){ //c - r
//                            celcius = awal;
//                            fahrenheit = (1.8 * awal) + 32;
//                            reamur = 0.8 * awal;
//                            kelvin = awal + 273;
//
//                            hasilTV.setText(String.valueOf(reamur));
//                        }else if(satuan.equals("0") && tujuan.equals("3")){ //c - k
//                            celcius = awal;
//                            fahrenheit = (1.8 * awal) + 32;
//                            reamur = 0.8 * awal;
//                            kelvin = awal + 273;
//
//                            hasilTV.setText(String.valueOf(kelvin));
//                        }
//
//                        else if(satuan.equals("1") && tujuan.equals("0")){ // f - c
//                            celcius = 0.55555 *(awal - 32);
//                            reamur = 0.44444 * (awal-32);
//                            fahrenheit = awal;
//                            kelvin = celcius + 273;
//
//                            hasilTV.setText(String.valueOf(celcius));
//                        }else if(satuan.equals("1") && tujuan.equals("1")){ // f - f
//                            celcius = 0.55555 *(awal - 32);
//                            reamur = 0.44444 * (awal-32);
//                            fahrenheit = awal;
//                            kelvin = celcius + 273;
//
//                            hasilTV.setText(String.valueOf(fahrenheit));
//                        }else if(satuan.equals("1") && tujuan.equals("2")){ // f - r
//                            celcius = 0.55555 *(awal - 32);
//                            reamur = 0.44444 * (awal-32);
//                            fahrenheit = awal;
//                            kelvin = celcius + 273;
//
//                            hasilTV.setText(String.valueOf(reamur));
//                        }else if(satuan.equals("1") && tujuan.equals("3")){ // f - k
//                            celcius = 0.55555 *(awal - 32);
//                            reamur = 0.44444 * (awal-32);
//                            fahrenheit = awal;
//                            kelvin = celcius + 273;
//
//                            hasilTV.setText(String.valueOf(kelvin));
//                        }
//
//                        else if(satuan.equals("2") && tujuan.equals("0")){ //r-c
//                            celcius = 1.25 * awal;
//                            reamur = awal;
//                            fahrenheit = (2.25 * awal) + 32;
//                            kelvin = celcius + 273;
//
//                        hasilTV.setText(String.valueOf(celcius));
//                        }else if(satuan.equals("2") && tujuan.equals("1")){ //r-f
//                            celcius = 1.25 * awal;
//                            reamur = awal;
//                            fahrenheit = (2.25 * awal) + 32;
//                            kelvin = celcius + 273;
//
//
//                            hasilTV.setText(String.valueOf(fahrenheit));
//                        }else if(satuan.equals("2") && tujuan.equals("2")){ //r-r
//                            celcius = 1.25 * awal;
//                            reamur = awal;
//                            fahrenheit = (2.25 * awal) + 32;
//                            kelvin = celcius + 273;
//
//                            hasilTV.setText(String.valueOf(reamur));
//                        }else if(satuan.equals("2") && tujuan.equals("3")){ //r-k
//                            celcius = 1.25 * awal;
//                            reamur = awal;
//                            fahrenheit = (2.25 * awal) + 32;
//                            kelvin = celcius + 273;
//
//                            hasilTV.setText(String.valueOf(kelvin));
//                        }
//
//                        else if(satuan.equals("3") && tujuan.equals("0")){ //k-c
//                            celcius = awal-273;
//                            reamur = 0.8 * (awal-273);
//                            fahrenheit = (1.8 * (awal-273)) + 32;
//                            kelvin = awal;
//
//                            hasilTV.setText(String.valueOf(celcius));
//                        }else if(satuan.equals("3") && tujuan.equals("1")){ //k-f
//                            celcius = awal-273;
//                            reamur = 0.8 * (awal-273);
//                            fahrenheit = (1.8 * (awal-273)) + 32;
//                            kelvin = awal;
//
//                            hasilTV.setText(String.valueOf(fahrenheit));
//                        }
//                        else if(satuan.equals("3") && tujuan.equals("2")){ //k-r
//                            celcius = awal-273;
//                            reamur = 0.8 * (awal-273);
//                            fahrenheit = (1.8 * (awal-273)) + 32;
//                            kelvin = awal;
//
//                            hasilTV.setText(String.valueOf(reamur));
//                        }else if(satuan.equals("3") && tujuan.equals("3")){ //k-k
//                            celcius = awal-273;
//                            reamur = 0.8 * (awal-273);
//                            fahrenheit = (1.8 * (awal-273)) + 32;
//                            kelvin = awal;
//
//                            hasilTV.setText(String.valueOf(kelvin));
//                        }
//                    }
//                break;
//            }
//        }
//    }

    public void konversi() {
        String input = inputET.getText().toString();
        String satuan = String.valueOf(dariSpinner.getSelectedItemPosition());
        String tujuan = String.valueOf(keSpinner.getSelectedItemPosition());

        if (inputET.getText().toString().equals("")) {
            //Toast.makeText(getBaseContext(), "Masukkan suhu awal", Toast.LENGTH_SHORT).show();
            awal = 0.0;
        } else {
            awal = Double.parseDouble(inputET.getText().toString());
            if (!TextUtils.isEmpty(input)) {
                if (satuan.equals("0") && tujuan.equals("0")) { //c - c
                    celcius = awal;
                    fahrenheit = (1.8 * awal) + 32;
                    reamur = 0.8 * awal;
                    kelvin = awal + 273;

                    hasilTV.setText(String.valueOf(celcius));
                } else if (satuan.equals("0") && tujuan.equals("1")) { //c - f
                    celcius = awal;
                    fahrenheit = (1.8 * awal) + 32;
                    reamur = 0.8 * awal;
                    kelvin = awal + 273;

                    hasilTV.setText(String.valueOf(fahrenheit));
                } else if (satuan.equals("0") && tujuan.equals("2")) { //c - r
                    celcius = awal;
                    fahrenheit = (1.8 * awal) + 32;
                    reamur = 0.8 * awal;
                    kelvin = awal + 273;

                    hasilTV.setText(String.valueOf(reamur));
                } else if (satuan.equals("0") && tujuan.equals("3")) { //c - k
                    celcius = awal;
                    fahrenheit = (1.8 * awal) + 32;
                    reamur = 0.8 * awal;
                    kelvin = awal + 273;

                    hasilTV.setText(String.valueOf(kelvin));
                } else if (satuan.equals("1") && tujuan.equals("0")) { // f - c
                    celcius = 0.55555 * (awal - 32);
                    reamur = 0.44444 * (awal - 32);
                    fahrenheit = awal;
                    kelvin = celcius + 273;

                    hasilTV.setText(String.valueOf(celcius));
                } else if (satuan.equals("1") && tujuan.equals("1")) { // f - f
                    celcius = 0.55555 * (awal - 32);
                    reamur = 0.44444 * (awal - 32);
                    fahrenheit = awal;
                    kelvin = celcius + 273;

                    hasilTV.setText(String.valueOf(fahrenheit));
                } else if (satuan.equals("1") && tujuan.equals("2")) { // f - r
                    celcius = 0.55555 * (awal - 32);
                    reamur = 0.44444 * (awal - 32);
                    fahrenheit = awal;
                    kelvin = celcius + 273;

                    hasilTV.setText(String.valueOf(reamur));
                } else if (satuan.equals("1") && tujuan.equals("3")) { // f - k
                    celcius = 0.55555 * (awal - 32);
                    reamur = 0.44444 * (awal - 32);
                    fahrenheit = awal;
                    kelvin = celcius + 273;

                    hasilTV.setText(String.valueOf(kelvin));
                } else if (satuan.equals("2") && tujuan.equals("0")) { //r-c
                    celcius = 1.25 * awal;
                    reamur = awal;
                    fahrenheit = (2.25 * awal) + 32;
                    kelvin = celcius + 273;

                    hasilTV.setText(String.valueOf(celcius));
                } else if (satuan.equals("2") && tujuan.equals("1")) { //r-f
                    celcius = 1.25 * awal;
                    reamur = awal;
                    fahrenheit = (2.25 * awal) + 32;
                    kelvin = celcius + 273;


                    hasilTV.setText(String.valueOf(fahrenheit));
                } else if (satuan.equals("2") && tujuan.equals("2")) { //r-r
                    celcius = 1.25 * awal;
                    reamur = awal;
                    fahrenheit = (2.25 * awal) + 32;
                    kelvin = celcius + 273;

                    hasilTV.setText(String.valueOf(reamur));
                } else if (satuan.equals("2") && tujuan.equals("3")) { //r-k
                    celcius = 1.25 * awal;
                    reamur = awal;
                    fahrenheit = (2.25 * awal) + 32;
                    kelvin = celcius + 273;

                    hasilTV.setText(String.valueOf(kelvin));
                } else if (satuan.equals("3") && tujuan.equals("0")) { //k-c
                    celcius = awal - 273;
                    reamur = 0.8 * (awal - 273);
                    fahrenheit = (1.8 * (awal - 273)) + 32;
                    kelvin = awal;

                    hasilTV.setText(String.valueOf(celcius));
                } else if (satuan.equals("3") && tujuan.equals("1")) { //k-f
                    celcius = awal - 273;
                    reamur = 0.8 * (awal - 273);
                    fahrenheit = (1.8 * (awal - 273)) + 32;
                    kelvin = awal;

                    hasilTV.setText(String.valueOf(fahrenheit));
                } else if (satuan.equals("3") && tujuan.equals("2")) { //k-r
                    celcius = awal - 273;
                    reamur = 0.8 * (awal - 273);
                    fahrenheit = (1.8 * (awal - 273)) + 32;
                    kelvin = awal;

                    hasilTV.setText(String.valueOf(reamur));
                } else if (satuan.equals("3") && tujuan.equals("3")) { //k-k
                    celcius = awal - 273;
                    reamur = 0.8 * (awal - 273);
                    fahrenheit = (1.8 * (awal - 273)) + 32;
                    kelvin = awal;

                    hasilTV.setText(String.valueOf(kelvin));
                }
            }
        }
    }

}
