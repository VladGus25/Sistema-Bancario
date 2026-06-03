package com.mycompany.sistemabancario;

public class ContaPoupanca extends ContaBancaria
        implements Tributavel, Bloqueavel {

    private double taxaRendimento;

    public ContaPoupanca(String numero,
                         String titular,
                         double saldo,
                         double taxaRendimento) {

        super(numero, titular, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public double calcularRendimento() {
        return saldo * taxaRendimento;
    }

    @Override
    public double calcularImposto() {
        return calcularRendimento() * 0.225;
    }

    @Override
    public void bloquear() {
        ativa = false;
    }

    @Override
    public void desbloquear() {
        ativa = true;
    }

    @Override
    public boolean isAtiva() {
        return ativa;
    }
}