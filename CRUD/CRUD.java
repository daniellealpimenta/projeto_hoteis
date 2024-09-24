package CRUD;

import CONEXAODB.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {

    private String tabela;
    private String atributo;
    private String valor;
    private String valorAntigo;
    private String valorNovo;

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

    public void insert(String[] colunas, String[] valores) {
        String sql = "INSERT INTO " + getTabela() + " (" + String.join(", ", colunas) + ") VALUES (" + String.join(", ", valores).replaceAll("[^,]+", "?") + ")";

        try (Connection conn = new DB().conectarDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < valores.length; i++) {
                stmt.setString(i + 1, valores[i]);
            }

            stmt.executeUpdate();
            System.out.println("Registro foi adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        String sql = "UPDATE " + getTabela() + " SET " + getAtributo() + " = ? WHERE " + getAtributo() + " = ?";
        try (Connection conn = new DB().conectarDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, valorNovo);
            stmt.setString(2, valorAntigo);
            stmt.executeUpdate();
            System.out.println("Registro atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void drop(int id) {
        String sql = "DELETE FROM " + getTabela() + " WHERE id = ?";
        try (Connection conn = new DB().conectarDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Registro foi removido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select() {
        String sql = "SELECT * FROM " + getTabela();
        try (Connection conn = new DB().conectarDB();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Assumindo que sua tabela tenha uma coluna "id" e "atributo"
                System.out.println("ID: " + rs.getInt("id") + ", Atributo: " + rs.getString(getAtributo()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
