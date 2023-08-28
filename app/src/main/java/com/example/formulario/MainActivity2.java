package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
        private Button prints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        prints = findViewById(R.id.volver_text);
        TextView textAlumno = findViewById(R.id.text_alumno);
        TextView textEscuela = findViewById(R.id.text_escuela);
        TextView textCarrera = findViewById(R.id.text_carrera);
        TextView textCarnetBiblioteca = findViewById(R.id.text_carnet_biblioteca);
        TextView textCarnetPasaje = findViewById(R.id.text_carnet_pasaje);
        TextView textRadioSeleccionado = findViewById(R.id.text_radio_seleccionado);
        TextView textPension = findViewById(R.id.text_pension);
        TextView textAdicionales = findViewById(R.id.text_adicionales);
        TextView textCostoCarrera = findViewById(R.id.text_costo_carrera);
        TextView textTotalPagar = findViewById(R.id.text_total_pagar);

        Intent intent = getIntent();

        String alumno = intent.getStringExtra("alumno");
        String escuela = intent.getStringExtra("escuela");
        String carrera = intent.getStringExtra("carrera");
        boolean carnetBiblioteca = intent.getBooleanExtra("carnetBiblioteca", false);
        boolean carnetPasaje = intent.getBooleanExtra("carnetPasaje", false);
        String radioSeleccionado = intent.getStringExtra("radioSeleccionado");
        int pension1 = intent.getIntExtra("pension1", 0);
        int adicionales1 = intent.getIntExtra("adicionales1", 0);
        //double costoCarrera = intent.getDoubleExtra("costoCarrera", 0.0); // Obtén el valor del costo de carrera
        double totalAPagar = intent.getDoubleExtra("totalAPagar", 0.0);
        String selectedSpinnerValue = intent.getStringExtra("selectedSpinnerValue"); // Obtener el valor del Spinner
        double costoCarreraCalculado = totalAPagar - (pension1 + adicionales1);
       // costoCarreraCalculado /= (25 * Integer.parseInt(radioSeleccionado)); // Deshaz el cálculo del radio

        textAlumno.setText("Alumno: " + alumno);
        textEscuela.setText("Escuela: " + escuela);
        textCarrera.setText("Carrera: " + carrera);
        textCarnetBiblioteca.setText("Carnet de Biblioteca: " + (carnetBiblioteca ? "Sí" : "No"));
        textCarnetPasaje.setText("Carnet de Pasaje: " + (carnetPasaje ? "Sí" : "No"));
        textRadioSeleccionado.setText("Gastos Adicionales: " + radioSeleccionado);

        textPension.setText("Pensión: " + pension1);
        textAdicionales.setText("Adicionales: " + adicionales1);
        textCostoCarrera.setText("Costo de Carrera: " + selectedSpinnerValue); // Mostrar el valor del Spinner // Mostrar el costo de carrera calculado
        textTotalPagar.setText("Total a Pagar: " + totalAPagar);

        prints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);

            }
        });



    }
}
