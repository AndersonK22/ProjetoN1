package br.mack.ps2;
import br.mack.ps2.persistencia.PaisDAOMySQL;
import br.mack.ps2.persistencia.CarroDAOMySQL;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);
        int escolha;
        do{
        System.out.println("Deseja modificar algum banco de dados?");
        System.out.println("Digite\n 1-Carro\n 2-País\n 3-Finalizar ");
        escolha = print.nextInt();

        switch (escolha) {
            case 1:
                CarroDAOMySQL carroDAO = new CarroDAOMySQL();
                InterfaceUsuarioCarro carro = new InterfaceUsuarioCarro(carroDAO);
                carro.iniciar();
                break;
            case 2:
                PaisDAOMySQL paisDAO = new PaisDAOMySQL();
                InterfaceUsuarioPais pais = new InterfaceUsuarioPais(paisDAO);
                pais.iniciar();
                break;
            case 3:
                System.out.println("Programa Finalizado");
                break;
            default:
                System.out.println("Opção Inválida");
                break;
        }
            }while (escolha != 3);
    }

    }
