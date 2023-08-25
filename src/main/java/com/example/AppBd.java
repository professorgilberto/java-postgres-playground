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
        statement.executeUpdate("DROP TABLE IF EXISTS terminalroot");
        statement.executeUpdate("CREATE TABLE terminalroot (id INTEGER, name STRING)");
        statement.executeUpdate("INSERT INTO terminalroot VALUES(1, 'Marcos Oliveira')");
        statement.executeUpdate("INSERT INTO terminalroot VALUES(2, 'James Gosling')");
        System.out.println("Antes Update");
        exibeBD(statement);
        statement.executeUpdate("UPDATE terminalroot SET name = 'Blevers' WHERE id=1");
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
        final ResultSet rs = statement.executeQuery("SELECT * FROM terminalroot");
        while(rs.next()) {
          // Ler os dados inseridos
          System.out.println("NOME DO CARA  : " + rs.getString("name"));
          System.out.println("IDENTIFICAÇÃO : " + rs.getInt("id")); 
        }
    } catch (SQLException e) {
        System.err.println("Erro na conexão" + e.getMessage());
    }
    }
}
