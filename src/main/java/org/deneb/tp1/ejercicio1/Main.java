package org.deneb.tp1.ejercicio1;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Departamento gerencia = new Departamento(123, "gerencia");
        Departamento produccion= new Departamento(111, "produccion");
        Departamento ventas= new Departamento(333, "ventas");

        Empleado PeterCapusoto = new Empleado(null,"Peter",1312, gerencia);
        Empleado Rivas = new Empleado(PeterCapusoto,"Rivas",1234, gerencia);

        Empleado GordoDan = new Empleado(null,"ElGordoDan",1911,produccion);
        Empleado Alexander = new Empleado(GordoDan,"Emperador",9999, produccion);

        Empleado ElViejo = new Empleado(null, "Viejo", 0000, ventas);
        Empleado Alejo = new Empleado(ElViejo, "Alejo",1111,ventas);


        List<Empleado> empleados = Arrays.asList(PeterCapusoto, Rivas, GordoDan, Alexander, ElViejo, Alejo);
        List<Departamento> departamentos = Arrays.asList(gerencia, produccion, ventas);

        System.out.println(cantidadEmpleadosDepartamento(empleados, gerencia));
        System.out.println(cantidadEmpleadosDepartamento(empleados, produccion));
        System.out.println(cantidadEmpleadosDepartamento(empleados, ventas));
        cantidadPorDepa(empleados,departamentos);

        System.out.println(getjerarquia(Alejo));
        System.out.println(getSupervisor(Alexander).getName());
    }
    private static int cantidadEmpleadosDepartamento(List<Empleado> empleados, Departamento departamentos){
        int i = 0;
        for (Empleado e : empleados){
            if (e.getDepartamento().equals(departamentos)){
                i++;
            }
        }
        return i;
    }

    private static void cantidadPorDepa(List<Empleado> empleados, List<Departamento> departamentos){
        int[] numEmpleados = new int[departamentos.size()];

        for (Empleado empleado : empleados) {
            for (int i = 0; i < departamentos.size(); i++) {
                if (empleado.getDepartamento().equals(departamentos.get(i))) {
                    numEmpleados[i]++;
                    break;
                }
            }
        }
        StringBuilder string = new StringBuilder();
        string.append("/n La cantidad de empleados por departamento es de ");
      int aux = 0;
        for(Departamento depa : departamentos){
            string.append("/n ").append(depa.getNombre()).append(": ").append(numEmpleados[aux]);
            aux++;
        }
        System.out.println(string);

    }

    private static Empleado getSupervisor(Empleado e){
        return e.getSupervisor();
    }

    private static List<Empleado> getjerarquia(Empleado e){
        List<Empleado> jerarquia = new ArrayList<>();
        Empleado actual = e.getSupervisor();
        while (actual != null) {
            jerarquia.add(actual);
            actual = actual.getSupervisor();
        }
        return jerarquia;
    }
    private List<Empleado> aCargo(List<Empleado> e, Empleado supervisor){
        List<Empleado> cargo = new ArrayList<>();
        for (Empleado empleado : e){
            if (empleado.getSupervisor().equals(supervisor)){
                cargo.add(empleado);
            }
        }
        return cargo;
    }

    private List<Empleado> aCargoTotal(List<Empleado> e, Empleado supervisor) {
        List<Empleado> cargo = new ArrayList<>();

        for (Empleado empleado : e) {
            List<Empleado> jerarquia = getjerarquia(empleado);
            if (jerarquia.contains(supervisor)) {
                for (Empleado sub : jerarquia) {
                    if (!cargo.contains(sub) && !sub.equals(supervisor)) {
                        cargo.add(sub);
                    }
                }
            }
        }
        return cargo;
    }
}
