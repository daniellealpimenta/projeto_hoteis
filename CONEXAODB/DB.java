package CONEXAODB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    //Isso aqui são os dados que usamos para conectar com o banco de dados
    String url = "jdbc:mysql://localhost:3306/hotel_transilvania";
    String usuario = "root";
    String senha = "catolica";

    public Connection conectarDB(){
        Connection connection = null;

        try {
            //Carregando Driver do banco de dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Criando conexão com banco de dados
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch(ClassNotFoundException | SQLException e){
            System.out.println("Driver não encontrado " + e.getMessage());
        }

        return connection;
    }

}