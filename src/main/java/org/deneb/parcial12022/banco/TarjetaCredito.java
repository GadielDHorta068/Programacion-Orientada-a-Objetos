package org.deneb.parcial12022.banco;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class TarjetaCredito extends Tarjeta{
    private double limite;
    private List<Moviemiento> movimientos;

    public TarjetaCredito(int nroTarjeta, LocalDate validaDesde, LocalDate validoHasta, Boolean bloqueada, Titular titular, CajaAhorro cajaAhorro, List<Moviemiento> movimientos, double limite) {
        super(nroTarjeta, validaDesde, validoHasta, bloqueada, titular, cajaAhorro);
        this.movimientos = movimientos;
        this.limite = limite;
    }

    @Override
    public void realizarPago(LocalDate fecha, String detalle, double importe) throws SaldoInsuficienteException {
        double porPagar = 0;
        for (Moviemiento m : movimientos){
            porPagar += m.getImporte();
        }
        if(porPagar + importe > limite){
            throw new SaldoInsuficienteException("Limite de tarjeta insuficiente");
        }
        movimientos.add(new Moviemiento(fecha,detalle,importe));
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public List<Moviemiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Moviemiento> movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public String toString() {
        return STR."TarjetaCredito{limite=\{limite}, movimientos=\{movimientos}\{'}'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TarjetaCredito that = (TarjetaCredito) o;
        return Double.compare(limite, that.limite) == 0 && Objects.equals(movimientos, that.movimientos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(limite, movimientos);
    }
}
