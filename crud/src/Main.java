import CONEXAODB.DB;
import CRUD.CRUD;

import java.util.Scanner;
import java.sql.Connection;
import java.util.InputMismatchException;

public class Main {

    static boolean ligado = true;
    static int opcao;

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        DB conection = new DB();
        Connection connection = conection.conectarDB();
        if (connection == null) {
            System.out.println("Falha ao conectar ao banco de dados. O programa será encerrado.");
            return; // Encerra o programa se não houver conexão
        }

        CRUD crud = new CRUD();

        while (ligado) {
            System.out.println("""
                    ------ MENU DE OPÇÕES ------
                    1 - ADICIONAR
                    2 - REMOVER
                    3 - EDITAR
                    4 - SELECIONAR
                    5 - SAIR
                    """);

            try {
                opcao = ler.nextInt();
                ler.nextLine(); // Consumir o '\n'

                switch (opcao) {
                    case 1:
                        // Adicionar registro
                        System.out.println("""
                                ------ ADICIONAR ------
                                QUAL TABELA VOCÊ GOSTARIA DE ADICIONAR INFORMAÇÕES?
                                1 - CLIENTE
                                2 - QUARTO
                                3 - FUNCIONARIO
                                4 - SERVICO FUNCIONARIO
                                5 - INFORMACAO RESERVA
                                """);
                        opcao = ler.nextInt();
                        ler.nextLine();

                        String[] colunas = null;
                        String[] valores;

                        switch (opcao) {
                            case 1:
                                crud.setTabela("cliente");
                                colunas = new String[]{"nome", "telefone_contato", "cpf", "endereco", "idade", "email"};
                                break;
                            case 2:
                                crud.setTabela("quarto");
                                colunas = new String[]{"numero", "capacidade", "classificacao", "preco", "categoria"};
                                break;
                            case 3:
                                crud.setTabela("funcionario");
                                colunas = new String[]{"nome", "cargo", "salario", "datadenasc"};
                                break;
                            case 4:
                                crud.setTabela("servico_funcionario");
                                colunas = new String[]{"duracao_servico", "tipo_servico", "idfuncionario", "idcliente"};
                                break;
                            case 5:
                                crud.setTabela("informacao_reserva");
                                colunas = new String[]{"data_inicio_reserva", "data_fim_reserva", "valor", "idquarto"};
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                continue;
                        }

                        valores = new String[colunas.length];
                        for (int i = 0; i < colunas.length; i++) {
                            System.out.printf("Digite o valor para %s: ", colunas[i]);
                            valores[i] = ler.nextLine();
                        }
                        crud.insert(colunas, valores);
                        break;

                    case 2:
                        // Remover registro
                        System.out.println("Qual tabela você gostaria de remover informações?\n");
                        System.out.println("""
                                ------ REMOVER ------
                                QUAL TABELA VOCÊ GOSTARIA DE ADICIONAR INFORMAÇÕES?
                                1 - CLIENTE
                                2 - QUARTO
                                3 - FUNCIONARIO
                                4 - SERVICO FUNCIONARIO
                                5 - INFORMACAO RESERVA
                                """);
                        int idOpcao = ler.nextInt();
                        System.out.println("Qual o ID do valor que você gostaria de remover?");
                        int id = ler.nextInt();
                        ler.nextLine();

                        switch (idOpcao) {
                            case 1:
                                crud.setTabela("cliente");
                                break;
                            case 2:
                                crud.setTabela("quarto");
                                break;
                            case 3:
                                crud.setTabela("funcionario");
                                break;
                            case 4:
                                crud.setTabela("servico_funcionario");
                                break;
                            case 5:
                                crud.setTabela("informacao_reserva");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                continue;
                        }

                        crud.drop(id);
                        break;

                    case 3:
                        // Editar registro
                        System.out.println("Qual tabela você gostaria de editar informações?\n");
                        System.out.println("""
                                ------ EDITAR ------
                                QUAL TABELA VOCÊ GOSTARIA DE ADICIONAR INFORMAÇÕES?
                                1 - CLIENTE
                                2 - QUARTO
                                3 - FUNCIONARIO
                                4 - SERVICO FUNCIONARIO
                                5 - INFORMACAO RESERVA
                                """);
                        int editOpcao = ler.nextInt();
                        System.out.println("Qual o atributo que você gostaria de alterar?");
                        String atributo = ler.next();
                        System.out.println("Qual o valor antigo que você gostaria de alterar?");
                        String valorAntigo = ler.next();
                        System.out.println("Qual o novo valor?");
                        String valorNovo = ler.next();

                        switch (editOpcao) {
                            case 1:
                                crud.setTabela("cliente");
                                break;
                            case 2:
                                crud.setTabela("quarto");
                                break;
                            case 3:
                                crud.setTabela("funcionario");
                                break;
                            case 4:
                                crud.setTabela("servico_funcionario");
                                break;
                            case 5:
                                crud.setTabela("informacao_reserva");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                continue;
                        }

                        crud.update(atributo, valorAntigo, valorNovo);
                        break;

                    case 4:
                        // Selecionar registro
                        System.out.println("Qual tabela você gostaria de selecionar as informações?\n");
                        System.out.println("""
                                ------ SELECIONAR ------
                                QUAL TABELA VOCÊ GOSTARIA DE ADICIONAR INFORMAÇÕES?
                                1 - CLIENTE
                                2 - QUARTO
                                3 - FUNCIONARIO
                                4 - CARTÃO ACESSO
                                5 - SERVICO FUNCIONARIO
                                6 - INFORMACAO RESERVA
                                """);
                        int selectOpcao = ler.nextInt();
                        ler.nextLine();

                        switch (selectOpcao) {
                            case 1:
                                crud.setTabela("cliente");
                                break;
                            case 2:
                                crud.setTabela("quarto");
                                break;
                            case 3:
                                crud.setTabela("funcionario");
                                break;
                            case 4:
                                crud.setTabela("cartao_acesso");
                                break;
                            case 5:
                                crud.setTabela("servico_funcionario");
                                break;
                            case 6:
                                crud.setTabela("informacao_reserva");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                continue;
                        }

                        crud.select();
                        break;

                    case 5:
                        System.out.println("Saindo do sistema...");
                        ligado = false;
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
                ler.nextLine(); // Limpar o buffer
            }
        }

        ler.close();
    }
}
