package CRUD;

import java.util.Scanner;

public class CRUD {

    private int opcao;
    public static boolean ligado = true;


    public int getOpcao() {
        return opcao;
    }
    public boolean isLigado() {
        return ligado;
    }

    public void desligar(){
        ligado = false;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

//    public void insert(tabela, atributo, valor) {
//
//    }
//
//    public void drop(tabela, valor) {
//
//    }
//
//    public void update(tabela, valor_antigo, valor_novo) {
//
//    }

}
