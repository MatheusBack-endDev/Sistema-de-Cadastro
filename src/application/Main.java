package application;

import model.entities.CadastroUser;
import model.entities.User;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CadastroUser program = new CadastroUser();
        Scanner sc = new Scanner(System.in);
        User user = new User();


        System.out.println("1 - Cadastrar o usuário");
        System.out.println("2 - Listar todos usuários cadastrados");
        System.out.println("3 - Cadastrar nova pergunta no formulário");
        System.out.println("4 - Deletar pergunta do formulário");
        System.out.println("5 - Pesquisar usuário por nome ou idade ou email");
        System.out.println("6 - Sair");


        System.out.print("escolha: ");
        int number = sc.nextInt();
        sc.nextLine();
        while (number != 6) {
            int contador = 1;

            switch (number) {
                case 1:
                    program.pastas("C:\\Sistema de Cadastro\\formulario.txt");
                    break;
                case 2:
                    for (User users : user.getUserList()){
                        System.out.println(contador + " - " + users.getName());
                        contador++;
                    }
                    break;
                case 3:
                    System.out.print("digite o caminho do formulario: ");
                    String caminho = sc.nextLine();
                    System.out.print("digite a pergunta: ");
                    String pergunta = sc.nextLine();
                    program.addPergunta(caminho, pergunta);
                    break;
                case 4:
                    System.out.print("digite o numero da pergunta: ");
                    int numberPergunta = sc.nextInt();
                    sc.nextLine();
                    program.delPergunta("5");
                    break;
                case 5:
                    System.out.print("digite o nome do usuario: ");
                    String nameUser = sc.nextLine();
                    user.buscaUsers(nameUser);
                case 6:
                    break;
            }

            System.out.println("1 - Cadastrar o usuário");
            System.out.println("2 - Listar todos usuários cadastrados");
            System.out.println("3 - Cadastrar nova pergunta no formulário");
            System.out.println("4 - Deletar pergunta do formulário");
            System.out.println("5 - Pesquisar usuário por nome ou idade ou email");
            System.out.println("6 - Sair");
            number = sc.nextInt();
            sc.nextLine();
        }

    }
}