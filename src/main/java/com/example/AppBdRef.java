package com.example;

import java.sql.SQLException;

import com.example.dao.ConnectionMeu;
import com.example.dao.DAO;
import com.example.dao.DAOprodutos;
import com.example.model.Produtos;


public class AppBdRef {
    public static void main(String[] args) {
        new AppBdRef();
    }
    public AppBdRef(){
        try (var conn = ConnectionMeu.getConnection();){
            exibeMSG("conexao com o banco estabelecida com sucesso");

            var DAOP=new DAOprodutos(conn);
            var DAO=new DAO(conn);

            DAO.criaTabela(conn);
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
            produto4.setNome("nome4");            
            produto4.setValor(42.2);

            DAOP.insereProduto(produto1);
            DAOP.insereProduto(produto2);
            DAOP.insereProduto(produto3);                     


            //var statement = conn.createStatement();
            //statement.executeUpdate("INSERT INTO Produtos (NOME,MARCA,VALOR) VALUES('Blevers1', 'Marca1',12.3);");
            //statement.executeUpdate("INSERT INTO Produtos (NOME,MARCA,VALOR) VALUES('Blevers2', 'Marca2',22.3);");
            //statement.executeUpdate("INSERT INTO Produtos (NOME,MARCA,VALOR) VALUES('Blevers3', 'Marca3',33.3);");
            exibeMSG("Antes Update");
            DAO.exibeBD("produtos");

            produto1.setMarca("marcaBlevers");
            produto1.setNome("nomeBlevers");
            produto1.setValor(1232.2);

            DAOP.AtualizaProduto(produto1);
            //AtualizaProduto(conn,produto1);

            //statement.executeUpdate("UPDATE Produtos SET nome = 'BleversUPD' WHERE id=1;");
            exibeMSG("Depois Update");
            DAO.exibeBD("produtos");
            //statement.executeUpdate("DELETE from Produtos WHERE id=2;");
            DAOP.ApagaProduto(produto2);
            exibeMSG("Depois Delete");
            DAO.exibeBD("produtos");
            //statement.executeUpdate("INSERT INTO Produtos (NOME,MARCA,VALOR) VALUES('Blevers4', 'Marca4',44.3);");
            DAOP.insereProduto(produto4);
            exibeMSG("Depois Insert");
            DAO.exibeBD("produtos");
    
            conn.close();
            }
        catch (SQLException e ) {
            System.err.println("Erro na conexão" + e.getMessage());
        }

    }

    public void exibeMSG(String MSG){
            System.out.println();   
            System.out.println(MSG);
            System.out.println();
        }


}
