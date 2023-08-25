package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBdRef {
    public static void main(String[] args) {
        new AppBdRef();
    }
    public AppBdRef(){
        try (var conn = getConnection();){
            exibeMSG("conexao com o banco estabelecida com sucesso");

            criaTabela(conn);
            Produtos produto1=new Produtos();
            Produtos produto2=new Produtos();
            Produtos produto3=new Produtos();
            Produtos produto4=new Produtos();

            produto1.setId(1);
            produto1.setMarca("marca1");
            produto1.setNome("nome1");
            produto1.setValor(12.2);
            
            produto2.setId(2);
            produto2.setMarca("marca2");
            produto2.setNome("nome2");
            produto2.setValor(22.2);

            produto3.setId(3);
            produto3.setMarca("marca3");
            produto3.setNome("nome3");
            produto3.setValor(32.2);

            produto4.setId(4);
            produto4.setMarca("marca4");
            produto4.setValor(42.2);

            insereProduto(conn,produto1);
            insereProduto(conn,produto2);
            insereProduto(conn,produto3);            
            insereProduto(conn,produto4);

            var statement = conn.createStatement();
            //statement.executeUpdate("INSERT INTO Produtos (NOME,MARCA,VALOR) VALUES('Blevers1', 'Marca1',12.3);");
            //statement.executeUpdate("INSERT INTO Produtos (NOME,MARCA,VALOR) VALUES('Blevers2', 'Marca2',22.3);");
            //statement.executeUpdate("INSERT INTO Produtos (NOME,MARCA,VALOR) VALUES('Blevers3', 'Marca3',33.3);");
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

    private void insereProduto(Connection conn, Produtos produto) {

        String sql = "Insert into Produtos (Nome,Marca,valor) values (?,?,?)";
        try (var statement=conn.prepareStatement(sql);) {
            statement.setString(1,produto.getNome());
            statement.setString(2,produto.getMarca());
            statement.setDouble(3,produto.getValor());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro na inserção "+e.getMessage());
        }
      }




    private static Connection getConnection() throws SQLException  {
        return (DriverManager.getConnection("jdbc:sqlite:banco.db"));   
    }




    private static void exibeBD(final Statement statement){
    
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
    private static void exibeMSG(String MSG){
            System.out.println();   
            System.out.println(MSG);
            System.out.println();
        }

    private static void criaTabela(Connection conn){

            try {
                var statement1=conn.createStatement();
                statement1.executeUpdate("DROP TABLE  IF EXISTS PRODUTOS;");
                statement1.executeUpdate("CREATE TABLE PRODUTOS ( ID INTEGER PRIMARY KEY AUTOINCREMENT,NOME STRING,MARCA STRING ,VALOR DECIMAL );");
                exibeMSG("Tabela criada com sucesso!");
            } catch (Exception e) {
                System.err.println("Erro na criação da tabela "+ e.getMessage());
            }
        }


}
