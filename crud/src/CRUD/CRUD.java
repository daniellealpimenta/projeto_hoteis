package CRUD;

import CONEXAODB.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {

    private String tabela;

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public void insert(String[] colunas, String[] valores) {
        // Gera a string de parâmetros "? , ?" com o tamanho correto
        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < valores.length; i++) {
            placeholders.append("?");
            if (i < valores.length - 1) {
                placeholders.append(", ");
            }
        }

        String sql = "INSERT INTO " + tabela + " (" + String.join(", ", colunas) + ") VALUES (" + placeholders.toString() + ")";

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


    public void update(String atributo, String valorAntigo, String valorNovo) {
        String sql = "UPDATE " + tabela + " SET " + atributo + " = ? WHERE " + atributo + " = ?";

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
        String colunaId;

        switch (tabela) {
            case "cliente":
                colunaId = "idcliente";
                break;
            case "quarto":
                colunaId = "idquarto"; // Substitua pelo nome correto
                break;
            case "funcionario":
                colunaId = "idfuncionario"; // Substitua pelo nome correto
                break;
            case "servico_funcionario":
                colunaId = "idservico"; // Substitua pelo nome correto
                break;
            case "informacao_reserva":
                colunaId = "idreserva"; // Substitua pelo nome correto
                break;
            default:
                System.out.println("Tabela inválida!");
                return;
        }

        String sql = "DELETE FROM " + tabela + " WHERE " + colunaId + " = ?";
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

        try (Connection conn = new DB().conectarDB()) {
            if (conn == null) {
                System.out.println("Conexão não estabelecida. Verifique a configuração do banco de dados.");
                return;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    switch (tabela) {
                        case "cliente":
                            System.out.println("ID: " + rs.getInt("idcliente") + ", Nome: " + rs.getString("nome"));
                            break;
                        case "quarto":
                            System.out.println("ID: " + rs.getInt("idquarto") + ", Numero: " + rs.getInt("numero"));
                            break;
                        case "funcionario":
                            System.out.println("ID: " + rs.getInt("idfuncionario") + ", Nome: " + rs.getString("nome") + ", Cargo: " + rs.getString("cargo"));
                            break;
                        case "cartao_acesso":
                            System.out.println("ID: " + rs.getInt("idcartao") + ", Numero Cartão: " + rs.getString("numero_cartao"));
                            break;
                        case "servico_funcionario":
                            System.out.println("Duração do Serviço: " + rs.getFloat("duracao_servico") + ", Tipo do Serviço: " + rs.getString("tipo_servico"));
                            break;
                        case "informacao_reserva":
                            System.out.println("Data de ínicio: " + rs.getDate("data_inicio_reserva") + ", Data Final: " + rs.getDate("data_fim_reserva"));
                            break;
                        default:
                            System.out.println("Tabela inválida!");
                            return;
                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
