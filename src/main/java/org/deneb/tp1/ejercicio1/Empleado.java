package org.deneb.tp1.ejercicio1;

public class Empleado {
    private int legajo;
    private String name;
    private Empleado supervisor;
    private Departamento departamento;

    public Empleado(Empleado supervisor, String name, int legajo, Departamento departamento) {
        this.supervisor = supervisor;
        this.name = name;
        this.legajo = legajo;
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Empleado getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Empleado supervisor) {
        this.supervisor = supervisor;
    }
}
