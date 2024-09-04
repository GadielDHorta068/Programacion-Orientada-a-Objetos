package org.deneb.parcial12022.banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CajaAhorro implements OperacionBanco {
    private int nroCuenta;
    private double saldo;
    private List<Titular> titulares;

    public CajaAhorro(int nroCuenta, double saldo) {
        this.nroCuenta = nroCuenta;
        this.saldo = saldo;
        titulares = new ArrayList<>();
    }

    public void agregarTitular(Titular titular){
        titulares.add(titular);
    }

    @Override
    public double obtenerSaldo() {
        return 0;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Titular> getTitulares() {
        return titulares;
    }

    public void setTitulares(List<Titular> titulares) {
        this.titulares = titulares;
    }

    @Override
    public String toString() {
        return STR."CajaAhorro{nroCuenta=\{nroCuenta}, saldo=\{saldo}, titulares=\{titulares}\{'}'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CajaAhorro that = (CajaAhorro) o;
        return nroCuenta == that.nroCuenta && Double.compare(saldo, that.saldo) == 0 && Objects.equals(titulares, that.titulares);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nroCuenta, saldo, titulares);
    }
}
