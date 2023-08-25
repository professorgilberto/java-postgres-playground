package com.example;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBd {
    public static void main(String[] args) {
    try {
        Class.forName("org.postgresql.Driver");
        var conn = DriverManager.getConnection("jdbc:sqlite:banco.db");
        System.out.println("conexao ok");
        var statement = conn.createStatement();
        statement.executeUpdate("DROP TABLE IF EXISTS Produtos");
        statement.executeUpdate("CREATE TABLE Produtos (id INTEGER, nome STRING, Marca STRING, Valor Numeric)");
        statement.executeUpdate("INSERT INTO Produtos VALUES(1, 'Blevers1', 'Marca1',12.3)");
        statement.executeUpdate("INSERT INTO Produtos VALUES(2, 'Blevers2', 'Marca2',22.3)");
        System.out.println("Antes Update");
        exibeBD(statement);
        statement.executeUpdate("UPDATE Produtos SET nome = 'BleversUPD' WHERE id=1");
        System.out.println("Depois Update");
        exibeBD(statement); 

        conn.close();
        }
    catch (ClassNotFoundException e ) {
        System.err.println("Erro no acesso" + e.getMessage());
    }
    catch (SQLException e ) {
        System.err.println("Erro na conexão" + e.getMessage());
    }
    }

    static void exibeBD(final Statement statement){
    
    try {
        final ResultSet rs = statement.executeQuery("SELECT * FROM Produtos");
        while(rs.next()) {
          // Ler os dados inseridos
          System.out.println("IDENTIFICAÇÃO : " + rs.getInt("id")); 
          System.out.println("NOME DO PRODUTO  : " + rs.getString("nome"));
          System.out.println("MARCA  : " + rs.getString("MARCA"));
          System.out.println("VALOR  : " + rs.getDouble("Valor"));

        }
    } catch (SQLException e) {
        System.err.println("Erro na conexão" + e.getMessage());
    }
    }
}
