package com.example.appmantenimiento;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etId, etNombre, etCargo, etCelular, etDni, etSalario;
    private Button btnGuardar;
    private RecyclerView rvEmpleados;

    private List<Empleado> listaEmpleados;
    private EmpleadoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar vistas
        etId = findViewById(R.id.etId);
        etNombre = findViewById(R.id.etNombre);
        etCargo = findViewById(R.id.etCargo);
        etCelular = findViewById(R.id.etCelular);  // ← NUEVO
        etDni = findViewById(R.id.etDni);          // ← NUEVO
        etSalario = findViewById(R.id.etSalario);
        btnGuardar = findViewById(R.id.btnGuardar);
        rvEmpleados = findViewById(R.id.rvEmpleados);

        // Configurar RecyclerView
        listaEmpleados = new ArrayList<>();
        adapter = new EmpleadoAdapter(listaEmpleados);
        rvEmpleados.setLayoutManager(new LinearLayoutManager(this));
        rvEmpleados.setAdapter(adapter);

        // Evento del botón Guardar
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarEmpleado();
            }
        });
    }

    private void guardarEmpleado() {
        String id = etId.getText().toString().trim();
        String nombre = etNombre.getText().toString().trim();
        String cargo = etCargo.getText().toString().trim();
        String celular = etCelular.getText().toString().trim();  // ← NUEVO
        String dni = etDni.getText().toString().trim();          // ← NUEVO
        String salarioStr = etSalario.getText().toString().trim();

        // Validar campos vacíos
        if (id.isEmpty() || nombre.isEmpty() || cargo.isEmpty() ||
                celular.isEmpty() || dni.isEmpty() || salarioStr.isEmpty()) {
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convertir salario a número
        double salario = Double.parseDouble(salarioStr);

        // Crear nuevo empleado (CON CELULAR Y DNI)
        Empleado nuevoEmpleado = new Empleado(id, nombre, cargo, salario, celular, dni);
        listaEmpleados.add(nuevoEmpleado);
        adapter.notifyDataSetChanged();

        // Limpiar campos
        etId.setText("");
        etNombre.setText("");
        etCargo.setText("");
        etCelular.setText("");  // ← NUEVO
        etDni.setText("");      // ← NUEVO
        etSalario.setText("");

        Toast.makeText(this, "Empleado registrado con éxito", Toast.LENGTH_SHORT).show();
    }
}