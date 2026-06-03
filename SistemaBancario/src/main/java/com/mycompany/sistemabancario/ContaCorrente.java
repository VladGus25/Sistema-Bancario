package com.mycompany.sistemabancario;

public class ContaCorrente extends ContaBancaria
        implements Tributavel, Bloqueavel {

    private double limiteEspecial;

    public ContaCorrente(String numero,
                         String titular,
                         double saldo,
                         double limiteEspecial) {

        super(numero, titular, saldo);
        this.limiteEspecial = limiteEspecial;
    }

    @Override
    public double calcularRendimento() {
        return 0;
    }

    @Override
    public double calcularImposto() {
        return saldo * 0.0038;
    }

    @Override
    public void sacar(double valor)
            throws OperacaoInvalidaException {

        if (!ativa) {
            throw new OperacaoInvalidaException("Conta bloqueada");
        }

        if (valor > saldo + limiteEspecial) {
            throw new SaldoInsuficienteException(
                    "Limite excedido");
        }

        saldo -= valor;
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