package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.AppBdRef;

public class DAO {

    private Connection conn;
    
    public DAO(Connection conn) {
        this.conn = conn;
    } 

    public void exibeBD(String Tabela){
    
    try {
        var sql="SELECT * FROM " + Tabela;
        var statement=conn.createStatement();
        final ResultSet rs = statement.executeQuery(sql);
        int cols=rs.getMetaData().getColumnCount();
        for (int i = 1; i < cols+1; i++) {
            System.out.printf("%-15s | ",rs.getMetaData().getColumnName(i));
          }
          System.out.println();          
        while(rs.next()) {
          for (int i = 1; i < cols+1; i++) {
            System.out.printf("%-15s | ",rs.getString(i));
          }
          System.out.println();
    
    
          //System.out.println("IDENTIFICAÇÃO : " + rs.getInt("id")); 
          //System.out.println("NOME DO PRODUTO  : " + rs.getString("nome"));
          //System.out.println("MARCA  : " + rs.getString("MARCA"));
          //System.out.println("VALOR  : " + rs.getDouble("Valor"));
    
        }
    } catch (SQLException e) {
        System.err.println("Erro na conexão" + e.getMessage());
    }

   }

    public void criaTabela(Connection conn){
    
        try {
            var statement1=conn.createStatement();
            statement1.executeUpdate("DROP TABLE  IF EXISTS PRODUTOS;");
            statement1.executeUpdate("CREATE TABLE PRODUTOS ( ID INTEGER PRIMARY KEY AUTOINCREMENT,NOME STRING,MARCA STRING ,VALOR DECIMAL );");
            System.err.println("Tabela criada com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro na criação da tabela "+ e.getMessage());
        }
    }
    
}
