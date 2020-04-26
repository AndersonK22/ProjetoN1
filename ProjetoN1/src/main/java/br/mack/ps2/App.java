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

        System.out.println("Deseja modificar algum banco de dados?");
        System.out.println("Digite\n 1 - Iniciar\n 2- Finalizar ");
        escolha = print.nextInt();

        if (escolha == 1) {
            System.out.println("Insira o número de qual banco de dados deseja alterar.");
            System.out.println("1. Carro\n2. País");
            escolha2 = print.nextInt();

            if (escolha2 == 1) {
                CarroDAOMySQL carroDAO = new CarroDAOMySQL();
                InterfaceUsuarioCarro carro = new InterfaceUsuarioCarro(carroDAO);
                carro.iniciar();
            }
            else if (escolha2 == 2) {
                PaisDAOMySQL paisDAO = new PaisDAOMySQL();
                InterfaceUsuarioPais pais = new InterfaceUsuarioPais(paisDAO);
                pais.iniciar();
            }
            else {
                throw new InputMismatchException();
            }
        }
        else if (escolha == 2) {
            System.out.println("Programa Finalizado");
            return;
        }
        else {
            throw new InputMismatchException();
        }

    }
}