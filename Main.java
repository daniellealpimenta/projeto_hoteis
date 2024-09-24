import CONEXAODB.DB;
import CRUD.CRUD;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CRUD crud = new CRUD();
        DB conection = new DB();

        conection.conectarDB();

        Scanner ler = new Scanner(System.in);

        while (crud.isLigado()) {

            System.out.println("""
                    
                    ------ MENU DE OPÇÕES ------
                    
                    1 - ADICIONAR
                    2 - REMOVER
                    3 - EDITAR
                    4 - SELECIONAR
                    5 - SAIR
                    
                    """);

            crud.setOpcao(ler.nextInt());

            switch (crud.getOpcao()) {

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
                    crud.setOpcao(ler.nextInt());

                    if (crud.getOpcao() == 1) {

                        crud.setTabela("cliente");
                        System.out.println("""
                                ------ ATRIBUTOS ------
                                
                                -nome
                                -telefone_contato
                                -cpf
                                -endereco
                                -idade
                                -email
                             
                                ESCREVA QUAIS ATRIBUTOS VOCÊ DESEJA ACRESCENTAR:
                                """);
                        ler.nextLine();
                        crud.setAtributo(ler.nextLine());

                        System.out.println("QUAL OS VALORES DOS ATRIBUTOS SELECIONADOS? (ESCREVA)");
                        crud.setValor(ler.nextLine());

                        crud.insert();

                    } else if (crud.getOpcao() == 2) {

                        crud.setTabela("quarto");
                        System.out.println("""
                                ------ ATRIBUTOS ------
                                
                                -numero
                                -capacidade
                                -classificacao
                                -preco
                                -categoria
                             
                                ESCREVA QUAIS ATRIBUTOS VOCÊ DESEJA ACRESCENTAR:
                                """);
                        ler.nextLine();
                        crud.setAtributo(ler.nextLine());

                        System.out.println("QUAL OS VALORES DOS ATRIBUTOS SELECIONADOS? (ESCREVA)");
                        crud.setValor(ler.nextLine());

                        crud.insert();

                    } else if (crud.getOpcao() == 3) {

                        crud.setTabela("funcionario");
                        System.out.println("""
                                ------ ATRIBUTOS ------
                                
                                -nome
                                -cargo
                                -salario
                                -datadenasc
                             
                                ESCREVA QUAIS ATRIBUTOS VOCÊ DESEJA ACRESCENTAR:
                                """);
                        ler.nextLine();
                        crud.setAtributo(ler.nextLine());

                        System.out.println("QUAL OS VALORES DOS ATRIBUTOS SELECIONADOS? (ESCREVA)");
                        crud.setValor(ler.nextLine());

                        crud.insert();

                    } else if (crud.getOpcao() == 4) {

                        crud.setTabela("servico_funcionario");
                        System.out.println("""
                                ------ ATRIBUTOS ------
                                
                                -duracao_servico
                                -tipo_servico
                             
                                ESCREVA QUAIS ATRIBUTOS VOCÊ DESEJA ACRESCENTAR:
                                """);
                        ler.nextLine();
                        crud.setAtributo(ler.nextLine());

                        System.out.println("QUAL OS VALORES DOS ATRIBUTOS SELECIONADOS? (ESCREVA)");
                        crud.setValor(ler.nextLine());

                        crud.insert();

                    } else if (crud.getOpcao() == 5) {

                        crud.setTabela("informacao_reserva");
                        System.out.println("""
                                ------ ATRIBUTOS ------
                                
                                -data_inicio_reserva
                                -data_fim_reserva
                                -valor
                             
                                ESCREVA QUAIS ATRIBUTOS VOCÊ DESEJA ACRESCENTAR:
                                """);
                        ler.nextLine();
                        crud.setAtributo(ler.nextLine());

                        System.out.println("QUAL OS VALORES DOS ATRIBUTOS SELECIONADOS? (ESCREVA)");
                        crud.setValor(ler.nextLine());

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
                    crud.setOpcao(ler.nextInt());

                    int id;

                    if (crud.getOpcao() == 1) {
                        crud.setTabela("cliente");
                        System.out.println("QUAL O ID DO VALOR QUE VOCÊ GOSTARIA DE REMOVER?");
                        ler.nextLine();
                        id = ler.nextInt();

                        crud.drop(id);

                    } else if (crud.getOpcao() == 2) {
                        crud.setTabela("quarto");
                        System.out.println("QUAL O ID DO VALOR QUE VOCÊ GOSTARIA DE REMOVER?");
                        ler.nextLine();
                        id = ler.nextInt();

                        crud.drop(id);

                    } else if (crud.getOpcao() == 3) {
                        crud.setTabela("funcionario");
                        System.out.println("QUAL O ID DO VALOR QUE VOCÊ GOSTARIA DE REMOVER?");
                        ler.nextLine();
                        id = ler.nextInt();

                        crud.drop(id);

                    } else if (crud.getOpcao() == 4) {
                        crud.setTabela("servico_funcionario");
                        System.out.println("QUAL O ID DO VALOR QUE VOCÊ GOSTARIA DE REMOVER?");
                        ler.nextLine();
                        id = ler.nextInt();

                        crud.drop(id);

                    } else if (crud.getOpcao() == 5) {
                        crud.setTabela("informacao_reserva");
                        System.out.println("QUAL O ID DO VALOR QUE VOCÊ GOSTARIA DE REMOVER?");
                        ler.nextLine();
                        id = ler.nextInt();

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
                    crud.setOpcao(ler.nextInt());
                    if (crud.getOpcao() == 1) {

                        crud.setTabela("cliente");
                        System.out.println("QUAL O ATRIBUTO ANTIGO QUE VOCÊ GOSTARIA DE ALTERAR? (ESCREVA)");
                        ler.nextLine();
                        crud.setValorAntigo(ler.nextLine());
                        System.out.println("QUAL O ATRIBUTO NOVO QUE VOCÊ GOSTARIA DE COLOCAR? (ESCREVA)");
                        crud.setValorNovo(ler.nextLine());

                        crud.update();

                    } else if (crud.getOpcao() == 2) {
                        crud.setTabela("quarto");
                        System.out.println("QUAL O ATRIBUTO ANTIGO QUE VOCÊ GOSTARIA DE ALTERAR? (ESCREVA)");
                        ler.nextLine();
                        crud.setValorAntigo(ler.nextLine());
                        System.out.println("QUAL O ATRIBUTO NOVO QUE VOCÊ GOSTARIA DE COLOCAR? (ESCREVA)");
                        crud.setValorNovo(ler.nextLine());

                        crud.update();

                    } else if (crud.getOpcao() == 3) {
                        crud.setTabela("funcionario");
                        System.out.println("QUAL O ATRIBUTO ANTIGO QUE VOCÊ GOSTARIA DE ALTERAR? (ESCREVA)");
                        ler.nextLine();
                        crud.setValorAntigo(ler.nextLine());
                        System.out.println("QUAL O ATRIBUTO NOVO QUE VOCÊ GOSTARIA DE COLOCAR? (ESCREVA)");
                        crud.setValorNovo(ler.nextLine());

                        crud.update();

                    } else if (crud.getOpcao() == 4) {
                        crud.setTabela("servico_funcionario");
                        System.out.println("QUAL O ATRIBUTO ANTIGO QUE VOCÊ GOSTARIA DE ALTERAR? (ESCREVA)");
                        ler.nextLine();
                        crud.setValorAntigo(ler.nextLine());
                        System.out.println("QUAL O ATRIBUTO NOVO QUE VOCÊ GOSTARIA DE COLOCAR? (ESCREVA)");
                        crud.setValorNovo(ler.nextLine());

                        crud.update();

                    } else if (crud.getOpcao() == 5) {
                        crud.setTabela("informacao_reserva");
                        System.out.println("QUAL O ATRIBUTO ANTIGO QUE VOCÊ GOSTARIA DE ALTERAR? (ESCREVA)");
                        ler.nextLine();
                        crud.setValorAntigo(ler.nextLine());
                        System.out.println("QUAL O ATRIBUTO NOVO QUE VOCÊ GOSTARIA DE COLOCAR? (ESCREVA)");
                        crud.setValorNovo(ler.nextLine());

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
                    crud.setOpcao(ler.nextInt());

                    if (crud.getOpcao() == 1) {
                        crud.setTabela("cliente");

                        crud.select();

                    } else if (crud.getOpcao() == 2) {
                        crud.setTabela("quarto");

                        crud.select();

                    } else if (crud.getOpcao() == 3) {
                        crud.setTabela("funcionario");

                        crud.select();

                    } else if (crud.getOpcao() == 4) {
                        crud.setTabela("cartao_acesso");

                        crud.select();

                    } else if (crud.getOpcao() == 5) {
                        crud.setTabela("servico_funcionario");

                        crud.select();

                    } else if (crud.getOpcao() == 6) {
                        crud.setTabela("informacao_reserva");

                        crud.select();

                    }
                    break;
                case 5:
                    System.exit(0);
                    crud.desligar();
                    break;
            }
        }
    }
}
