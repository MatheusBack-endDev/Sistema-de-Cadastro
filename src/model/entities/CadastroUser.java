package model.entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroUser {

    int contador = 4;
    File path = new File("\\Sistema de Cadastro\\formulario.txt");
    private List<User> userList = new ArrayList<>();

    public void pastas(String caminhoDoArquivo) {

        File path = new File(caminhoDoArquivo);
        //C:\Sistema de Cadastro\formulario.txt
        Scanner sc = new Scanner(System.in);

        List<String> perguntas = new ArrayList<>();
        List<String> respostas = new ArrayList<>();
        String nome = "";
        String email = "";
        int idade = 0;
        double altura = 0.0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                perguntas.add(line);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        for (String pergunta : perguntas) {
            System.out.println(pergunta); // Exibe a pergunta para o usuário

            if (pergunta.toLowerCase().contains("nome")) {
                nome = sc.nextLine();
                respostas.add(pergunta + " " + nome);
            } else if (pergunta.toLowerCase().contains("email")) {
                boolean emailCadastrado = false;


                while (true) {
                    email = sc.nextLine();

                    String finalEmail = email;
                    emailCadastrado = userList.stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(finalEmail));

                    if (emailCadastrado) {
                        System.out.println("Este e-mail já está cadastrado! Tente novamente.");
                    } else {

                        respostas.add(pergunta + " " + email);
                        break;
                    }
                }
            } else if (pergunta.toLowerCase().contains("idade")) {
                idade = sc.nextInt();
                respostas.add(pergunta + " " + idade);
                sc.nextLine();
            } else if (pergunta.toLowerCase().contains("altura")) {
                altura = sc.nextDouble();
                respostas.add(pergunta + " " + altura);
                sc.nextLine();
            }
        }

        File newPath = new File("C:\\Sistema de Cadastro\\" + nome.replace(" ", "").toUpperCase() + ".TXT");
        User user = new User(nome, email, idade, altura);
        userList.add(user);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newPath, false))) {
            for (String respota : respostas) {
                bw.write(respota);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void addPergunta(String caminho, String pergunta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) {
            File arquivo = new File(caminho);
            if (arquivo.length() > 0) {
                bw.newLine(); // Apenas adiciona uma nova linha se o arquivo já tem conteúdo
            }
            contador++;
            bw.write(contador + " - " + pergunta);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delPergunta(String numberPergunta) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            ArrayList<String> perg = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                if (!line.trim().isEmpty() && !line.contains(numberPergunta)) {
                    perg.add(line);
                }
                line = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path));) {
                for (int i = 0; i < perg.size(); i++) {
                    bw.write(perg.get(i));
                    if (i < perg.size() - 1)
                        bw.newLine();
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
