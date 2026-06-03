package com.mycompany.sistemabancario;

public abstract class ContaBancaria {

    protected String numero;
    protected String titular;
    protected double saldo;
    protected boolean ativa = true;

    public ContaBancaria(String numero, String titular, double saldo) {

        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("Titular inválido");
        }

        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double valor)
            throws OperacaoInvalidaException {

        if (!ativa) {
            throw new OperacaoInvalidaException("Conta bloqueada");
        }

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        saldo += valor;
    }

    public void sacar(double valor)
            throws OperacaoInvalidaException {

        if (!ativa) {
            throw new OperacaoInvalidaException("Conta bloqueada");
        }

        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        saldo -= valor;
    }

    public abstract double calcularRendimento();

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}