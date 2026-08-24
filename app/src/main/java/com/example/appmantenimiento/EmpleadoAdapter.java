package com.example.appmantenimiento;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class EmpleadoAdapter extends RecyclerView.Adapter<EmpleadoAdapter.EmpleadoViewHolder> {

    private List<Empleado> listaEmpleados;

    public EmpleadoAdapter(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    @NonNull
    @Override
    public EmpleadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_empleado, parent, false);
        return new EmpleadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpleadoViewHolder holder, int position) {
        Empleado empleado = listaEmpleados.get(position);

        holder.tvNombre.setText(empleado.getNombre() + " (ID: " + empleado.getId() + ")");
        holder.tvCargo.setText(empleado.getCargo());

        // Mostrar Celular y DNI
        String infoExtra = "📱 " + empleado.getCelular() + " | DNI: " + empleado.getDni();
        holder.tvInfoExtra.setText(infoExtra);

        // Formatear salario como moneda
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("es", "CR"));
        holder.tvSalario.setText(formatter.format(empleado.getSalario()));
    }

    @Override
    public int getItemCount() {
        return listaEmpleados.size();
    }

    public static class EmpleadoViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvCargo, tvInfoExtra, tvSalario;

        public EmpleadoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombreItem);
            tvCargo = itemView.findViewById(R.id.tvCargoItem);
            tvInfoExtra = itemView.findViewById(R.id.tvInfoExtra);
            tvSalario = itemView.findViewById(R.id.tvSalarioItem);
        }
    }
}