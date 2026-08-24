package com.example.appmantenimiento;

public class Empleado {
    private String id;
    private String nombre;
    private String cargo;
    private double salario;
    private String celular;  // ← NUEVO
    private String dni;      // ← NUEVO

    // Constructor ACTUALIZADO
    public Empleado(String id, String nombre, String cargo, double salario, String celular, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.celular = celular;
        this.dni = dni;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // ← NUEVOS GETTERS Y SETTERS
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}