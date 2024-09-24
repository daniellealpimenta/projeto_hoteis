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
                            5 - SERVICO FUNCIONARIO
                            6 - INFORMACAO RESERVA
                            
                            """);
                    crud.setOpcao(ler.nextInt());
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
                    break;
                case 4:
                    System.out.println("""
                            
                            ------ SELECIONAR ------
                            
                            QUAL TABELA VOCÊ GOSTARIA DE SELECIONAR AS INFORMAÇÕES?
                            
                            1 - CLIENTE
                            2 - QUARTO
                            3 - FUNCIONARIO
                            4 - SERVICO FUNCIONARIO
                            5 - INFORMACAO RESERVA
                            
                            """);
                    break;
                case 5:
                    System.exit(0);
                    crud.desligar();
                    break;
            }
        }
    }
}