package app;

import java.util.List;
import java.util.Scanner;

import dao.UsuarioDAO;
import model.Usuario;

public class Aplicacao {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        int opcao = 0;

        while (opcao != 5) {

            System.out.println("\n==== MENU ====");
            System.out.println("1 - Listar usuários");
            System.out.println("2 - Inserir usuário");
            System.out.println("3 - Atualizar usuário");
            System.out.println("4 - Excluir usuário");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\nLista de usuários:");
                    List<Usuario> usuarios = usuarioDAO.get();
                    for (Usuario u : usuarios) {
                        System.out.println(u);
                    }
                    break;

                case 2:
                    System.out.print("Código: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Login: ");
                    String login = sc.nextLine();

                    System.out.print("Senha: ");
                    String senha = sc.nextLine();

                    System.out.print("Sexo (M/F): ");
                    char sexo = sc.next().charAt(0);

                    Usuario novo = new Usuario(codigo, login, senha, sexo);

                    if (usuarioDAO.insert(novo)) {
                        System.out.println("Usuário inserido com sucesso!");
                    }
                    break;

                case 3:
                    System.out.print("Código do usuário para atualizar: ");
                    int codUpdate = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo login: ");
                    String novoLogin = sc.nextLine();

                    System.out.print("Nova senha: ");
                    String novaSenha = sc.nextLine();

                    System.out.print("Novo sexo (M/F): ");
                    char novoSexo = sc.next().charAt(0);

                    Usuario atualizar = new Usuario(codUpdate, novoLogin, novaSenha, novoSexo);

                    if (usuarioDAO.update(atualizar)) {
                        System.out.println("Usuário atualizado!");
                    }
                    break;

                case 4:
                    System.out.print("Código do usuário para excluir: ");
                    int codDelete = sc.nextInt();

                    if (usuarioDAO.delete(codDelete)) {
                        System.out.println("Usuário removido!");
                    }
                    break;

                case 5:
                    System.out.println("Saiu do Programa.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}