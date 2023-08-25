package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.model.Produtos;

public class DAOprodutos {
    private Connection conn;

    public DAOprodutos(Connection conn) {
        this.conn = conn;
    }

    public void AtualizaProduto(Produtos produto) {
        String sql = "Update PRODUTOS set Nome=? , Marca=? ,valor=? where id=?; ";
        try (var statement=conn.prepareStatement(sql);) {
            statement.setString(1,produto.getNome());
            statement.setString(2,produto.getMarca());
            statement.setDouble(3,produto.getValor());
            statement.setLong(4,produto.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro na Atualização "+e.getMessage());
        }
    }
    
    public void ApagaProduto(Produtos produto) {
        String sql = "Delete FROM Produtos where id=?;";
        try (var statement=conn.prepareStatement(sql);) {
            statement.setLong(1,produto.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao Apagar Registro "+e.getMessage());
        }

    }


    public void insereProduto(Produtos produto) {

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


}
