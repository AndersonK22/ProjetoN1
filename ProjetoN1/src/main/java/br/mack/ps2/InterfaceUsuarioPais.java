package br.mack.ps2;

import br.mack.ps2.entidades.*;
import br.mack.ps2.persistencia.*;
import java.util.List;
import java.util.Scanner;

public class InterfaceUsuarioPais {
    PaisDAO dao;
    Scanner in;

    public InterfaceUsuarioPais(PaisDAO dao) {
        this.dao = dao;
        this.in = new Scanner(System.in);
    }

    public void iniciar() {
        imprimirMenu();
    }

    private void imprimirMenu() {
        int opc = 0;
        do {
            System.out.println(" Menu");
            System.out.println("\t1. Create");
            System.out.println("\t2. Read");
            System.out.println("\t3. Update");
            System.out.println("\t4. Delete");
            System.out.println("\t5. sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();

            in.nextLine();

            switch (opc) {
                case 1:
                    this.create();
                    break;
                case 2:
                    this.read();
                    break;
                case 3:
                    this.update();
                    break;
                case 4:
                    this.delete();
                    break;
                case 5:
                    System.out.println("tchau :)");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        }while (opc != 5);
    }

    private void create() {
        Pais pais = new Pais();

        System.out.println(" Novo país");
        System.out.print("\nInforme o Id: ");
        pais.setId(in.nextLong());
        in.nextLine();

        System.out.print("Informe o nome do país: ");
        pais.setNome(in.nextLine());

        System.out.print("Informe o continente: ");
        pais.setContinente(in.nextInt());

        System.out.print("Informe a populaçao: ");
        pais.setPopulacao(in.nextLong());

        if (dao.create(pais)) {
            System.out.println("País adicionado ao banco de Dados");
        } else {
            System.out.println("Problema ao adicionar o país");
        }
    }

    private void read() {
        List<Pais> paises = dao.read();

        System.out.println("Lista de paises cadastrados");
        for(Pais aluno : paises) {
            System.out.println(paises);
        }
    }

    private void update(){
        Pais pais = new Pais();

        System.out.println(" Atualizar um país ");
        System.out.println("Insira o ID do país que deseja alterar: ");
        pais.setId(in.nextLong());
        in.nextLine();

        System.out.println("Altere o nome do país: ");
        pais.setNome(in.nextLine());

        System.out.println("Altere do nome do continente: ");
        pais.setContinente(in.nextInt());

        System.out.println("Altere o numero da populaçao: ");
        pais.setPopulacao(in.nextLong());

        if(dao.update(pais)){
            System.out.println("populaçao atualizado no Banco de Dados");
        } else{
            System.out.println("Problema ao adicionar país");
        }
    }

    private void delete() {
        List<Pais> paises = dao.read();

        while (true) {
            System.out.println(" Lista de paises cadastrados ");
            int i = 0;
            for (Pais pais : paises) {
                System.out.println(i + " - " + pais);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual país deseja remover? ");
            int opc = in.nextInt();
            in.nextLine();

            if (opc==i) {
                break;
            }

            if (opc >= paises.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (dao.delete(paises.get(opc))) {
                    System.out.println("País " + paises.get(opc).getNome() +
                            " removido com sucesso");
                } else {
                    System.out.println("Falha ao tentar remover");
                }
                break;
            }
        }
    }
}
