package org.deneb.parcial12022.banco;

public class SaldoInsuficienteException extends Throwable{
    public SaldoInsuficienteException(String limiteDeTarjetaInsuficiente) {
        System.out.println("Saldo insuficiente");
    }
}
