package com.example.formulario;
import com.example.formulario.data;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ImageButton imageButton;
    private NavigationView navigationView;
    private EditText input;
    private EditText input2;
    private AutoCompleteTextView input3;
    private CheckBox checks1;
    private CheckBox checks2;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private EditText input4;
    private EditText input5;
    private TextView totalText;
    private Button prints;
    private Button calculate;
    private Spinner spinnerOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int radioButtonId = radioGroup.getCheckedRadioButtonId();

        drawerLayout = findViewById(R.id.drawer_layout);

        spinnerOptions = findViewById(R.id.spinner_options);

        input = findViewById(R.id.Alumno);
        input2 = findViewById(R.id.Escuela);
        input3 = findViewById(R.id.Carrera);

        checks1 = findViewById(R.id.CarnetBiblioteca);
        checks2 = findViewById(R.id.CarnetPasaje);

        radio1 = findViewById(R.id.Radio1);
        radio2 = findViewById(R.id.Radio2);
        radio3 = findViewById(R.id.Radio3);

        input4 = findViewById(R.id.Pension1);
        input5 = findViewById(R.id.Adicionles1);
        totalText = findViewById(R.id.total_pagar);

        calculate = findViewById(R.id.Calcular);
        prints = findViewById(R.id.Imprimir);

        input.setText(data.getName());
        input2.setText(data.getSchool());

        input2.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String schoolName = charSequence.toString().toLowerCase();
                String career = data.getCareerForSchool(schoolName);
                if (career != null) {
                    input3.setText(career);
                } else {
                    input3.setText(""); // Limpiar input3 si no se encuentra la escuela
                }
            }

            public void afterTextChanged(Editable editable) {
            }
        });


        String[] allCareers = data.getAllCareers();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, allCareers);
        AutoCompleteAdapter autoCompleteAdapter = new AutoCompleteAdapter(this, allCareers);
        input3.setAdapter(autoCompleteAdapter);


        input3.setAdapter(adapter);


        String[] options = {"3000", "8000", "10000"};

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, options);
        spinnerOptions.setAdapter(adapter);
        spinnerOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedOption = options[i];
                int selectedInteger = Integer.parseInt(selectedOption); // Parseamos la cadena a entero
                // Ahora puedes usar selectedInteger en lugar de selectedOption para trabajar con números enteros
                // selectedResultTextView.setText("Resultado seleccionado: " + selectedOption);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });








        prints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TP1();
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logicamatematica();

            }
        });


    }

    public void logicamatematica() {
        int totalCheckBoxes = 0;
        if (checks1.isChecked()) {
            totalCheckBoxes += 25;
        }
        if (checks2.isChecked()) {
            totalCheckBoxes += 22;
        }
        int radioButtonValue = 0;
        if (radio1.isChecked()) {
            radioButtonValue = 4;
        } else if (radio2.isChecked()) {
            radioButtonValue = 5;
        } else if (radio3.isChecked()) {
            radioButtonValue = 6;
        }
        int resultAfterRadio = totalCheckBoxes * radioButtonValue;
        int spinnerSelectedValue = Integer.parseInt(spinnerOptions.getSelectedItem().toString());

        int finalResult = resultAfterRadio + spinnerSelectedValue;
        int input4Value = Integer.parseInt(input4.getText().toString());
        int input5Value = Integer.parseInt(input5.getText().toString());
        finalResult += input4Value + input5Value;


        double discount = 0.12;
        double discountedResult = finalResult * (1 - discount);
        totalText.setText(String.valueOf(discountedResult));


        String discountComment = "12% de descuento : S/. " + (finalResult - discountedResult);
        totalText.setText(String.format("%.2f\n%s", discountedResult, discountComment));


    }

    public void TP1() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        // Obtén los valores de los elementos y otras variables necesarias
        String alumno = input.getText().toString();
        String escuela = input2.getText().toString();
        String carrera = input3.getText().toString();
        boolean carnetBiblioteca = checks1.isChecked();
        boolean carnetPasaje = checks2.isChecked();
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        String radioSeleccionado = "";

        if (radioButtonId == R.id.Radio1) {
            radioSeleccionado = "4";
        } else if (radioButtonId == R.id.Radio2) {
            radioSeleccionado = "5";
        } else if (radioButtonId == R.id.Radio3) {
            radioSeleccionado = "6";
        }

        int pension1 = Integer.parseInt(input4.getText().toString());
        int adicionales1 = Integer.parseInt(input5.getText().toString());
        String selectedSpinnerValue = spinnerOptions.getSelectedItem().toString();

        // Calcular el total a pagar
        int totalCheckBoxes = 0;
        if (checks1.isChecked()) {
            totalCheckBoxes += 25;
        }
        if (checks2.isChecked()) {
            totalCheckBoxes += 22;
        }
        int radioButtonValue = 0;
        if (radio1.isChecked()) {
            radioButtonValue = 4;
        } else if (radio2.isChecked()) {
            radioButtonValue = 5;
        } else if (radio3.isChecked()) {
            radioButtonValue = 6;
        }
        int resultAfterRadio = totalCheckBoxes * radioButtonValue;
        int spinnerSelectedValue = Integer.parseInt(selectedSpinnerValue);
        int finalResult = resultAfterRadio + spinnerSelectedValue + pension1 + adicionales1;
        double discount = 0.12; // 12% discount
        double discountedResult = finalResult * (1 - discount);




        // Agrega los valores como extras al intent
        intent.putExtra("alumno", alumno);
        intent.putExtra("escuela", escuela);
        intent.putExtra("carrera", carrera);
        intent.putExtra("carnetBiblioteca", carnetBiblioteca);
        intent.putExtra("carnetPasaje", carnetPasaje);
        intent.putExtra("radioSeleccionado", radioSeleccionado);
        intent.putExtra("pension1", pension1);
        intent.putExtra("adicionales1", adicionales1);
        intent.putExtra("selectedSpinnerValue", selectedSpinnerValue);
        intent.putExtra("costoCarrera", selectedSpinnerValue);
        intent.putExtra("totalAPagar", discountedResult); // Agregar el total a pagar

        startActivity(intent);
    }



}