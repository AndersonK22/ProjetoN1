package br.mack.ps2;

import br.mack.ps2.persistencia.PaisDAOMySQL;
import br.mack.ps2.persistencia.CarroDAOMySQL;


import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {


        Scanner print = new Scanner(System.in);
        int escolha;
        int escolha2;

        System.out.println("**** Menu ****");
        System.out.println("Deseja modificar algum banco de dados?");
        System.out.println("Digite 1 para sim ou 2 para não:");
        escolha = print.nextInt();
        if (escolha == 1) {
            System.out.println("Qual banco você deseja alterar?\nLembre-se de sempre digitar o numero que está ao lado da opção desejada.");
            System.out.println("1. Aplicativo\n2. Conta Bancaria\n3. Empregado");
            escolha2 = print.nextInt();
            if (escolha2 == 1) {
                CarroDAOMySQL carroDAO = new CarroDAOMySQL();
                InterfaceUsuarioCarro carro = new InterfaceUsuarioCarro(carroDAO);
                carro.iniciar();
            } else if (escolha2 == 2) {
                PaisDAOMySQL paisDAO = new PaisDAOMySQL();
                InterfaceUsuarioPais pais = new InterfaceUsuarioPais(paisDAO);
                pais.iniciar();
            } else {
                throw new InputMismatchException();
            }
        } else if (escolha == 2) {
            System.out.println("Você saiu do programa!");
            System.out.println("Se quiser retornar ao programa, por favor de start novamente :) ");
            return;
        } else {
            throw new InputMismatchException();
        }

    }
}