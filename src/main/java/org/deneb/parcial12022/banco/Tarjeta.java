package org.deneb.parcial12022.banco;


import java.time.LocalDate;
import java.util.Objects;

public abstract class Tarjeta implements OperacionBanco {
    private int nroTarjeta;
    private LocalDate validaDesde;
    private LocalDate validoHasta;
    private Boolean bloqueada;
    private Titular titular;
    private CajaAhorro cajaAhorro;

    public Tarjeta(int nroTarjeta, LocalDate validaDesde, LocalDate validoHasta, Boolean bloqueada, Titular titular, CajaAhorro cajaAhorro) {
        this.nroTarjeta = nroTarjeta;
        this.validaDesde = validaDesde;
        this.validoHasta = validoHasta;
        this.bloqueada = bloqueada;
        this.titular = titular;
        this.cajaAhorro = cajaAhorro;
    }

    public void verificarTarjeta() throws TarjetaInvalidaException {
        if (bloqueada){
            throw new TarjetaInvalidaException();
        }
        if ((LocalDate.now().isAfter(validaDesde)) && LocalDate.now().isBefore(validoHasta)){
            throw new TarjetaInvalidaException();
        }
    }

    @Override
    public double obtenerSaldo() {
        return 0;
    }

    public abstract void realizarPago(LocalDate fecha, String detalle, double importe) throws SaldoInsuficienteException;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarjeta tarjeta = (Tarjeta) o;
        return nroTarjeta == tarjeta.nroTarjeta && Objects.equals(validaDesde, tarjeta.validaDesde) && Objects.equals(validoHasta, tarjeta.validoHasta) && Objects.equals(bloqueada, tarjeta.bloqueada) && Objects.equals(titular, tarjeta.titular) && Objects.equals(cajaAhorro, tarjeta.cajaAhorro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nroTarjeta, validaDesde, validoHasta, bloqueada, titular, cajaAhorro);
    }

    public int getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(int nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public LocalDate getValidaDesde() {
        return validaDesde;
    }

    public void setValidaDesde(LocalDate validaDesde) {
        this.validaDesde = validaDesde;
    }

    public LocalDate getValidoHasta() {
        return validoHasta;
    }

    public void setValidoHasta(LocalDate validoHasta) {
        this.validoHasta = validoHasta;
    }

    public Boolean getBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(Boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public CajaAhorro getCajaAhorro() {
        return cajaAhorro;
    }

    public void setCajaAhorro(CajaAhorro cajaAhorro) {
        this.cajaAhorro = cajaAhorro;
    }

    @Override
    public String toString() {
        return STR."Tarjeta{nroTarjeta=\{nroTarjeta}, validaDesde=\{validaDesde}, validoHasta=\{validoHasta}, bloqueada=\{bloqueada}, titular=\{titular}, cajaAhorro=\{cajaAhorro}\{'}'}";
    }
}
