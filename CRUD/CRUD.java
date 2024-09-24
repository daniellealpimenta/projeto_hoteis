package CRUD;

import CONEXAODB.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUD {

    private String tabela;
    private String atributo;
    private String valor;
    private String valorAntigo;
    private String valorNovo;
    private String atributoNovo;
    private String atributoAntigo;

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValorAntigo() {
        return valorAntigo;
    }

    public void setValorAntigo(String valorAntigo) {
        this.valorAntigo = valorAntigo;
    }

    public String getValorNovo() {
        return valorNovo;
    }

    public void setValorNovo(String valorNovo) {
        this.valorNovo = valorNovo;
    }

    public String getAtributoNovo() {
        return atributoNovo;
    }

    public void setAtributoNovo(String atributoNovo) {
        this.atributoNovo = atributoNovo;
    }

    public String getAtributoAntigo() {
        return atributoAntigo;
    }

    public void setAtributoAntigo(String atributoAntigo) {
        this.atributoAntigo = atributoAntigo;
    }

    private int opcao;
    public static boolean ligado = true;

    public int getOpcao() {
        return opcao;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void desligar() {
        ligado = false;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public void insert(String tabela, String atributo, String valor) {
        String sql = "INSERT INTO " + getTabela() + " (" + getAtributo() + ") VALUES (?)";
        Connection conn = null;

        try {
            conn = new DB().conectarDB(); // Use seu método de conexão
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, valor);
                stmt.executeUpdate();
                System.out.println("Registro foi adicionado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void drop(String tabela, int id) {

        String sql = "DELETE FROM " + getTabela() + " WHERE id = ?";
        Connection conn = null;

        try {
            conn = new DB().conectarDB();
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("Registro foi removido com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void update(String tabela, int id, String atributo, String novoValor) {
        String sql = "UPDATE " + getTabela() + " SET " + getValorNovo() + " WHERE = " + getValorAntigo();
        Connection conn = null;

        try {
            conn = new DB().conectarDB();
            try (PreparedStatement stmt = conn.prepareStatement(sql)) { // aqui estamos evitando o sql injection
                stmt.setString(1, novoValor);
                stmt.setInt(2, id);
                stmt.executeUpdate();
                System.out.println("Registro atualizado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void select(String tabela) {
        String sql = "SELECT * FROM " + getTabela();
        Connection conn = null;

        try {
            conn = new DB().conectarDB();
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    // Supondo que sua tabela tenha uma coluna "id" e "atributo"
                    System.out.println("ID: " + rs.getInt("id") + ", Atributo: " + rs.getString("atributo"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
