package org.deneb.parcial12022.banco;

import java.time.LocalDate;

public class TarjetaDebito extends Tarjeta{
    public TarjetaDebito(int nroTarjeta, LocalDate validaDesde, LocalDate validoHasta, Boolean bloqueada, Titular titular, CajaAhorro cajaAhorro) {
        super(nroTarjeta, validaDesde, validoHasta, bloqueada, titular, cajaAhorro);
    }

    @Override
    public void realizarPago(LocalDate fecha, String detalle, double importe) throws SaldoInsuficienteException {
        if (importe > getCajaAhorro().getSaldo()){
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        getCajaAhorro().setSaldo((getCajaAhorro().getSaldo() - importe));
    }
}
