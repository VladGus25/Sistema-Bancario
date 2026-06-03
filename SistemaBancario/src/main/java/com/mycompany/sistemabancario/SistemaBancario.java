package com.mycompany.sistemabancario;

import java.util.ArrayList;
import java.util.List;

public class SistemaBancario {

    public static void main(String[] args) {

        try {

            ContaCorrente cc =
                    new ContaCorrente(
                            "001",
                            "João",
                            2000,
                            1000);

            ContaPoupanca cp =
                    new ContaPoupanca(
                            "002",
                            "Maria",
                            3000,
                            0.005);

            ContaSalario cs =
                    new ContaSalario(
                            "003",
                            "Pedro",
                            1500);

            List<ContaBancaria> contas =
                    new ArrayList<>();

            contas.add(cc);
            contas.add(cp);
            contas.add(cs);

            System.out.println("=== RENDIMENTO DAS CONTAS ===");

            for (ContaBancaria conta : contas) {

                System.out.println(
                        conta.getTitular()
                        + " -> rendimento: R$ "
                        + conta.calcularRendimento());
            }

            System.out.println("\n=== TESTE DE SAQUE ===");

            cc.sacar(5000);

        } catch (SaldoInsuficienteException e) {

            System.out.println(
                    "Erro: " + e.getMessage());
        } catch (OperacaoInvalidaException e) {

            System.out.println(
                    "Erro: " + e.getMessage());
        }

        try {

            ContaCorrente conta =
                    new ContaCorrente(
                            "004",
                            "Carlos",
                            1000,
                            1000);

            conta.bloquear();

            conta.depositar(500);

        } catch (OperacaoInvalidaException e) {

            System.out.println(
                    "Erro: " + e.getMessage());
        }
    }
}