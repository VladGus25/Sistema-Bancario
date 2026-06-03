package com.mycompany.sistemabancario;

public class ContaSalario extends ContaBancaria
        implements Bloqueavel {

    private boolean saqueRealizado = false;

    public ContaSalario(String numero,
                        String titular,
                        double saldo) {

        super(numero, titular, saldo);
    }

    @Override
    public double calcularRendimento() {
        return 0;
    }

    @Override
    public void sacar(double valor)
            throws OperacaoInvalidaException {

        if (saqueRealizado) {
            throw new RuntimeException(
                    "Apenas um saque por mês");
        }

        super.sacar(valor);
        saqueRealizado = true;
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