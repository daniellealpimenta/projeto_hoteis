package CONEXAODB;

import CRUD.CRUD;

import java.util.Scanner;

public class Main {

    static boolean ligado = true;
    static int opcao;

    public static void main(String[] args) {
        CRUD crud = new CRUD();
        DB conection = new DB();

        conection.conectarDB();

        Scanner ler = new Scanner(System.in);

        while (ligado) {

            System.out.println("""
                    
                    ------ MENU DE OPÇÕES ------

                    1 - ADICIONAR
                    2 - REMOVER
                    3 - EDITAR
                    4 - SELECIONAR
                    5 - SAIR
                    
                    """);

            opcao = ler.nextInt();
            ler.nextLine(); // Consumir o '\n' após o nextInt()

            switch (opcao) {

                case 1:
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
                    ler.nextLine(); // Consumir o '\n' após o nextInt()

                    if (opcao == 1) {

                        crud.setTabela("cliente");
                        System.out.println("""
                                ------ ATRIBUTOS ------
                                
                                nome, telefone_contato, cpf, endereco, idade, email
                                
                                ESCREVA OS VALORES DOS ATRIBUTOS NA ORDEM ACIMA:
                                """);
                        String valores = ler.nextLine();
                        crud.setValor(valores);
                        crud.insert();

                    } else if (opcao == 2) {

                        crud.setTabela("quarto");
                        System.out.println("""
                                ------ ATRIBUTOS ------
                                
                                numero, capacidade, classificacao, preco, categoria
                                
                                ESCREVA OS VALORES DOS ATRIBUTOS NA ORDEM ACIMA:
                                """);
                        String valores = ler.nextLine();
                        crud.setValor(valores);
                        crud.insert();

                    } else if (opcao == 3) {

                        crud.setTabela("funcionario");
                        System.out.println("""
                                ------ ATRIBUTOS ------
                                
                                nome, cargo, salario, datadenasc
                                
                                ESCREVA OS VALORES DOS ATRIBUTOS NA ORDEM ACIMA:
                                """);
                        String valores = ler.nextLine();
                        crud.setValor(valores);
                        crud.insert();

                    } else if (opcao == 4) {

                        crud.setTabela("servico_funcionario");
                        System.out.println("""
                                ------ ATRIBUTOS ------
                                
                                duracao_servico, tipo_servico
                                
                                ESCREVA OS VALORES DOS ATRIBUTOS NA ORDEM ACIMA:
                                """);
                        String valores = ler.nextLine();
                        crud.setValor(valores);
                        crud.insert();

                    } else if (opcao == 5) {

                        crud.setTabela("informacao_reserva");
                        System.out.println("""
                                ------ ATRIBUTOS ------
                                
                                data_inicio_reserva, data_fim_reserva, valor
                                
                                ESCREVA OS VALORES DOS ATRIBUTOS NA ORDEM ACIMA:
                                """);
                        String valores = ler.nextLine();
                        crud.setValor(valores);
                        crud.insert();

                    }
                    break;

                case 2:
                    System.out.println("""
                            
                            ------ REMOVER ------
                            
                            QUAL TABELA VOCÊ GOSTARIA DE REMOVER INFORMAÇÕES?
                            
                            1 - CLIENTE
                            2 - QUARTO
                            3 - FUNCIONARIO
                            4 - SERVICO FUNCIONARIO
                            5 - INFORMACAO RESERVA
                            
                            """);
                    opcao = ler.nextInt();
                    ler.nextLine(); // Consumir o '\n' após o nextInt()

                    System.out.println("QUAL O ID DO VALOR QUE VOCÊ GOSTARIA DE REMOVER?");
                    int id = ler.nextInt();
                    ler.nextLine(); // Consumir o '\n' após o nextInt()

                    if (opcao == 1) {
                        crud.setTabela("cliente");
                        crud.drop(id);

                    } else if (opcao == 2) {
                        crud.setTabela("quarto");
                        crud.drop(id);

                    } else if (opcao == 3) {
                        crud.setTabela("funcionario");
                        crud.drop(id);

                    } else if (opcao == 4) {
                        crud.setTabela("servico_funcionario");
                        crud.drop(id);

                    } else if (opcao == 5) {
                        crud.setTabela("informacao_reserva");
                        crud.drop(id);
                    }

                    break;

                case 3:
                    System.out.println("""
                            
                            ------ EDITAR ------
                            
                            QUAL TABELA VOCÊ GOSTARIA DE EDITAR INFORMAÇÕES?
                            
                            1 - CLIENTE
                            2 - QUARTO
                            3 - FUNCIONARIO
                            4 - SERVICO FUNCIONARIO
                            5 - INFORMACAO RESERVA
                            
                            """);
                    opcao = ler.nextInt();
                    ler.nextLine(); // Consumir o '\n' após o nextInt()

                    System.out.println("QUAL O VALOR ANTIGO QUE VOCÊ GOSTARIA DE ALTERAR?");
                    String valorAntigo = ler.nextLine();
                    System.out.println("QUAL O NOVO VALOR?");
                    String valorNovo = ler.nextLine();

                    if (opcao == 1) {
                        crud.setTabela("cliente");
                        crud.setValorAntigo(valorAntigo);
                        crud.setValorNovo(valorNovo);
                        crud.update();

                    } else if (opcao == 2) {
                        crud.setTabela("quarto");
                        crud.setValorAntigo(valorAntigo);
                        crud.setValorNovo(valorNovo);
                        crud.update();

                    } else if (opcao == 3) {
                        crud.setTabela("funcionario");
                        crud.setValorAntigo(valorAntigo);
                        crud.setValorNovo(valorNovo);
                        crud.update();

                    } else if (opcao == 4) {
                        crud.setTabela("servico_funcionario");
                        crud.setValorAntigo(valorAntigo);
                        crud.setValorNovo(valorNovo);
                        crud.update();

                    } else if (opcao == 5) {
                        crud.setTabela("informacao_reserva");
                        crud.setValorAntigo(valorAntigo);
                        crud.setValorNovo(valorNovo);
                        crud.update();
                    }

                    break;

                case 4:
                    System.out.println("""
                            
                            ------ SELECIONAR ------
                            
                            QUAL TABELA VOCÊ GOSTARIA DE SELECIONAR AS INFORMAÇÕES?
                            
                            1 - CLIENTE
                            2 - QUARTO
                            3 - FUNCIONARIO
                            4 - CARTAO DE ACESSO
                            5 - SERVICO FUNCIONARIO
                            6 - INFORMACAO RESERVA
                            
                            """);
                    opcao = ler.nextInt();
                    ler.nextLine(); // Consumir o '\n' após o nextInt()

                    if (opcao == 1) {
                        crud.setTabela("cliente");
                        crud.select();

                    } else if (opcao == 2) {
                        crud.setTabela("quarto");
                        crud.select();

                    } else if (opcao == 3) {
                        crud.setTabela("funcionario");
                        crud.select();

                    } else if (opcao == 4) {
                        crud.setTabela("cartao_acesso");
                        crud.select();

                    } else if (opcao == 5) {
                        crud.setTabela("servico_funcionario");
                        crud.select();

                    } else if (opcao == 6) {
                        crud.setTabela("informacao_reserva");
                        crud.select();
                    }

                    break;

                case 5:
                    System.out.println("Saindo do sistema...");
                    ligado = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        ler.close();
    }
}
