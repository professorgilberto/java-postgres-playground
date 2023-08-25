package com.example;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBdRef {
    public static void main(String[] args) {
        new AppBdRef();
    }
    public AppBdRef(){
        try {
            var conn = DriverManager.getConnection("jdbc:sqlite:banco.db");
            exibeMSG("conexao ok");
            var statement = conn.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS Produtos;");
            statement.executeUpdate("CREATE TABLE Produtos (id INTEGER PRIMARY KEY AUTOINCREMENT, nome STRING, Marca STRING, Valor Numeric);");
            statement.executeUpdate("INSERT INTO Produtos (NOME,MARCA,VALOR) VALUES('Blevers1', 'Marca1',12.3);");
            statement.executeUpdate("INSERT INTO Produtos (NOME,MARCA,VALOR) VALUES('Blevers2', 'Marca2',22.3);");
            statement.executeUpdate("INSERT INTO Produtos (NOME,MARCA,VALOR) VALUES('Blevers3', 'Marca3',33.3);");
            exibeMSG("Antes Update");
            exibeBD(statement);
            statement.executeUpdate("UPDATE Produtos SET nome = 'BleversUPD' WHERE id=1;");
            exibeMSG("Depois Update");
            exibeBD(statement); 
            statement.executeUpdate("DELETE from Produtos WHERE id=2;");
            exibeMSG("Depois Delete");
            exibeBD(statement); 
            statement.executeUpdate("INSERT INTO Produtos (NOME,MARCA,VALOR) VALUES('Blevers4', 'Marca4',44.3);");
            exibeMSG("Depois Insert");
            exibeBD(statement); 
    
            conn.close();
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
    static void exibeMSG(String MSG){
            System.out.println();   
            System.out.println(MSG);
            System.out.println();
        }




}
